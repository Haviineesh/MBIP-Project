package com.ip.mbip.service;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ip.mbip.model.User;
import com.ip.mbip.repository.UserRepo;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(Collections.singletonList(new SimpleGrantedAuthority("USER")))
                .build();
    }

    public void addUser(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(user);
            System.out.println("User added: " + user.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error adding user: " + e.getMessage());
        }
    }

    public boolean authenticateUser(String username, String password) {
        User user = userRepo.findByUsername(username);

        // Assuming user is not null, add null check as needed
        return passwordEncoder.matches(password, user.getPassword());
    }

    public Iterable<User> findAll() {
        return userRepo.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }

    public String generateResetToken(String email) {
        User user = userRepo.findByEmail(email);

        if (user != null) {
            String resetToken = UUID.randomUUID().toString();
            user.setResetToken(resetToken);
            userRepo.save(user);
            return resetToken;
        }
        return null;
    }

    public boolean isValidToken(String token) {
        User user = userRepo.findByResetToken(token);
        return user != null;
    }

    public User findUserByResetToken(String token) {
        return userRepo.findByResetToken(token);
    }

    public void updateResetToken(User user, String token) {
        user.setResetToken(token);
        userRepo.save(user);
    }

    public void updateUserPassword(User user, String newPassword) {
        user.setPassword(passwordEncoder.encode(newPassword));
        user.setResetToken(null);
        userRepo.save(user);
    }

    public boolean isPasswordValid(String password) {
        // Add your password validation logic here
        return password.length() >= 6;
    }
}
