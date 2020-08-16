package com.pojo.out;

public class AbnormalOrder {
    private Integer id;

    private Integer orderId;

    private String itemIdArr;

    private String ft;

    private String content;

    private Integer userId;

    private Boolean status;

    private String doneTime;

    private Integer adminId;

    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getItemIdArr() {
        return itemIdArr;
    }

    public void setItemIdArr(String itemIdArr) {
        this.itemIdArr = itemIdArr == null ? null : itemIdArr.trim();
    }

    public String getFt() {
        return ft;
    }

    public void setFt(String ft) {
        this.ft = ft == null ? null : ft.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDoneTime() {
        return doneTime;
    }

    public void setDoneTime(String doneTime) {
        this.doneTime = doneTime == null ? null : doneTime.trim();
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
}