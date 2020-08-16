package com.pojo.out;

public class TitleHistory {
    private Integer id;

    private String cuDate;

    private String title;

    private Integer dataId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCuDate() {
        return cuDate;
    }

    public void setCuDate(String cuDate) {
        this.cuDate = cuDate == null ? null : cuDate.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }
}