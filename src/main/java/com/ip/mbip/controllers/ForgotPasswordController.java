package com.ip.mbip.controllers;

import com.ip.mbip.model.User;
import com.ip.mbip.service.EmailService;
import com.ip.mbip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
public class ForgotPasswordController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/forgotpassword")
    public String showForgotPasswordPage(Model model) {
        model.addAttribute("user", new User());
        return "ForgotPassword";
    }

    @PostMapping("/forgotpassword")
    public String handleForgotPasswordForm(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "ForgotPassword";
        }

        // Find the user by email
        User existingUser = userService.getUserByEmail(user.getEmail());

        if (existingUser == null) {
            // User not found, show error message
            model.addAttribute("errorMessage", "Invalid email address");
            return "ForgotPassword";
        }

        // Logic to generate a password reset token and save it in the database
        String resetToken = userService.generateResetToken(existingUser.getEmail());

        // Set the reset token for the user
        userService.updateResetToken(existingUser, resetToken);

        // Send the password reset email
        String subject = "Password Reset";
        String body = "Click the following link to reset your password: http://localhost:8090/resetpassword?token="
                + resetToken;
        emailService.sendPasswordResetEmail(existingUser.getEmail(), subject, body);

        // For demonstration purposes, let's assume the link is sent successfully
        model.addAttribute("successMessage", "Password reset link sent to your email");

        return "ForgotPassword";
    }

    @GetMapping("/resetpassword")
    public String showResetPasswordPage() {
        return "ResetPasswordForm";
    }
}
