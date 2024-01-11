package com.ip.mbip.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ip.mbip.model.ElectricBill
;
public interface ElectricRepo extends CrudRepository<ElectricBill,Long>{
 Optional<ElectricBill> findByBillNumber(int billNumber);
}
