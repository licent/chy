package com.pojo.out;

import java.util.Date;

public class Budan {
    private Integer id;

    private String itemOuterId;

    private Integer storeId;

    private String title;

    private String picUrl;

    private Float cuxiaoPrice;

    private Float jinhuoPrice;

    private Float youhuiPrice;

    private Date itemCreated;

    private Date mendDate;

    private String productNo;

    private Integer lifeTag;

    private Integer budanTag;

    private Float platformCostRate;

    private String mendSleepTime;

    private Byte status;

    private Float expressCost;

    private Float giftCost;

    private Byte isCheck;

    private String checkMan;

    private String checkTime;

    private Byte haveJi;

    private String personInCharge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemOuterId() {
        return itemOuterId;
    }

    public void setItemOuterId(String itemOuterId) {
        this.itemOuterId = itemOuterId == null ? null : itemOuterId.trim();
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public Float getCuxiaoPrice() {
        return cuxiaoPrice;
    }

    public void setCuxiaoPrice(Float cuxiaoPrice) {
        this.cuxiaoPrice = cuxiaoPrice;
    }

    public Float getJinhuoPrice() {
        return jinhuoPrice;
    }

    public void setJinhuoPrice(Float jinhuoPrice) {
        this.jinhuoPrice = jinhuoPrice;
    }

    public Float getYouhuiPrice() {
        return youhuiPrice;
    }

    public void setYouhuiPrice(Float youhuiPrice) {
        this.youhuiPrice = youhuiPrice;
    }

    public Date getItemCreated() {
        return itemCreated;
    }

    public void setItemCreated(Date itemCreated) {
        this.itemCreated = itemCreated;
    }

    public Date getMendDate() {
        return mendDate;
    }

    public void setMendDate(Date mendDate) {
        this.mendDate = mendDate;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    public Integer getLifeTag() {
        return lifeTag;
    }

    public void setLifeTag(Integer lifeTag) {
        this.lifeTag = lifeTag;
    }

    public Integer getBudanTag() {
        return budanTag;
    }

    public void setBudanTag(Integer budanTag) {
        this.budanTag = budanTag;
    }

    public Float getPlatformCostRate() {
        return platformCostRate;
    }

    public void setPlatformCostRate(Float platformCostRate) {
        this.platformCostRate = platformCostRate;
    }

    public String getMendSleepTime() {
        return mendSleepTime;
    }

    public void setMendSleepTime(String mendSleepTime) {
        this.mendSleepTime = mendSleepTime == null ? null : mendSleepTime.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Float getExpressCost() {
        return expressCost;
    }

    public void setExpressCost(Float expressCost) {
        this.expressCost = expressCost;
    }

    public Float getGiftCost() {
        return giftCost;
    }

    public void setGiftCost(Float giftCost) {
        this.giftCost = giftCost;
    }

    public Byte getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Byte isCheck) {
        this.isCheck = isCheck;
    }

    public String getCheckMan() {
        return checkMan;
    }

    public void setCheckMan(String checkMan) {
        this.checkMan = checkMan == null ? null : checkMan.trim();
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime == null ? null : checkTime.trim();
    }

    public Byte getHaveJi() {
        return haveJi;
    }

    public void setHaveJi(Byte haveJi) {
        this.haveJi = haveJi;
    }

    public String getPersonInCharge() {
        return personInCharge;
    }

    public void setPersonInCharge(String personInCharge) {
        this.personInCharge = personInCharge == null ? null : personInCharge.trim();
    }
}