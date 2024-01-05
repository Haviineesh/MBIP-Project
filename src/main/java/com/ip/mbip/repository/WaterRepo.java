package com.ip.mbip.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ip.mbip.model.WaterBill;

public interface WaterRepo extends CrudRepository<WaterBill, Long>{
    Optional<WaterBill> findByBillNumber(int billNumber);
}
