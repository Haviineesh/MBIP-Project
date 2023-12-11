package com.ip.mbip.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class WaterBill extends Bill {
    private double waterRate;

    // Constructors
    public WaterBill(String billID, String type, double usage, int numberOfDays, String date, double waterRate) {
        super(billID, type, usage, numberOfDays, date);
        this.waterRate = waterRate;
    }

    // Getters and setters

    public double getWaterRate() {
        return waterRate;
    }

    public void setWaterRate(double waterRate) {
        this.waterRate = waterRate;
    }

    // Method to calculate total water bill
    public double calculateTotalWaterBill() {
        return getUsage() * waterRate;
    }

    // Override equals and hashCode methods for proper comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
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
