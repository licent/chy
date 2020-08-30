package com.chy.pojo.out;

import java.math.BigDecimal;

public class User {
    private Integer id;

    private String name;

    private String phone;

    private String openId;

    private BigDecimal money;

    private Integer parentId;

    private String img;

    private String idCardImg;

    private String zipai;

    private String idCardNo;

    private Byte isAuthentication;

    private Integer addTime;

    private String bsnsPwd;

    private String bsnsPwdSalt;

    private String addTimeStr;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getIdCardImg() {
        return idCardImg;
    }

    public void setIdCardImg(String idCardImg) {
        this.idCardImg = idCardImg == null ? null : idCardImg.trim();
    }

    public String getZipai() {
        return zipai;
    }

    public void setZipai(String zipai) {
        this.zipai = zipai == null ? null : zipai.trim();
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo == null ? null : idCardNo.trim();
    }

    public Byte getIsAuthentication() {
        return isAuthentication;
    }

    public void setIsAuthentication(Byte isAuthentication) {
        this.isAuthentication = isAuthentication;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public String getBsnsPwd() {
        return bsnsPwd;
    }

    public void setBsnsPwd(String bsnsPwd) {
        this.bsnsPwd = bsnsPwd == null ? null : bsnsPwd.trim();
    }

    public String getBsnsPwdSalt() {
        return bsnsPwdSalt;
    }

    public void setBsnsPwdSalt(String bsnsPwdSalt) {
        this.bsnsPwdSalt = bsnsPwdSalt == null ? null : bsnsPwdSalt.trim();
    }

    public String getAddTimeStr() {
        return addTimeStr;
    }

    public void setAddTimeStr(String addTimeStr) {
        this.addTimeStr = addTimeStr == null ? null : addTimeStr.trim();
    }

}