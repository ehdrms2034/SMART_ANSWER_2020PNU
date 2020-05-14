package com.smartanswer.ocrproject.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document("ChatMessage")
public class ChatMessage {

    @Id
    private ObjectId _id;

    @DBRef
    private ChattingRoom chattingRoom;

    @DBRef
    private Member member;

    private String message;

    @CreatedDate
    private Date createdDate;

    public ChatMessage(ChattingRoom chattingRoom, Member member, String message) {
        this.chattingRoom = chattingRoom;
        this.member = member;
        this.message = message;
    }
}
