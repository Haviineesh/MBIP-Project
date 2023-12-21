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

    public Iterable<WaterBill> findAll(){
        return waterRepo.findAll();
    }

    public void addWater(WaterBill water){
        waterRepo.save(water);
    }

    public void deleteById(long id){
        waterRepo.deleteById(id);
    }

    public void updateWater(WaterBill water){
        waterRepo.save(water);
    }

    public Optional <WaterBill> findById(long id){
        return waterRepo.findById(id);
    }

    
}
