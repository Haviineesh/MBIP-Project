package com.ip.mbip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// @RestController
@Controller
@RequestMapping("/applicationcontroller")
public class ApplicationController {
    
    @GetMapping("/index")
    public String testiing() {
        return "index";
    }
    
}
