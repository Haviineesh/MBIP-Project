package com.ip.mbip.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ip.mbip.model.WaterBill;
import com.ip.mbip.repository.WaterRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class WaterService {

    @Autowired
    private WaterRepo waterRepo;

    public Iterable<WaterBill> findAll() {
        return waterRepo.findAll();
    }

    public void addWater(WaterBill water) {
        Optional<WaterBill> existingWater = waterRepo.findByBillNumber(water.getBillNumber());
        water.setCarbonFootprint(water.calculateCarbonFootprint());

        if (existingWater.isPresent()) {
            // add exception
        } else {
            // Save the new WaterBill since there is no duplicate billNumber
            waterRepo.save(water);
        }
    }

    public void deleteById(long id) {
        waterRepo.deleteById(id);
    }

    public void updateWater(WaterBill updatedWater) {
        Optional<WaterBill> existingWaterOptional = waterRepo.findById(updatedWater.getId());
        updatedWater.setCarbonFootprint(updatedWater.calculateCarbonFootprint());

        if (existingWaterOptional.isPresent()) {
            WaterBill existingWater = existingWaterOptional.get();

            // Update the fields of the existingWater with the values from updatedWater
            existingWater.setDate(updatedWater.getDate());
            existingWater.setWaterUsage(updatedWater.getWaterUsage());
            existingWater.setNumberOfDays(updatedWater.getNumberOfDays());
            existingWater.setWaterRate(updatedWater.getWaterRate());
            existingWater.setBillImage(updatedWater.getBillImage());

            // Recalculate carbon footprint if needed
            existingWater.setCarbonFootprint(existingWater.calculateCarbonFootprint());

            // Save the updated water bill
            waterRepo.save(existingWater);
        }
    }

    public Optional<WaterBill> findById(long id) {
        return waterRepo.findById(id);
    }

    public Double calculateTotalCarbonFootprint() {
        Double totalCarbonFootprint = waterRepo.calculateTotalCarbonFootprint();
        if (totalCarbonFootprint != null) {
            // Format the total carbon footprint to two decimal places
            totalCarbonFootprint = Math.round(totalCarbonFootprint * 100.0) / 100.0;
        }
        return totalCarbonFootprint;
    }
}
