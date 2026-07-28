package com.tejas.notesapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.notesapi.dto.NoteDeleteRequest;
import com.tejas.notesapi.dto.NoteRequest;
import com.tejas.notesapi.dto.NoteUpdateRequest;
import com.tejas.notesapi.entity.Note;
import com.tejas.notesapi.service.NoteService;

import java.util.List;

@RestController
public class NotesController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/notes/{username}")
    public List<Note> getUserNotes(@PathVariable String username) {
        return noteService.getNotesByUsername(username);
    }

    @PostMapping("/notes")
    public Note addNote(@RequestBody NoteRequest noteRequest) {
        return noteService.addNote(noteRequest);
    }

    @PutMapping("/notes")
    public Note updateNote(@RequestBody NoteUpdateRequest noteUpdateRequest) {
        return noteService.updateNote(noteUpdateRequest);
    }

    @DeleteMapping("/notes")
    public void deleteNote(@RequestBody NoteDeleteRequest noteDeleteRequest){
        noteService.DeleteNote(noteDeleteRequest);
    }
}
