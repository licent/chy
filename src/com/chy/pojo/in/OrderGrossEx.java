package com.chy.pojo.in;

/**
 * @毛利扩展信息
 */
public class OrderGrossEx {
	private Integer userId;
	private Integer orderId;
	private Integer num;
	private Integer itemId;
	private Float money;
	private Float purchaseMoney;
	private Integer type;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	public Float getPurchaseMoney() {
		return purchaseMoney;
	}

	public void setPurchaseMoney(Float purchaseMoney) {
		this.purchaseMoney = purchaseMoney;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
