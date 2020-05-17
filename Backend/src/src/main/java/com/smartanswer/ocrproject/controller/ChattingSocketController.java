package com.smartanswer.ocrproject.controller;

import com.smartanswer.ocrproject.model.ChatMessage;
import com.smartanswer.ocrproject.model.ChatSocketMessage;
import com.smartanswer.ocrproject.service.ChattingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChattingSocketController {

    @Autowired
    private SimpMessageSendingOperations messageSendingOperations;

    @Autowired
    private ChattingService chattingService;

    @Async
    @MessageMapping("/chat/message")
    public void sendMessage(ChatSocketMessage chatSocketMessage) {
//        System.out.println(chatSocketMessage.getRoomId()+"-" +chatSocketMessage.getUsername()+" : "+chatSocketMessage.getMessage());
        messageSendingOperations.convertAndSend("/sub/chat/room/"+chatSocketMessage.getRoomId(),chatSocketMessage);
        
    }

}
