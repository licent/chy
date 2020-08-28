package com.chy.pojo.out;

public class UserFct {
    private Integer id;

    private String userId;

    private String fctId;

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

    public String getFctId() {
        return fctId;
    }

    public void setFctId(String fctId) {
        this.fctId = fctId == null ? null : fctId.trim();
    }
}