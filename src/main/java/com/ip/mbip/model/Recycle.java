package com.ip.mbip.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "recycle")
public class Recycle {

    //generate Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // //define column
    @Column(length =  100, nullable = false)
    private String type;

    @Column(length =  100, nullable = false)
    private String date;

    @Column(length =  100, nullable = false)
    private String description_rec;

    @Column(length =  100, nullable = false)
    private String contact_name;

   
    private int contact_phone;

    
    private double weight;

    // Default constructor
    public Recycle() {
    }

    // Parameterized constructor
    public Recycle(Long id,String type, String date, String description_rec, String contact_name, int contact_phone, double weight) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.description_rec = description_rec;
        this.contact_name = contact_name;
        this.contact_phone = contact_phone;
        this.weight = weight;
    }

    // Getter and setter methods for each field

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

    public String getDescription_rec() {
        return description_rec;
    }

    public void setDescription_rec(String description_rec) {
        this.description_rec = description_rec;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public int getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(int contact_phone) {
        this.contact_phone = contact_phone;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
