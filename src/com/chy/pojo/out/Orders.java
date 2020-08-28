package com.chy.pojo.out;

public class Orders {
    private Integer id;

    private String orderCode;

    private Byte status;

    private Float totalMoney;

    private String createTime;

    private String thd;

    private String thTime;

    private String thr;

    private String thPhone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getThd() {
        return thd;
    }

    public void setThd(String thd) {
        this.thd = thd == null ? null : thd.trim();
    }

    public String getThTime() {
        return thTime;
    }

    public void setThTime(String thTime) {
        this.thTime = thTime == null ? null : thTime.trim();
    }

    public String getThr() {
        return thr;
    }

    public void setThr(String thr) {
        this.thr = thr == null ? null : thr.trim();
    }

    public String getThPhone() {
        return thPhone;
    }

    public void setThPhone(String thPhone) {
        this.thPhone = thPhone == null ? null : thPhone.trim();
    }
}