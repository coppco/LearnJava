package com.coppco;

import com.coppco.interceptor.UsernameInterceptor;
import com.coppco.messageHandle.WebSocketMessageHandle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * 实现WebSocketConfigurer
 */
@SpringBootApplication
@EnableWebSocket //允许WebSocket
public class SpringbootwebsocketApplication implements WebSocketConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwebsocketApplication.class, args);
	}

	/**
	 * 第一个addHandler是对正常连接的配置，第二个是如果浏览器不支持websocket，使用socketjs模拟websocket的连接
	 * @param webSocketHandlerRegistry
	 */
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
		webSocketHandlerRegistry.addHandler(new WebSocketMessageHandle(), "/websocket").addInterceptors(new UsernameInterceptor());
		webSocketHandlerRegistry.addHandler(new WebSocketMessageHandle(), "/sockjs/webSocket").addInterceptors(new UsernameInterceptor());
	}



}
