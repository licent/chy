package com.pojo.out;

import java.math.BigDecimal;

public class Withdrawal {
    private Integer id;

    private Integer userId;

    private BigDecimal txMoney;

    private BigDecimal bfMoney;

    private BigDecimal afterMoney;

    private String createTime;

    private Boolean txType;

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

    public BigDecimal getTxMoney() {
        return txMoney;
    }

    public void setTxMoney(BigDecimal txMoney) {
        this.txMoney = txMoney;
    }

    public BigDecimal getBfMoney() {
        return bfMoney;
    }

    public void setBfMoney(BigDecimal bfMoney) {
        this.bfMoney = bfMoney;
    }

    public BigDecimal getAfterMoney() {
        return afterMoney;
    }

    public void setAfterMoney(BigDecimal afterMoney) {
        this.afterMoney = afterMoney;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Boolean getTxType() {
        return txType;
    }

    public void setTxType(Boolean txType) {
        this.txType = txType;
    }
}