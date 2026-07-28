package com.tejas.notesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejas.notesapi.Repository.NoteRepository;
import com.tejas.notesapi.Repository.UserRepository;
import com.tejas.notesapi.dto.NoteDeleteRequest;
import com.tejas.notesapi.dto.NoteRequest;
import com.tejas.notesapi.dto.NoteUpdateRequest;
import com.tejas.notesapi.entity.Note;
import com.tejas.notesapi.entity.User;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Note> getNotesByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return noteRepository.findByUserOrderByIdAsc(user);
    }

    public Note addNote(NoteRequest noteRequest) {
        User user = userRepository.findById(noteRequest.getUserId()).get();
        Note note = new Note(noteRequest.getText(), user);
        return noteRepository.save(note);
    }
    
    public Note updateNote(NoteUpdateRequest noteUpdateRequest) {
        Note note = noteRepository.findById(noteUpdateRequest.getNoteId()).get();
        note.setText(noteUpdateRequest.getText());
        return noteRepository.save(note);
    }

    public void DeleteNote(NoteDeleteRequest noteDeleteRequest) {
        Note note = noteRepository.findById(noteDeleteRequest.getNoteId()).get();
        if(note.getUser() == userRepository.findById(noteDeleteRequest.getUserId()).get())
        {
            noteRepository.delete(note);
        }
    }
}
