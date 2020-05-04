package com.smartanswer.ocrproject.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomResponse {

    private String response;
    private String message;
    private Object data;

    public CustomResponse(String response, String message, Object data) {
        this.response = response;
        this.message = message;
        this.data = data;
    }
}
