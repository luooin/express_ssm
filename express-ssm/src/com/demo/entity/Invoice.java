package com.demo.entity;
import java.util.Date;
public class Invoice {//发票
    //ID
    private Integer id;
    //车源
    private Integer car;
    //司机
    private Integer driver;
    //发货日期
    private Date sendTime;
    //完成日期
    private Date endTime;
    //发货站
    private Integer startSite;
    //目的站
    private Integer endSite;
    //状态
    private Integer state;
    //装载获取
    private String orders;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCar() {
        return car;
    }
    public void setCar(Integer car) {
        this.car = car;
    }

    public Integer getDriver() {
        return driver;
    }
    public void setDriver(Integer driver) {
        this.driver = driver;
    }

    public Date getSendTime() {
        return sendTime;
    }
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStartSite() {
        return startSite;
    }
    public void setStartSite(Integer startSite) {
        this.startSite = startSite;
    }

    public Integer getEndSite() {
        return endSite;
    }
    public void setEndSite(Integer endSite) {
        this.endSite = endSite;
    }

    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }

    public String getOrders() {
        return orders;
    }
    public void setOrders(String orders) {
        this.orders = orders;
    }
}
