package com.tejas.notesapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejas.notesapi.Repository.UserRepository;
import com.tejas.notesapi.dto.LoginRequest;
import com.tejas.notesapi.dto.LoginResponse;
import com.tejas.notesapi.entity.User;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public LoginResponse register(User newUser) {
        User user = userRepository.findByUsername(newUser.getUsername());
        if(user != null)
        {
            return new LoginResponse(-3, null);
        }

        userRepository.save(newUser);
        return new LoginResponse(
            newUser.getID(), 
            newUser.getUsername()
        );
    }
    
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername());
        if(user == null)
        {
            return new LoginResponse(-2, null);
        }

        if(user.getPassword().equals(request.getPassword()))
            {
                return new LoginResponse(
                    user.getID(), 
                    user.getUsername()
            );
        }
        return new LoginResponse(-1, null);
    }

}