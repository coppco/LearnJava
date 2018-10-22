package com.coppco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
public class TomcatwebsocketApplication {
    public static void main(String[] args) {
        SpringApplication.run(TomcatwebsocketApplication.class, args);
    }

    /**
     * 使用内置Tomcat时需要注入ServerEndpointExporter的Bean, 它会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint
     *
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
