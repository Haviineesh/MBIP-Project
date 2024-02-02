package com.ip.mbip.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ip.mbip.model.ElectricBill;
import com.ip.mbip.model.Recycle;
import com.ip.mbip.model.User;
import com.ip.mbip.model.WaterBill;
import com.ip.mbip.service.ElectricService;
import com.ip.mbip.service.RecycleService;
import com.ip.mbip.service.UserService;
import com.ip.mbip.service.WaterService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DashboardController {

    @Autowired
    private UserService userService;

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
    public String showDashboard(HttpServletRequest request, Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if the authentication object is not null and the user is authenticated
        if (authentication != null && authentication.isAuthenticated()) {
            // Retrieve the principal from the authentication object
            Object principal = authentication.getPrincipal();

            // Check if the principal is an instance of UserDetails
            if (principal instanceof UserDetails) {
                // Cast the principal to UserDetails to access user details
                UserDetails userDetails = (UserDetails) principal;

                User user = (User) userService.findByUsername(userDetails.getUsername());
                // You can use the user ID as needed
                model.addAttribute("userId", user.getID());

                // potential fix start
                // Retrieve water bills by user ID
                List<WaterBill> waterBills = waterService.findAllByUserId(user.getID());
                model.addAttribute("waterBills", waterBills);

                Double totalWaterCarbon = waterService.calculateWaterTotalCarbonFootprint(waterBills);
                model.addAttribute("totalWaterCarbon", totalWaterCarbon);
                // Retrieve electric bills by user ID
                Iterable<ElectricBill> electricBills = electricService.findAllByUserId(user.getID());
                model.addAttribute("electricBills", electricBills);

                Double totalElectricCarbon = electricService.calculateElectricTotalCarbonFootprint(electricBills);
                model.addAttribute("totalElectricCarbon", totalElectricCarbon);

                Iterable<Recycle> recycleList = recycleService.findAllByUserId(user.getID());
                model.addAttribute("recycleList", recycleList);

                Double totalRecycleCarbon = recycleService.calculateTotalCarbonFootprint();
                model.addAttribute("totalRecycleCarbon", totalRecycleCarbon);

                // potential fix end
            }
        }

        // Iterable<ElectricBill> electricBills = electricService.findAll();
        // model.addAttribute("electricBills", electricBills);

        // Iterable<Recycle> recycleList = recycleService.findAll();
        // model.addAttribute("recycleList", recycleList);

        // Iterable<WaterBill> waterBills = waterService.findAll();
        // model.addAttribute("waterBills", waterBills);

        // Double totalRecycleCarbon = recycleService.calculateTotalCarbonFootprint();
        // model.addAttribute("totalRecycleCarbon", totalRecycleCarbon);

        // Double totalElectricCarbon = electricService.calculateTotalCarbonFootprint();
        // model.addAttribute("totalElectricCarbon", totalElectricCarbon);

        // // Fetch and calculate total water carbon
        // Double totalWaterCarbon = waterService.calculateTotalCarbonFootprint();
        // model.addAttribute("totalWaterCarbon", totalWaterCarbon);

        return "dashboard";
    }

    @GetMapping("/api/carbon-data")
    @ResponseBody
    public CarbonData getCarbonData() {
        Double totalElectricCarbon = electricService.calculateTotalCarbonFootprint();
        Double totalRecycleCarbon = recycleService.calculateTotalCarbonFootprint();
        Double totalWaterCarbon = waterService.calculateTotalCarbonFootprint();

        return new CarbonData(totalElectricCarbon, totalRecycleCarbon, totalWaterCarbon);
    }

    static class CarbonData {
        private Double electric;
        private Double recycle;
        private Double water;

        public CarbonData(Double electric, Double recycle, Double water) {
            this.electric = electric;
            this.recycle = recycle;
            this.water = water;
        }

        public Double getElectric() {
            return electric;
        }

        public Double getRecycle() {
            return recycle;
        }

        public Double getWater() {
            return water;
        }
    }

    @GetMapping("/blankfile")
    public String showBlank() {
        // Iterable<Recycle> recycleList = recycleService.findAll(); // Assuming you
        // have a service for retrieving data
        return "blankfile";
    }

}
