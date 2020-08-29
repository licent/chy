package com.chy.pojo.out;

import java.util.List;

public class Order {
    private Integer id;

    private String orderCode;

    private Byte status;

    private Float totalMoney;

    private String createTime;

    private String thd;

    private String thr;

    private String thTime;

    private String thPhone;

    private String userId;

    private Integer ztdId;

    private String endTime;

    private Boolean isBouns;

    private Boolean isSignFor;
    
    private List<Item> itemList;

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

    public String getThr() {
        return thr;
    }

    public void setThr(String thr) {
        this.thr = thr == null ? null : thr.trim();
    }

    public String getThTime() {
        return thTime;
    }

    public void setThTime(String thTime) {
        this.thTime = thTime == null ? null : thTime.trim();
    }

    public String getThPhone() {
        return thPhone;
    }

    public void setThPhone(String thPhone) {
        this.thPhone = thPhone == null ? null : thPhone.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getZtdId() {
        return ztdId;
    }

    public void setZtdId(Integer ztdId) {
        this.ztdId = ztdId;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public Boolean getIsBouns() {
        return isBouns;
    }

    public void setIsBouns(Boolean isBouns) {
        this.isBouns = isBouns;
    }

    public Boolean getIsSignFor() {
        return isSignFor;
    }

    public void setIsSignFor(Boolean isSignFor) {
        this.isSignFor = isSignFor;
    }

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
    
}