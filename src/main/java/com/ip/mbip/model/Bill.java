package com.ip.mbip.model;

public class Bill {
    private String billID;
    private String type;
    private double usage;
    private int numberOfDays;
    private String date;

    // Constructors
    public Bill(String billID, String type, double usage, int numberOfDays, String date) {
        this.billID = billID;
        this.type = type;
        this.usage = usage;
        this.numberOfDays = numberOfDays;
        this.date = date;
    }

    // Getters and setters

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
}
