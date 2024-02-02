package com.ip.mbip.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ip.mbip.model.Recycle;
import com.ip.mbip.model.User;
import com.ip.mbip.model.WaterBill;
import com.ip.mbip.service.UserService;
import com.ip.mbip.service.WaterService;

@Controller
public class WaterController {

    @Autowired
    private WaterService waterService;

    @Autowired
    private UserService userService; // Create UserService

    @GetMapping("/viewWater")
    public String ShowWaterTable(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        model.addAttribute("water", waterService.findByUser(user));
        return "waterPage";
    }

    @GetMapping("/waterBillForm")
    public String showWaterBillForm(Model model) {
        model.addAttribute("water", new WaterBill());
        return "waterBillForm";
    }

    @PostMapping("/savewater")
    public String addWater(WaterBill waterBill, Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        waterBill.setUser(user);
        waterService.addWater(waterBill);// save product into database, using DbService
        return "redirect:/viewWater";
    }

    @GetMapping("/deleteWater/{id}")
    public String deleteRec(@PathVariable("id") Long id) {

        waterService.deleteById(id);
        return "redirect:/viewWater";
    }

    @GetMapping("/editWaterBill/{id}")
    public String editCase(@PathVariable("id") Long id, Model model) {

        model.addAttribute("water", waterService.findById(id));
        return "editWaterForm";
    }

    @PostMapping("/updateWater")
    public String editTestCaseForm(WaterBill water, Model model) {
        waterService.updateWater(water);
        return "redirect:/viewWater";
    }
}
