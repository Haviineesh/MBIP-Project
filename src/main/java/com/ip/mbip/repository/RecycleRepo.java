package com.ip.mbip.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ip.mbip.model.Recycle;

public interface RecycleRepo extends CrudRepository<Recycle, Long> {

    // Custom query to calculate the sum of carbon footprints
    @Query("SELECT SUM(recycle.carbonFootprint) FROM Recycle recycle")
    Double calculateTotalCarbonFootprint();

}
