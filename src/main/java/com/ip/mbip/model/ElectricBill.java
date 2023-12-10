package com.ip.mbip.model;


import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class ElectricBill extends Bill {
    private double electricityRate;

    // Constructors
    public ElectricBill(String billID, String type, double usage, int numberOfDays, String date, double electricityRate) {
        super(billID, type, usage, numberOfDays, date);
        this.electricityRate = electricityRate;
    }

    // Getters and setters

    public double getElectricityRate() {
        return electricityRate;
    }

    public void setElectricityRate(double electricityRate) {
        this.electricityRate = electricityRate;
    }

    // Method to calculate carbon footprint for electricity consumption
    public double calculateCarbonFootprint() {
        // Assuming a constant conversion rate of 0.584 kgCO2/kWh
        return getUsage() * electricityRate * 0.584;
    }
}