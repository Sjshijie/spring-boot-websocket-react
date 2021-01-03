package com.sj.ws;


import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/chat",configurator = GetHttpSessionConfig.class)
@Component
public class ChatEndpoint {

    private static Map<String,ChatEndpoint> onlineUsers = new ConcurrentHashMap<>();

    private Session session;


    @OnOpen
    public void onOpen(Session session, EndpointConfig config){
        try{
            System.out.print("链接成功");
            this.session = session;
            //把每次链接的用户放到要给mao里
            onlineUsers.put(session.getId(),this);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @OnMessage
    public void onMessage(String message,Session session){
        System.out.print("收到的消息"+message);
        try{
            for(String sessionId : onlineUsers.keySet()){
                //过滤自己的消息
                if(session.getId() != sessionId){
                    ChatEndpoint chatEndpoint = onlineUsers.get(sessionId);
                    chatEndpoint.session.getBasicRemote().sendText(message);
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session){
        System.out.print("链接断开");
        for(String sessionId : onlineUsers.keySet()){
            //删除断开链接的用户
            if(session.getId() == sessionId){
                onlineUsers.remove(sessionId);
            }

        }
    }


}
