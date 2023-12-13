package com.ip.mbip.model;
public class Recycle {

    private String recycleID;
    private String type;
    private String date;
    private String desc;
    private String contactName;
    private int contactPhone;
    private double weight;

    // Default constructor
    public Recycle() {
    }

    // Parameterized constructor
    public Recycle(String recycleID, String type, String date, String desc, String contactName, int contactPhone, double weight) {
        this.recycleID = recycleID;
        this.type = type;
        this.date = date;
        this.desc = desc;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.weight = weight;
    }

    // Getter and setter methods for each field

    public String getRecycleID() {
        return recycleID;
    }

    public void setRecycleID(String recycleID) {
        this.recycleID = recycleID;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public int getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(int contactPhone) {
        this.contactPhone = contactPhone;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
