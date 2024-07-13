package com.demo.utils;
import java.io.Serializable;
public class Statistics implements Serializable {
    private String[] xx;
    private String[] yy;
    private String total;
    public String[] getXx() {
        return xx;
    }
    public void setXx(String[] xx) {
        this.xx = xx;
    }
    public String[] getYy() {
        return yy;
    }
    public void setYy(String[] yy) {
        this.yy = yy;
    }
    public String getTotal() {
        return total;
    }
    public void setTotal(String total) {
        this.total = total;
    }
}
