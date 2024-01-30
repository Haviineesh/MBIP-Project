package com.ip.mbip.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ip.mbip.model.Recycle;
import com.ip.mbip.repository.RecycleRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RecycleService {

    @Autowired
    private RecycleRepo recycleRepo;

    public Iterable<Recycle> findAll() {
        return recycleRepo.findAll();
    }

    public void addRecycle(Recycle recycle) {
        // Calculate and save carbon footprint before saving to the database
        recycle.setCarbonFootprint(recycle.calculateCarbonFootprint());
        recycleRepo.save(recycle);
    }

    public void deleteById(long id) {
        recycleRepo.deleteById(id);
    }

    public void updateRecycle(Recycle recycle) {
        // Calculate and save carbon footprint before saving to the database
        recycle.setCarbonFootprint(recycle.calculateCarbonFootprint());
        recycleRepo.save(recycle);
    }

    public Optional<Recycle> findById(long id) {
        return recycleRepo.findById(id);
    }

    public Double calculateTotalCarbonFootprint() {
        Double totalCarbonFootprint = recycleRepo.calculateTotalCarbonFootprint();
        if (totalCarbonFootprint != null) {
            // Format the total carbon footprint to two decimal places
            totalCarbonFootprint = Math.round(totalCarbonFootprint * 100.0) / 100.0;
        }
        return totalCarbonFootprint;
    }
}
