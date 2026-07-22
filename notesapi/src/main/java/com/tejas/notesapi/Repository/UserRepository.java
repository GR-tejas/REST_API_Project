package com.tejas.notesapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tejas.notesapi.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}