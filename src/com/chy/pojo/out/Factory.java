package com.chy.pojo.out;

public class Factory {
    private Integer id;
    
    private String fCode;
    
    private String fName;

    private String fMr;

    private String fMark;

    private String fFool;

    private String fBoss;

    private String fPhone;

    private String fAlipay;

    private String fTenypay;

    private Float fBalance;

    private Byte fStatus;

    private String fDiscount;

    private String userId;

    private String parentUserId;

    private String picUrl;

    private String ft;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getfCode() {
		return fCode;
	}

	public void setfCode(String fCode) {
		this.fCode = fCode;
	}

	public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName == null ? null : fName.trim();
    }

    public String getfMr() {
        return fMr;
    }

    public void setfMr(String fMr) {
        this.fMr = fMr == null ? null : fMr.trim();
    }

    public String getfMark() {
        return fMark;
    }

    public void setfMark(String fMark) {
        this.fMark = fMark == null ? null : fMark.trim();
    }

    public String getfFool() {
        return fFool;
    }

    public void setfFool(String fFool) {
        this.fFool = fFool == null ? null : fFool.trim();
    }

    public String getfBoss() {
        return fBoss;
    }

    public void setfBoss(String fBoss) {
        this.fBoss = fBoss == null ? null : fBoss.trim();
    }

    public String getfPhone() {
        return fPhone;
    }

    public void setfPhone(String fPhone) {
        this.fPhone = fPhone == null ? null : fPhone.trim();
    }

    public String getfAlipay() {
        return fAlipay;
    }

    public void setfAlipay(String fAlipay) {
        this.fAlipay = fAlipay == null ? null : fAlipay.trim();
    }

    public String getfTenypay() {
        return fTenypay;
    }

    public void setfTenypay(String fTenypay) {
        this.fTenypay = fTenypay == null ? null : fTenypay.trim();
    }

    public Float getfBalance() {
        return fBalance;
    }

    public void setfBalance(Float fBalance) {
        this.fBalance = fBalance;
    }

    public Byte getfStatus() {
        return fStatus;
    }

    public void setfStatus(Byte fStatus) {
        this.fStatus = fStatus;
    }

    public String getfDiscount() {
        return fDiscount;
    }

    public void setfDiscount(String fDiscount) {
        this.fDiscount = fDiscount == null ? null : fDiscount.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(String parentUserId) {
        this.parentUserId = parentUserId == null ? null : parentUserId.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getFt() {
        return ft;
    }

    public void setFt(String ft) {
        this.ft = ft == null ? null : ft.trim();
    }
}