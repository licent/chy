package com.pojo.out;

public class Shopowner {
    private Integer id;

    private String userId;

    private String createTime;

    private String name;

    private String phone;

    private String autoPointId;

    private String idNum;

    private Byte isCheck;

    private String certificatesImg;

    private String checkTime;

    private String checkEr;

    private String parentUserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAutoPointId() {
        return autoPointId;
    }

    public void setAutoPointId(String autoPointId) {
        this.autoPointId = autoPointId == null ? null : autoPointId.trim();
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum == null ? null : idNum.trim();
    }

    public Byte getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Byte isCheck) {
        this.isCheck = isCheck;
    }

    public String getCertificatesImg() {
        return certificatesImg;
    }

    public void setCertificatesImg(String certificatesImg) {
        this.certificatesImg = certificatesImg == null ? null : certificatesImg.trim();
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime == null ? null : checkTime.trim();
    }

    public String getCheckEr() {
        return checkEr;
    }

    public void setCheckEr(String checkEr) {
        this.checkEr = checkEr == null ? null : checkEr.trim();
    }

    public String getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(String parentUserId) {
        this.parentUserId = parentUserId == null ? null : parentUserId.trim();
    }
}