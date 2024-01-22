package com.ip.mbip.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ip.mbip.model.ElectricBill;
import com.ip.mbip.model.Recycle;
import com.ip.mbip.repository.RecycleRepo;
import com.ip.mbip.service.ElectricService;
import com.ip.mbip.service.RecycleService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DashboardController {

    @Autowired
    private RecycleService recycleService;

    @Autowired
    private ElectricService electricService;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // Iterable<Recycle> recycleList = recycleService.findAll(); // Assuming you
        // have a service for retrieving data
        model.addAttribute("recycleList", recycleService.findAll());
        Iterable<ElectricBill> electricBills = electricService.findAll();
        model.addAttribute("electricBills", electricBills);
        return "dashboard";
    }

    @GetMapping("/blankfile")
    public String showBlank() {
        // Iterable<Recycle> recycleList = recycleService.findAll(); // Assuming you
        // have a service for retrieving data
        return "blankfile";
    }

}
