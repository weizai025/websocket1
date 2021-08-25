package com.nju.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maw-b
 * @date 2021/8/25 11:27
 */
@RestController
public class WebsocketController {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/send")
    @SendTo("/topic") // 订阅的消息
    public String say(String msg) {
        return msg;
    }

    @GetMapping("/send")
    public String msgReply(@RequestParam String msg) {
        template.convertAndSend("/topic", msg);
        return msg;
    }
}

