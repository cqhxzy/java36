package com.hxzy.entity;

public class Series {
    private Integer id;
    private Brand brand;
    private String name;

    public Series(Integer id) {
        this.id = id;
    }

    public Series() {
    }

    public Series(Integer id, Brand brand, String name) {
        this.id = id;
        this.brand = brand;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Series{" +
                "id=" + id +
                ", brand=" + brand +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
