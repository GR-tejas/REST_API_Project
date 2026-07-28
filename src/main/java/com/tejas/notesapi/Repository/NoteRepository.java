package com.tejas.notesapi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tejas.notesapi.entity.Note;
import com.tejas.notesapi.entity.User;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    List<Note> findByUser(User user);
    List<Note> findByUserOrderByIdAsc(User user);
}