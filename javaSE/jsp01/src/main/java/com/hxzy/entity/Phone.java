package com.hxzy.entity;

public class Phone {
    private Integer id;
    private Series series;
    private Integer os;
    private Integer networkModel;
    private Double price;

    public Phone() {
    }

    public Phone(Integer id, Series series, Integer os, Integer networkModel, Double price) {
        this.id = id;
        this.series = series;
        this.os = os;
        this.networkModel = networkModel;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", series=" + series +
                ", os=" + os +
                ", networkModel=" + networkModel +
                ", price=" + price +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public Integer getOs() {
        return os;
    }

    public void setOs(Integer os) {
        this.os = os;
    }

    public Integer getNetworkModel() {
        return networkModel;
    }

    public void setNetworkModel(Integer networkModel) {
        this.networkModel = networkModel;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
