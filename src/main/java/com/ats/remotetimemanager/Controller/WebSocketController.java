package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.WebSocketMessage;
import com.ats.remotetimemanager.Service.WebSocket.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("*")
@RequestMapping("http://localhost:81/ws")
public class WebSocketController {

    @Autowired
    WebSocketService webSocketService;
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    public void sendMessage(WebSocketMessage message) throws Exception {
        this.simpMessagingTemplate.convertAndSend("/topic/greetings", message);
    }
}
