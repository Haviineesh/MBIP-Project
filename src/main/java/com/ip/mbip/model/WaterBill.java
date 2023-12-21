package com.ip.mbip.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "waterBill")
public class WaterBill {

    // generate Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // //define column
    @Column(length = 100, nullable = false)
    private String type;

    @Column(length = 100, nullable = false)
    private String date;

    
    private float waterUsage;
    private int numberOfDays;
    private float waterRate;

    // Constructors
    public WaterBill() {

    }

    public WaterBill(Long id, String type, float waterUsage, int numberOfDays, String date, float waterRate) {
        this.id = id;
        this.type = type;
        this.waterUsage = waterUsage;
        this.numberOfDays = numberOfDays;
        this.date = date;
        this.waterRate = waterRate;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getUsage() {
        return waterUsage;
    }

    public void setUsage(float waterUsage) {
        this.waterUsage = waterUsage;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public float getWaterRate() {
        return waterRate;
    }

    public void setWaterRate(float waterRate) {
        this.waterRate = waterRate;
    }


    // Method to calculate total water bill
    // public float calculateTotalWaterBill() {
    // return getUsage() * waterRate;
    // }

    // Override equals and hashCode methods for proper comparison
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        WaterBill waterBill = (WaterBill) o;
        return Double.compare(waterBill.waterRate, waterRate) == 0;
    }

    
    // Override toString for better representation
    @Override
    public String toString() {
        return "WaterBill{" +
                "waterRate=" + waterRate +
                "} " + super.toString();
    }
}
