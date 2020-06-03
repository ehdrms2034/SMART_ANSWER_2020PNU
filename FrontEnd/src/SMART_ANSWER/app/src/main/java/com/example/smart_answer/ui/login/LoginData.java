package com.example.smart_answer.ui.login;

public class LoginData {
    private String response;
    private String message;
    private Data data;

    public LoginData( String name, String id, Data data) {
        this.response = name;
        this.message = id;
        this.data = data;
    }

    public String getName() {
        return response;
    }
    public String getId() {
        return message;
    }
    public Data getData() {return data;}

}