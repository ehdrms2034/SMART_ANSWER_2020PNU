package com.smartanswer.ocrproject.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
public class ChatSocketMessage {

    private String roomId;
    private String username;
    private String message;

    public ChatSocketMessage(String roomId, String username, String message) {
        this.roomId = roomId;
        this.username = username;
        this.message = message;
    }
}
