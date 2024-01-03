package com.ip.mbip.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ip.mbip.model.Recycle;
import com.ip.mbip.repository.RecycleRepo;
import com.ip.mbip.service.RecycleService;

@Controller
public class DashboardController {

    @Autowired
    private  RecycleService recycleService;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // Iterable<Recycle> recycleList = recycleService.findAll(); // Assuming you have a service for retrieving data
        model.addAttribute("recycleList", recycleService.findAll());
        return "dashboard";
    }

}
