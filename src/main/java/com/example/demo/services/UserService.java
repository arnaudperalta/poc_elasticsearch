package com.example.demo.services;

import com.example.demo.entities.FilterEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void setupUsers() {
        // Users
        UserEntity user1 = new UserEntity();
        UserEntity user2 = new UserEntity();
        user1.setFirstname("Charlie");
        user1.setLastname("Chaplin");
        user2.setFirstname("Jules");
        user2.setLastname("Verne");

        userRepo.save(user1);
        userRepo.save(user2);
    }

    public Iterable<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }
}
