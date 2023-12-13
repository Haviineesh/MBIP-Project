package com.ip.mbip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecycleController {

    @GetMapping("/recyclePage")
    public String showRecyclePage() {
    return "recyclePage";
    }

    @GetMapping("/recycleBillForm")
    public String showRecycleBillForm() {
    return "recycleBillForm";
    }
}
