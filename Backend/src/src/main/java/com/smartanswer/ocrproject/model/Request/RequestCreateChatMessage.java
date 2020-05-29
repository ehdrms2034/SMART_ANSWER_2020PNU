package com.smartanswer.ocrproject.model.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestCreateChatMessage {

    public String chatRoomId;
    public String username;
    public String message;

}
