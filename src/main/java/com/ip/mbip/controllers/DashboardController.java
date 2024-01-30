package com.ip.mbip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ip.mbip.model.ElectricBill;
import com.ip.mbip.model.Recycle;
import com.ip.mbip.model.WaterBill;
import com.ip.mbip.service.ElectricService;
import com.ip.mbip.service.RecycleService;
import com.ip.mbip.service.WaterService;

@Controller
public class DashboardController {

    private final ElectricService electricService;
    private final RecycleService recycleService;
    private final WaterService waterService;

    public DashboardController(ElectricService electricService, RecycleService recycleService,
            WaterService waterService) {
        this.electricService = electricService;
        this.recycleService = recycleService;
        this.waterService = waterService;
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        Iterable<ElectricBill> electricBills = electricService.findAll();
        model.addAttribute("electricBills", electricBills);

        Iterable<Recycle> recycleList = recycleService.findAll();
        model.addAttribute("recycleList", recycleList);

        Iterable<WaterBill> waterBills = waterService.findAll();
        model.addAttribute("waterBills", waterBills);

        Double totalRecycleCarbon = recycleService.calculateTotalCarbonFootprint();
        model.addAttribute("totalRecycleCarbon", totalRecycleCarbon);

        Double totalElectricCarbon = electricService.calculateTotalCarbonFootprint();
        model.addAttribute("totalElectricCarbon", totalElectricCarbon);

        // Fetch and calculate total water carbon
        Double totalWaterCarbon = waterService.calculateTotalCarbonFootprint();
        model.addAttribute("totalWaterCarbon", totalWaterCarbon);

        return "dashboard";
    }

    @GetMapping("/blankfile")
    public String showBlank() {
        // Iterable<Recycle> recycleList = recycleService.findAll(); // Assuming you
        // have a service for retrieving data
        return "blankfile";
    }

}
