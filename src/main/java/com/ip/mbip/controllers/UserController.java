package com.ip.mbip.controllers;

import com.ip.mbip.model.User;
import com.ip.mbip.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "loginPage";
    }

    @GetMapping("/createaccount")
    public String showCreateAccountPage(Model model) {
        model.addAttribute("user", new User());
        return "createaccount";
    }

    @PostMapping("/createaccount")
    public String createAccount(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "createaccount";
        }

        userService.addUser(user);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String loginProcess(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model) {
        // Validate login credentials, you can use userService methods for authentication.
        // For example:
        if (userService.authenticateUser(username, password)) {
            // Successful login, redirect to the dashboard or home page
            return "redirect:/homepage";
        } else {
            // Failed login, add error message to the model and return to the login page
            model.addAttribute("error", "Invalid username or password");
            return "loginPage";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login"; // Redirect to the login page after logout
    }
}
