package com.security.security.Chat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {


    @Autowired
    private  SimpMessagingTemplate simpMessagingTemplate;


    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public  ChatMessage receivePublicMessage(
            @Payload ChatMessage chatMessage
    ){
        return chatMessage;

    }


    @MessageMapping("/private-message")
    @SendTo("/topic/public")
    public  ChatMessage receivePrivateMessage(@Payload ChatMessage chatMessage){
        simpMessagingTemplate.convertAndSendToUser(chatMessage.getReceiverName(),"/private",chatMessage);

        return chatMessage;

    }

}
