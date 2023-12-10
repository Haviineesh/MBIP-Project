package com.ip.mbip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @RestController
@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/")
    public String test(){
    return "index";
    }

}
