package com.ip.mbip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ip.mbip.model.WaterBill;
import com.ip.mbip.service.WaterService;

@Controller
public class WaterController {

    @Autowired
    private WaterService waterService;

    @GetMapping("/viewWater")
    public String ShowWaterTable(Model model) {
        // List<TestCase> cases = viewCaseService.findAllList();
        model.addAttribute("water", waterService.findAll());
        return "waterPage";
    }

    @GetMapping("/waterBillForm")
    public String showWaterBillForm(Model model) {
        model.addAttribute("water", new WaterBill());
        return "waterBillForm";
    }

    @PostMapping("/savewater")
    public String addWater(WaterBill waterBill, Model model) {
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
