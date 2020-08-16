package com.pojo.out;

public class UserAddress {
    private Integer id;

    private String address;

    private String userId;

    private Byte selected;

    private String phone;

    private Integer ztdId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Byte getSelected() {
        return selected;
    }

    public void setSelected(Byte selected) {
        this.selected = selected;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getZtdId() {
        return ztdId;
    }

    public void setZtdId(Integer ztdId) {
        this.ztdId = ztdId;
    }
}