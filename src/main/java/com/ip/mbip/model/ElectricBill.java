package com.ip.mbip.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class ElectricBill {
    private String billID;
    private String type;
    private double usage;
    private int numberOfDays;
    private String date;
    private double electricityRate;

    public ElectricBill(String billID, String type, double usage, int numberOfDays, String date, double electricityRate) {
        this.billID = billID;
        this.type = type;
        this.usage = usage;
        this.numberOfDays = numberOfDays;
        this.date = date;
        this.electricityRate = electricityRate;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public double getUsage() {
        return usage;
    }

    public void setUsage(double usage) {
        this.usage = usage;
    }
    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public double getElectricityRate() {
        return electricityRate;
    }

    public void setElectricityRate(double electricityRate) {
        this.electricityRate = electricityRate;
    }

    // Method to calculate carbon footprint for electricity consumption
    // public double calculateCarbonFootprint() {
    //     // Assuming a constant conversion rate of 0.584 kgCO2/kWh
    //     return getUsage() * electricityRate * 0.584;
    // }
}