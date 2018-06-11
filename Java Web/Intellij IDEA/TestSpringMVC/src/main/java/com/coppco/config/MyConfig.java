package com.coppco.config;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.coppco.converter.Date2StringConverter;
import com.coppco.converter.DateConverter;
import com.coppco.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolution;

import javax.servlet.ServletContext;
import java.util.List;


@Configuration //配置类
@EnableWebMvc //开启MVC配置
@ComponentScan("com.coppco")//包扫描
@ImportResource("classpath:applicationContext.xml") //导入配置文件
@EnableScheduling //定时任务
public class MyConfig extends WebMvcConfigurerAdapter {

    //视图解析器
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    //thymeleaf模板
//    @Autowired
//    private ServletContext servletContext;
//
//    @Bean
//    public ServletContextTemplateResolver templateResolver() {
//        ServletContextTemplateResolver servletContextTemplateResolver = new ServletContextTemplateResolver(servletContext);
//        servletContextTemplateResolver.setPrefix("/WEB-INF/");
//        servletContextTemplateResolver.setSuffix(".jsp");
//        servletContextTemplateResolver.setTemplateMode("HTML5");
//        return servletContextTemplateResolver;
//    }
//
//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine engine = new SpringTemplateEngine();
//        engine.setTemplateResolver(templateResolver());
//        return engine;
//    }
//
//    @Bean
//    public ThymeleafViewResolver thymeleafViewResolver() {
//        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//        resolver.setTemplateEngine(templateEngine());
//        return resolver;
//    }


    //静态资源映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
        //addResourceLocations: 文件存放的目录
        //addResourceHandler: 对外暴露的访问路径
        resourceHandlerRegistry.addResourceHandler("/assets/**").addResourceLocations("classpatch:/assets/");
        resourceHandlerRegistry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/js/");
    }

    @Bean
    public TimeInterceptor timeInterceptor() {
        return new TimeInterceptor();
    }

    //添加自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns: 拦截的路径
        registry.addInterceptor(timeInterceptor()).addPathPatterns("/*");
    }

    /**
     * 页面跳转
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/upload").setViewName("upload");
        registry.addViewController("/async").setViewName("async");
    }

    /**
     * 设置文件上传属性
     * @return
     */
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000L);
        multipartResolver.setDefaultEncoding("UTF-8");
        return multipartResolver;
    }

    /**
     * 注入bean
     * @return
     */
    @Bean
    public DateConverter dateConverter() {
        return new DateConverter();
    }

    /**
     * 注入bean
     * @return
     */
    @Bean
    public Date2StringConverter date2StringConverter() {
        return new Date2StringConverter();
    }

    /**
     * 添加自定义类型转换器
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(dateConverter());
        registry.addConverter(date2StringConverter());
    }

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//        /*
//        1.需要先定义一个convert转换消息的对象；
//        2.添加fastjson的配置信息，比如是否要格式化返回的json数据
//        3.在convert中添加配置信息
//        4.将convert添加到converters中
//         */
//        //1.定义一个convert转换消息对象
//        FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverter();
//        //2.添加fastjson的配置信息，比如：是否要格式化返回json数据
//        FastJsonConfig fastJsonConfig=new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(
//                SerializerFeature.PrettyFormat
//        );
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        converters.add(fastConverter);
//    }

    @Bean
    public HttpMessageConverter fastJsonHttpMessageConverters() {
        //1.需要定义一个Convert转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //2.添加fastjson的配置信息，比如是否要格式化返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //3.在convert中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);

        return fastConverter;
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.extendMessageConverters(converters);
        converters.add(fastJsonHttpMessageConverters());
    }
}
