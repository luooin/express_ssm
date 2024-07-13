package com.demo.entity;
import com.lifedian.common.vo.PageInfo;
import java.util.Date;
public class Orders extends PageInfo{
    //ID
    private Integer id;
    //用户ID
    private Integer userId;
    //寄件人
    private String userName;
    //寄件人电话
    private String userPhone;
    //寄件人地址
    private String userAddress;
    //运费
    private Double freight;
    //体积
    private Double volume;
    //重量
    private Double weight;
    //订单号
    private String orderNum;
    //下单时间
    private Date orderTime;
    //收件人
    private String receiver;
    //收件人电话
    private String receiverPhone;
    //收件人地址
    private String receiverAddress;
    //商品名
    private String goodsName;
    //状态
    private Integer state;
    //发货站
    private Integer startSite;
    //目的站
    private Integer endSite;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Double getFreight() {
        return freight;
    }
    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public Double getVolume() {
        return volume;
    }
    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getOrderNum() {
        return orderNum;
    }
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getGoodsName() {
        return goodsName;
    }
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
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
}
