package com.coppco;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) //自动配置注解
@ImportResource("classpath:applicationContext.xml") //导入xml配置文件
@RestController
@PropertySource("classpath:Teacher.properties") //导入properties文件
@EnableConfigurationProperties({Teacher.class}) //允许类型安全的配置
public class Starter {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Starter.class);
        application.setBannerMode(Banner.Mode.LOG);
        application.run(args);
//        SpringApplication.run(com.coppco.Starter.class, args);
//
//        new SpringApplicationBuilder(com.coppco.Starter.class)
//                .bannerMode(Banner.Mode.OFF)
//                .run(args);
    }

    @RequestMapping("/abc")
    public Map<String, Teacher> get() {
        HashMap<String, Teacher> map = new HashMap<>();
        map.put("first", new Teacher("张三", "男"));
        map.put("second", new Teacher("李四", "男"));
        map.put("third", new Teacher("王五", "女"));
        map.put("fourth", new Teacher("赵六", "美元"));
        ;
        return map;
    }

    @RequestMapping("/teacher")
    public Teacher showTeacher() {
        return teacher;
    }

    @Autowired
    private Teacher teacher;

    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        factory.addAdditionalTomcatConnectors(httpConnector());
        return factory;
    }

    //配置http
    private Connector httpConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        Http11NioProtocol http11NioProtocol = (Http11NioProtocol) connector.getProtocolHandler();
        connector.setPort(8081);
        connector.setScheme("http");
        connector.setSecure(false);
        connector.setRedirectPort(8090);
        connector.setAllowTrace(true);
        //设置最大线程数
        http11NioProtocol.setMaxThreads(100);
        //设置初始线程数  最小空闲线程数
        http11NioProtocol.setMinSpareThreads(20);
        //设置超时
        http11NioProtocol.setConnectionTimeout(5000);
        return connector;

    }

}

//@Component
@ConfigurationProperties(prefix = "teacher")
//前缀
class Teacher {
    private String name;
    private String gender;

    public Teacher(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public Teacher() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}