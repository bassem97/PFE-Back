package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.Greeting;
import com.ats.remotetimemanager.Model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

@Controller
@CrossOrigin("*")
@RequestMapping("/ws")
public class WebSocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("terma , " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
