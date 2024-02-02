package com.ip.mbip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ip.mbip.model.Recycle;
import com.ip.mbip.model.User;

public interface RecycleRepo extends CrudRepository<Recycle, Long> {

    // Custom query to calculate the sum of carbon footprints
    @Query("SELECT SUM(recycle.carbonFootprint) FROM Recycle recycle")
    Double calculateTotalCarbonFootprint();

    List<Recycle> findByUser(User user);

    List<Recycle> findByUserId(Long userId);

}
