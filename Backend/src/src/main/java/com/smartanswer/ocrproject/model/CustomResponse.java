package com.smartanswer.ocrproject.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomResponse {

    private String response;
    private String message;
    @JsonInclude(Include.NON_NULL)
    private Object data;

    public CustomResponse(String response, String message, Object data) {
        this.response = response;
        this.message = message;
        this.data = data;
    }
}
