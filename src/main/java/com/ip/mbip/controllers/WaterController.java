package com.ip.mbip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WaterController {
    
     @GetMapping("/water")
    public String showWaterBillForm() {
        return "waterBillForm";
    }
}
