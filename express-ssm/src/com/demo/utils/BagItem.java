package com.demo.utils;
/**
 * Created by
 */
public class BagItem {
    public String orderId; // 订单号
    public Double cap = 0.0;// 物品重量
    public BagItem(String orderId, Double volume, Double cap) {
        this.orderId = orderId;
        this.cap = cap;
    }
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public Double getCap() {
        return cap;
    }
    public void setCap(Double cap) {
        this.cap = cap;
    }
    public String toString() {
        return this.orderId;
    }
}
