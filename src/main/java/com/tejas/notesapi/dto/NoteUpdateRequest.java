package com.tejas.notesapi.dto;

public class NoteUpdateRequest {
    private String text;
    private int userId;
    private int noteId;

    public NoteUpdateRequest(String text, int userId, int noteId){
        this.text = text;
        this.userId = userId;
        this.noteId = noteId;
    }

    public String getText(){
        return text;
    }

    public int getUserId(){
        return userId;
    }

    public int getNoteId(){
        return noteId;
    }

    public void setText(String text){
        this.text = text;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public void setNoteId(int noteId){
        this.noteId = noteId;
    }
}
