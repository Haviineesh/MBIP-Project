package com.ip.mbip.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ip.mbip.model.User;
import com.ip.mbip.model.WaterBill;

public interface WaterRepo extends CrudRepository<WaterBill, Long> {
    Optional<WaterBill> findByBillNumber(int billNumber);

    @Query("SELECT SUM(waterBill.carbonFootprint) FROM WaterBill waterBill")
    Double calculateTotalCarbonFootprint();

    @Query("SELECT SUM(waterBill.carbonFootprint) FROM WaterBill waterBill WHERE waterBill.user.id = :userId")
    Double calculateTotalCarbonFootprintByUserId(@Param("userId") Long userId);

    List<WaterBill> findByUser(User user);

    List<WaterBill> findByUserId(Long userId);
}
