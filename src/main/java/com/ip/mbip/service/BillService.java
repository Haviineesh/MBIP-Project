package com.ip.mbip.service;

import org.springframework.stereotype.Service;

import com.ip.mbip.model.ElectricBill;

@Service
public class BillService {

    public void saveElectricBill(ElectricBill electricBill) {
        // In a real application, you might save the bill to a database or perform other processing
        // For simplicity, let's just print the bill details for now
        System.out.println("Saving Electric Bill: " + electricBill.toString());
    }
}
