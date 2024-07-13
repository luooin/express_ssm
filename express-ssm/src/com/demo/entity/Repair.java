package com.demo.entity;
public class Repair {
    //ID
    private Integer id;
    //车辆ID
    private Integer carId;
    //车牌号
    private String carNumber;
    //状态
    private Integer state;
    //维修原因
    private String reason;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarId() {
        return carId;
    }
    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarNumber() {
        return carNumber;
    }
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }

    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
}
