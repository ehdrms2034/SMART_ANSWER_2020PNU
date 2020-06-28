package com.example.smart_answer.ui.login;

public class LoginPostBody {
    private String name;
    private String password;
    private String username;

    LoginPostBody(String _name, String _password, String _username) {
        this.name = _name;
        this.password = _password;
        this.username = _username;
    }
}
