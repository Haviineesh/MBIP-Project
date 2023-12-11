package com.ip.mbip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ip.mbip.model.ElectricBill;
import com.ip.mbip.service.BillService;

@Controller
@RequestMapping("/bill")
public class BillController {

      private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping("/electric")
    public String submitElectricBill(@ModelAttribute ElectricBill electricBill) {
        // Call the service to save the electric bill
        billService.saveElectricBill(electricBill);
        // Redirect to a success page or return a response as needed
        return "redirect:/success";
    }
    
    @GetMapping("/electric")
    public String showElectricBillForm() {
        return "electricBillForm";
    }
    
     @GetMapping("/water")
    public String showWaterBillForm() {
        return "waterBillForm";
    }
}
