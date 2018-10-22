package com.coppco.messageHandle;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Scope(value= WebApplicationContext.SCOPE_SESSION)//每次创建一个会话中创建一个实例
public class WebSocketMessageHandle extends TextWebSocketHandler {

    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的
     */
    private static int onlineCount = 0;

    /**
     * 实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
     */
    private static Map<String, WebSocketSession> clients = new ConcurrentHashMap<String, WebSocketSession>();

    /**
     * 连接成功时候，会触发UI上onopen方法
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String username = (String) session.getAttributes().get("username");
        addOnlineCount();
        System.out.println("已连接:  " + username + "session: " + this);
        clients.put((String) session.getAttributes().get("username"), session);

    }


    /**
     * 收到文本消息时，会调用该方法
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String send = (String) session.getAttributes().get("username");
        sendMessageAll(send, message);
    }

    /**
     * 出现错误时，会调用该方法
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        super.handleTransportError(session, exception);
    }

    /**
     * 关闭连接时，会调用该方法
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        String username = (String) session.getAttributes().get("username");
        clients.remove(username);
        System.out.println("已断开: " + username);
        subOnlineCount();
    }


    /**
     * 单发消息
     *
     * @param message
     * @param To
     * @throws IOException
     */
    public void sendMessageTo(TextMessage message, String To) throws IOException {
        for (Map.Entry<String, WebSocketSession> entry : clients.entrySet()) {
            if (entry.getKey().equals(To)) {
                entry.getValue().sendMessage(message);
            }
        }
    }

    /**
     * 群发消息
     *
     * @param message
     * @throws IOException
     */
    public void sendMessageAll(String send, TextMessage message) throws IOException {
        for (String key: clients.keySet()) {
            if (!key.equals(send)) {
                clients.get(key).sendMessage(message);
                System.out.println("" + send + "发送消息给------>" + key + " : 内容  " + message.getPayload());
            }
        };
    }

    @Override
    public boolean supportsPartialMessages() {
        return super.supportsPartialMessages();
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketMessageHandle.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketMessageHandle.onlineCount--;
    }

    public static synchronized Map<String, WebSocketSession> getClients() {
        return clients;
    }

}
