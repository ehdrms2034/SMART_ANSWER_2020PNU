package com.example.smart_answer.ui.login;

import java.util.List;

public class Data {
    private String username;
    private String password;
    private String name;
    private Id _id;
    private String createdAt;
    private String modifiedAt;
    private List<String> friends;

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getName() {return name;}
    public Id getId() {return _id; };
    public String getCreatedAt() {return createdAt;}
    public String getModifiedAt() {return modifiedAt;}
    public List<String> getFriends() {return friends;}
}
