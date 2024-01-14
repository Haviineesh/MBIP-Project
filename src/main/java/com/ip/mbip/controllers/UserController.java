package com.ip.mbip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ip.mbip.model.User;
import com.ip.mbip.service.UserService;

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
    public String createAccount(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/login";
    }

    // @PostMapping("/login")
    // public String loginProcess(@RequestParam("username") String username,
    // @RequestParam("password") String password) {

    // // UserService userService = userService.findByUsername(username);

    // return null;
    // }

}
