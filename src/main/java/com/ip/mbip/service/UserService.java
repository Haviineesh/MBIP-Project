package com.ip.mbip.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ip.mbip.model.User;
import com.ip.mbip.repository.UserRepo;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public Iterable<User> findAll() {
        return userRepo.findAll();
    }

    public void addUser(User user) {
        userRepo.save(user);
    }

    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    public void updateUser(User user) {
        userRepo.save(user);
    }

    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }

    // // Additional methods if needed
    // public Optional<User> findByUserId(int userId) {
    //     return userRepo.findByUserID(userId);
    // }

    // public Optional<User> findByEmail(String email) {
    //     return userRepo.findByEmail(email);
    // }
}

