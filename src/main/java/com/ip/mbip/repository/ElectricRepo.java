package com.ip.mbip.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ip.mbip.model.ElectricBill;
import com.ip.mbip.model.Recycle;
import com.ip.mbip.model.User;

public interface ElectricRepo extends CrudRepository<ElectricBill, Long> {
    Optional<ElectricBill> findByBillNumber(int billNumber);

    @Query("SELECT SUM(electricBill.carbonFootprint) FROM ElectricBill electricBill")
    Double calculateTotalCarbonFootprint();

    List<ElectricBill> findByUser(User user);
}
