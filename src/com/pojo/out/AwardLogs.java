package com.pojo.out;

import java.math.BigDecimal;

public class AwardLogs {
    private Integer id;

    private Integer uid;

    private BigDecimal money;

    private Boolean moneyType;

    private Integer addTime;

    private BigDecimal before;

    private BigDecimal after;

    private Boolean type;

    private Integer produceId;

    private Integer orderId;

    private String content;

    private String addTimeStr;

    private Boolean isT;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Boolean getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(Boolean moneyType) {
        this.moneyType = moneyType;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public BigDecimal getBefore() {
        return before;
    }

    public void setBefore(BigDecimal before) {
        this.before = before;
    }

    public BigDecimal getAfter() {
        return after;
    }

    public void setAfter(BigDecimal after) {
        this.after = after;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Integer getProduceId() {
        return produceId;
    }

    public void setProduceId(Integer produceId) {
        this.produceId = produceId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getAddTimeStr() {
        return addTimeStr;
    }

    public void setAddTimeStr(String addTimeStr) {
        this.addTimeStr = addTimeStr == null ? null : addTimeStr.trim();
    }

    public Boolean getIsT() {
        return isT;
    }

    public void setIsT(Boolean isT) {
        this.isT = isT;
    }
}