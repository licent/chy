package com.pojo.out;

public class ItemCollect {
    private Integer id;

    private Integer adminId;

    private Integer itemId;

    private String cuDate;

    private Byte status;

    private String itemOuterId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getCuDate() {
        return cuDate;
    }

    public void setCuDate(String cuDate) {
        this.cuDate = cuDate == null ? null : cuDate.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getItemOuterId() {
        return itemOuterId;
    }

    public void setItemOuterId(String itemOuterId) {
        this.itemOuterId = itemOuterId == null ? null : itemOuterId.trim();
    }
}