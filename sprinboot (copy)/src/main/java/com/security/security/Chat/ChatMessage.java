package com.security.security.Chat;


import lombok.*;

import java.awt.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {

private String senderName;
private String receiverName;
private String message;
private String date;
private  MessageType status;



}
