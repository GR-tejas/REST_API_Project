package com.tejas.notesapi.dto;

public class LoginRequest {
    private String username;
    private String password;

    public String getUsername (){
        return username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public void setPassword (String password) {
        this.password = password;
    }
}
