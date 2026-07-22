package com.tejas.notesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejas.notesapi.Repository.NoteRepository;
import com.tejas.notesapi.Repository.UserRepository;
import com.tejas.notesapi.dto.NoteRequest;
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
        return noteRepository.findByUser(user);
    }

    public Note addNote(NoteRequest noteRequest) {
        User user = userRepository.findById(noteRequest.getUserId()).get();
        Note note = new Note(noteRequest.getText(), user);
        return noteRepository.save(note);
    }

    /*public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note createNote(Note note) {
            return noteRepository.save(note);
    }

    public Note getNoteById(int id) {
        if (noteRepository.existsById(id))
            return noteRepository.findById(id).get();
        else
        {
            Note defNote = new Note();
            defNote.setId(id);
            defNote.setText("Does not exist");

            return defNote;
        }
    }

    public String updateNoteById(int id, Note note) {
        if (noteRepository.existsById(id))
        {
            Note currentNote = noteRepository.findById(id).get();
            currentNote.setText(note.getText());
            noteRepository.save(currentNote);
            return "Updated row\nID: " + currentNote.getId() + "\nText: " +currentNote.getText();
        }
        else
            return "ID does not exist";
    }

    public String deleteByID( int id) {
        if (noteRepository.existsById(id))
        {
            Note deletedNote = noteRepository.findById(id).get();
            noteRepository.deleteById(id);
            return deletedNote.getId() + "\nHas been deleted";
        }
        else
        {
            return "Note with ID:" + id + " does not exists";
        }
    }*/
}
