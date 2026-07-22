package com.tejas.notesapi.dto;

public class NoteRequest {
    private String text;
    private int userId;

    public NoteRequest(String text, int userId){
        this.text = text;
        this.userId = userId;
    }

    public String getText(){
        return text;
    }

    public int getUserId(){
        return userId;
    }

    public void setText(String text){
        this.text = text;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }
}
