package com.tejas.notesapi;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.notesapi.dto.NoteRequest;
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

    /*@PostMapping("/notes")
    public Note createNote(@RequestBody Note note) {
            return noteService.createNote(note);
    }

    @GetMapping("/notes")
    public List<Note> showNote() {
        return noteService.getAllNotes();
    }
    
    @GetMapping("/notes/{id}") 
    public Note getNoteById(@PathVariable int id) {
        return noteService.getNoteById(id);
    }

    

    @PutMapping("/notes/{id}")
    public String updateNoteById(@PathVariable int id, @RequestBody Note note) {
        return noteService.updateNoteById(id, note);
    }

    @DeleteMapping("/notes/{id}")
    public String deleteByID(@PathVariable int id) {
        return noteService.deleteByID(id);
    }*/
}
