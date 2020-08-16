package com.pojo.out;

public class ItemWithBLOBs extends Item {
    private String ft;

    private String details;

    public String getFt() {
        return ft;
    }

    public void setFt(String ft) {
        this.ft = ft == null ? null : ft.trim();
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }
}