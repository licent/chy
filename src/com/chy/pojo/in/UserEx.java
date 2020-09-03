package com.chy.pojo.in;

/**
 * @用户扩展信息
 */
public class UserEx {
	private String name;
	private String endTime;
	private String img;
	private Integer num;
	
	
	//判断用户是否是厂商 店长扩展字段
	private Integer isAutoPoint;
	private Integer isFactory;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getIsAutoPoint() {
		return isAutoPoint;
	}

	public void setIsAutoPoint(Integer isAutoPoint) {
		this.isAutoPoint = isAutoPoint;
	}

	public Integer getIsFactory() {
		return isFactory;
	}

	public void setIsFactory(Integer isFactory) {
		this.isFactory = isFactory;
	}
	
}
