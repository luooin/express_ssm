package com.demo.entity;
public class Cars {
    //ID
    private Integer id;
    //车牌号
    private String carNumber;
    //司机
    private Integer drivers;
    //状态
    private Integer state;
    //车载重量
    private Double loadCap;
    //车载体积
    private Double loadVolume;
    //颜色
    private String colour;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Integer getDrivers() {
        return drivers;
    }
    public void setDrivers(Integer drivers) {
        this.drivers = drivers;
    }

    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }

    public Double getLoadCap() {
        return loadCap;
    }
    public void setLoadCap(Double loadCap) {
        this.loadCap = loadCap;
    }

    public Double getLoadVolume() {
        return loadVolume;
    }
    public void setLoadVolume(Double loadVolume) {
        this.loadVolume = loadVolume;
    }

    public String getColour() {
        return colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
}
