package com.ip.mbip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// import com.ip.mbip.service.EmailService;
@Controller
public class ForgotPasswordController {

    //  @Autowired
    // private EmailService emailService;
    
    @GetMapping("/forgotpassword")
    public String showForgotPasswordPage() {
        return "ForgotPassword";
    }

    // @PostMapping("/forgotpassword")
    // public String handleForgotPasswordForm(@RequestParam String userEmail, Model model) {
    //     // Find the user by email
    //     // User user = UserService.getUserByEmail(userEmail);

    //     // if (user == null) {
    //     //     // User not found, show error message
    //     //     model.addAttribute("errorMessage", "Invalid email address");
    //     //     return "ForgotPassword";
    //     // }

    //     // // Logic to generate a password reset token and save it in the database
    //     // String resetToken = UserService.generateResetToken(user.getEmail());

    //     // // Set the reset token for the user
    //     // UserService.updateResetToken(user, resetToken);

    //     // Send the password reset email
    //     String subject = "Password Reset";
    //     String body = "Click the following link to reset your password: http://localhost:8090/resetpassword?token="
    //             ;
    //     emailService.sendPasswordResetEmail(userEmail, subject, body);

    //     // For demonstration purposes, let's assume the link is sent successfully
    //     model.addAttribute("successMessage", "Password reset link sent to your email");

    //     return "ForgotPassword";
    // }

    @GetMapping("/resetpassword")
    public String showResetPasswordPage() {
        return "ResetPasswordForm";
    }
}
