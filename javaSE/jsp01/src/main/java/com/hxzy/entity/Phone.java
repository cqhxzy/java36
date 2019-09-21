package com.hxzy.entity;

public class Phone {
    private Integer id;
    private String brand;
    private String ser;
    private Double price;

    public Phone() {
    }

    public Phone(Integer id, String brand, String ser, Double price) {
        this.id = id;
        this.brand = brand;
        this.ser = ser;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSer() {
        return ser;
    }

    public void setSer(String ser) {
        this.ser = ser;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
