package com.jiaolin.sell.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebScoket {
    private Session session;

    private static CopyOnWriteArraySet<WebScoket> webScoketSet = new CopyOnWriteArraySet();

    /**
     * 打开webscoket
     */
    @OnOpen
    public void onOpen() {
        this.session = session;
        webScoketSet.add(this);
        log.info("[webScoket消息] 有新的连接,连接总数{}", webScoketSet.size());
    }

    @OnClose
    public void onClose() {
        webScoketSet.remove(this);
        log.info("[webScoket消息] 连接断开,总数{}", webScoketSet.size());
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("[webScoket消息]收到客户端发来的消息{}", message);
    }

    public void sendMessage(String message) {
        for (WebScoket webScoket : webScoketSet) {
            log.info("[webScoket消息] 广播消息,message={}", message);
            try {
                webScoket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
