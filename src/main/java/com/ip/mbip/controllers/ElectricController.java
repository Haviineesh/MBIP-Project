package com.ip.mbip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ip.mbip.model.ElectricBill;
import com.ip.mbip.service.ElectricService;

@Controller
public class ElectricController {

    @Autowired
    private ElectricService electricService;

    @GetMapping("/electricBillForm")
    public String showElectricBillForm(Model model) {
        model.addAttribute("electric", new ElectricBill());
        return "electricBillForm";
    }

    @GetMapping("/viewElectric")
    public String showElectricTable(Model model) {
        model.addAttribute("electric", electricService.findAll());
        return "electricPage";
    }

    @PostMapping("/saveElectric")
    public String addElectric(ElectricBill electricBill, Model model) {
        electricService.addElectric(electricBill);// save product into database, using DbService
        return "redirect:/viewElectric";
    }

    @GetMapping("/deleteElectric/{id}")
    public String deleteElectric(@PathVariable("id") Long id) {
        electricService.deleteById(id);
        return "redirect:/viewElectric";
    }

    @GetMapping("/editElectric/{id}")
    public String editElectric(@PathVariable("id") Long id, Model model) {
        model.addAttribute("electric", electricService.findById(id));
        return "editElectricForm";
    }

    @PostMapping("/updateElectric")
    public String editElectricForm(@ModelAttribute ElectricBill electricBill, Model model) {
        electricService.updateElectric(electricBill);
        return "redirect:/viewElectric";
    }
}
