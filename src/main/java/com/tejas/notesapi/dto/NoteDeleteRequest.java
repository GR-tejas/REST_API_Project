package com.tejas.notesapi.dto;

public class NoteDeleteRequest {
    private int userId;
    private int noteId;

    public NoteDeleteRequest(int userId, int noteId){
        this.userId = userId;
        this.noteId = noteId;
    }

    public int getUserId(){
        return userId;
    }

    public int getNoteId(){
        return noteId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public void setNoteId(int noteId){
        this.noteId = noteId;
    }
}
