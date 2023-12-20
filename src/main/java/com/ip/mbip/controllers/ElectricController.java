package com.ip.mbip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ip.mbip.model.ElectricBill;
import com.ip.mbip.service.BillService;

@Controller
public class ElectricController {

    private final BillService billService;

    public ElectricController (BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/electric")
    public String showElectricBillForm() {
        return "electricBillForm";
    }

    @PostMapping("/electric")
    public String submitElectricBill(@ModelAttribute ElectricBill electricBill) {
        // Call the service to save the electric bill
        billService.saveElectricBill(electricBill);
        // Redirect to a success page or return a response as needed
        return "redirect:/success";
    }
}
