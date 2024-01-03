package com.ip.mbip.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
    private String date;

    private float waterUsage;
    private int numberOfDays;
    private float waterRate;
    private float carbonFootprint;

    @Lob
    @Column(name = "bill_image")
    private byte[] billImage; 

    // Constructors
    public WaterBill() {

    }

    public WaterBill(Long id, float waterUsage, int numberOfDays, String date, float waterRate) {
        this.id = id;
        this.waterUsage = waterUsage;
        this.numberOfDays = numberOfDays;
        this.date = date;
        this.waterRate = waterRate;
        this.carbonFootprint = calculateCarbonFootprint();

    }

    public WaterBill(Long id, float waterUsage, int numberOfDays, String date, float waterRate, byte[] billImage) {
        this.id = id;
        this.waterUsage = waterUsage;
        this.numberOfDays = numberOfDays;
        this.date = date;
        this.waterRate = waterRate;
        this.billImage = billImage;
        this.carbonFootprint = calculateCarbonFootprint();
    }
    

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getWaterUsage() {
        return waterUsage;
    }

    public void setWaterUsage(float waterUsage) {
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

    public float getCarbonFootprint() {
        return carbonFootprint;
    }

    public void setCarbonFootprint(float carbonFootprint) {
        this.carbonFootprint = carbonFootprint;
    }

    public byte[] getBillImage() {
        return billImage;
    }

    public void setBillImage(byte[] billImage) {
        this.billImage = billImage;
    }

    // Method to calculate total water bill
    public float calculateTotalWaterBill() {
        return waterUsage * waterRate;
    }

    // Method to calculate carbon footprint based on water consumption
    public float calculateCarbonFootprint() {
        // Formula: {Water Consumption} * 0.419 kgCO2/m^3
        return waterUsage * 0.419f;
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
                "id=" + id +
                ", date=" + date +
                ", waterUsage=" + waterUsage +
                ", numberOfDays=" + numberOfDays +
                ", waterRate=" + waterRate +
                ", carbonFootprint=" + carbonFootprint +
                '}';
    }

}
