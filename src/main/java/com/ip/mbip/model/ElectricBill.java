package com.ip.mbip.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "electric")
public class ElectricBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String date;

    @Column(length = 100, nullable = false)
    private String type;

    private double electricUsage;
    private int billNumber;
    private int numberOfDays;
    private double electricityRate;
    private double carbonFootprint;

    public ElectricBill() {
    }

    public ElectricBill(Long id, int billNumber, String type, double electricUsage, int numberOfDays, String date,
            double electricityRate) {
        this.id = id;
        this.billNumber = billNumber;
        this.type = type;
        this.electricUsage = electricUsage;
        this.numberOfDays = numberOfDays;
        this.date = date;
        this.electricityRate = electricityRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public double getElectricUsage() {
        return electricUsage;
    }

    public void setElectricUsage(double electricUsage) {
        this.electricUsage = electricUsage;
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

    public double calculateTotalElectricBill() {
        return electricUsage * electricityRate;
    }

    // Method to calculate carbon footprint for electricity consumption
    public double calculateCarbonFootprint() {
        // Assuming a constant conversion rate of 0.584 kgCO2/kWh
        return electricUsage * 0.584;
    }

    // Override equals and hashCode methods for proper comparison
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        ElectricBill electricBill = (ElectricBill) o;
        return Double.compare(electricBill.electricityRate, electricityRate) == 0;
    }

    // Override toString for better representation
    @Override
    public String toString() {
        return "ElectricBill{" +
                "id=" + id +
                ", date=" + date +
                ", electricUsage=" + electricUsage +
                ", numberOfDays=" + numberOfDays +
                ", electricityRate=" + electricityRate +
                ", carbonFootprint=" + carbonFootprint +
                '}';
    }
}