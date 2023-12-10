package com.ip.mbip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bill")
public class BillController {
    
    @GetMapping("/electric")
    public String showElectricBillForm() {
        return "electricBillForm";
    }
    
}
