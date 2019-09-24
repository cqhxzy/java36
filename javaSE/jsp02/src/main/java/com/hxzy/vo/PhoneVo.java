package com.hxzy.vo;

public class PhoneVo {
    private Integer id;
    private String brand;
    private String series;
    private String os;
    private String networkModel;
    private Double price;

    public PhoneVo() {
    }

    public PhoneVo(Integer id, String brand, String series, String os, String networkModel, Double price) {
        this.id = id;
        this.brand = brand;
        this.series = series;
        this.os = os;
        this.networkModel = networkModel;
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

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getNetworkModel() {
        return networkModel;
    }

    public void setNetworkModel(String networkModel) {
        this.networkModel = networkModel;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
