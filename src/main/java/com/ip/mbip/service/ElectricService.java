package com.ip.mbip.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ip.mbip.model.ElectricBill;
import com.ip.mbip.model.User;
import com.ip.mbip.repository.ElectricRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ElectricService {

    @Autowired
    private ElectricRepo electricRepo;

    public List<ElectricBill> findAllByUserId(Long userId) {
        return electricRepo.findByUserId(userId);
    }

    public Iterable<ElectricBill> findAll() {
        return electricRepo.findAll();
    }

    public void addElectric(ElectricBill electricBill) {
        Optional<ElectricBill> existingElectric = electricRepo.findByBillNumber(electricBill.getBillNumber());
        electricBill.setCarbonFootprint(electricBill.calculateCarbonFootprint());

        if (existingElectric.isPresent()) {

        } else {

            electricRepo.save(electricBill);
        }

    }

    public void deleteById(long id) {
        electricRepo.deleteById(id);
    }

    public void updateElectric(ElectricBill electricBill) {

        Optional<ElectricBill> existingElectricOptional = electricRepo.findById(electricBill.getId());
        electricBill.setCarbonFootprint(electricBill.calculateCarbonFootprint());

        if (existingElectricOptional.isPresent()) {
            ElectricBill existingElectricBill = existingElectricOptional.get();

            // Update the fields of the existingWater with the values from updatedWater
            existingElectricBill.setDate(electricBill.getDate());
            existingElectricBill.setElectricUsage(electricBill.getElectricUsage());
            existingElectricBill.setNumberOfDays(electricBill.getNumberOfDays());
            existingElectricBill.setElectricityRate(electricBill.getElectricityRate());

            // Recalculate carbon footprint if needed
            existingElectricBill.setCarbonFootprint(existingElectricBill.calculateCarbonFootprint());

            electricRepo.save(existingElectricBill);
        }

    }

    public Optional<ElectricBill> findById(long id) {
        return electricRepo.findById(id);
    }

    public Double calculateTotalCarbonFootprint() {
        return electricRepo.calculateTotalCarbonFootprint();
    }

    public List<ElectricBill> findByUser(User user) {
        return electricRepo.findByUser(user);
    }
}