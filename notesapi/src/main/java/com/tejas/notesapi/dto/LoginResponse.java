package com.tejas.notesapi.dto;

public class LoginResponse {
    private int id;
    private String username;

    public LoginResponse(int id, String username)
    {
        this.id = id;
        this.username = username;
    }

    public int getid (){
        return id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setid (int id) {
        this.id = id;
    }

    public void setUsername (String username) {
        this.username = username;
    }
}
