package com.ip.mbip.model;

public class Recycle {

    private String recycleID;
    private String material;
    private String date;
    private double quantity;
    private double unit;

    //Constructors
    public Recycle(String recycleID, String material, String date,double quantity, double unit){

        this.recycleID = recycleID;
        this.material = material;
        this.date = date;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getRecycleID() {
        return recycleID;
    }

    public void setRecycleID(String recycleID) {
        this.recycleID = recycleID;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnit() {
        return unit;
    }

    public void setUnit(double unit) {
        this.unit = unit;
    }

    

}
