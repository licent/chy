package com.chy.pojo.out;

public class AutoPoint {
    private Integer id;

    private String ztd;

    private String address;

    private String phone;

    private String code;

    private Byte abnormal;

    private Integer userId;

    private Integer businessOrNot;

    private String closeStartTime;

    private Boolean isClose;

    private String closeEndTime;

    private Boolean isOpen;

    private Byte status;
    
    private String picUrl;

    private Integer parentUserId;
    
    private String localX;
    
    private String localY;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZtd() {
        return ztd;
    }

    public void setZtd(String ztd) {
        this.ztd = ztd == null ? null : ztd.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Byte getAbnormal() {
        return abnormal;
    }

    public void setAbnormal(Byte abnormal) {
        this.abnormal = abnormal;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBusinessOrNot() {
        return businessOrNot;
    }

    public void setBusinessOrNot(Integer businessOrNot) {
        this.businessOrNot = businessOrNot;
    }

    public String getCloseStartTime() {
        return closeStartTime;
    }

    public void setCloseStartTime(String closeStartTime) {
        this.closeStartTime = closeStartTime == null ? null : closeStartTime.trim();
    }

    public Boolean getIsClose() {
        return isClose;
    }

    public void setIsClose(Boolean isClose) {
        this.isClose = isClose;
    }

    public String getCloseEndTime() {
        return closeEndTime;
    }

    public void setCloseEndTime(String closeEndTime) {
        this.closeEndTime = closeEndTime == null ? null : closeEndTime.trim();
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}
	
	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Integer getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(Integer parentUserId) {
        this.parentUserId = parentUserId;
    }

	public String getLocalX() {
		return localX;
	}

	public void setLocalX(String localX) {
		this.localX = localX;
	}

	public String getLocalY() {
		return localY;
	}

	public void setLocalY(String localY) {
		this.localY = localY;
	}

}