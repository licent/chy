package com.pojo.out;

import java.math.BigDecimal;

public class BounsLogs {
    private Integer id;

    private BigDecimal money;

    private String createTime;

    private Boolean type;

    private Integer buyOrderId;

    private Integer buyUserId;

    private Integer recUserId;

    private String content;

    private Boolean isT;

    private BigDecimal orderMoney;

    private Float bounsRate;

    private Float maoli;

    private Integer num;

    private Integer itemId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Integer getBuyOrderId() {
        return buyOrderId;
    }

    public void setBuyOrderId(Integer buyOrderId) {
        this.buyOrderId = buyOrderId;
    }

    public Integer getBuyUserId() {
        return buyUserId;
    }

    public void setBuyUserId(Integer buyUserId) {
        this.buyUserId = buyUserId;
    }

    public Integer getRecUserId() {
        return recUserId;
    }

    public void setRecUserId(Integer recUserId) {
        this.recUserId = recUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Boolean getIsT() {
        return isT;
    }

    public void setIsT(Boolean isT) {
        this.isT = isT;
    }

    public BigDecimal getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(BigDecimal orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Float getBounsRate() {
        return bounsRate;
    }

    public void setBounsRate(Float bounsRate) {
        this.bounsRate = bounsRate;
    }

    public Float getMaoli() {
        return maoli;
    }

    public void setMaoli(Float maoli) {
        this.maoli = maoli;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
}