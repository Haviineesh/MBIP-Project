package com.ip.mbip.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
@Table(name = "electricBill")
public class ElectricBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String date;

    @Column(length = 100, nullable = false)
    private String type;

    private int billNumber;
    private double EletricUsage;
    private int numberOfDays;
    private double electricityRate;
    private double carbonFootprint;

    public ElectricBill() {
    }

    public ElectricBill(Long id, int billNumber, String type, double EletricUsage, int numberOfDays, String date,
            double electricityRate,double carbonFootprint) {
        this.id = id;
        this.billNumber = billNumber;
        this.type = type;
        this.EletricUsage = EletricUsage;
        this.numberOfDays = numberOfDays;
        this.date = date;
        this.electricityRate = electricityRate;
        this.carbonFootprint = carbonFootprint;
    }

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getEletricUsage() {
        return EletricUsage;
    }

    public void setEletricUsage(double EletricUsage) {
        this.EletricUsage = EletricUsage;
        this.carbonFootprint = calculateCarbonFootprint();
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

    public double getCarbonFootprint() {
        return carbonFootprint;
    }

    public void setCarbonFootprint(double carbonFootprint) {
        this.carbonFootprint = carbonFootprint;
    }

    // Method to calculate carbon footprint for electricity consumption
    public double calculateCarbonFootprint() {
        // Assuming a constant conversion rate of 0.584 kgCO2/kWh
        return getEletricUsage() * electricityRate * 0.584;
    }
}