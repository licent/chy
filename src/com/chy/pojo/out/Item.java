package com.chy.pojo.out;

import java.util.Date;
import java.util.List;

public class Item {
	private Integer id;

	private String created;

	private String modified;

	private String name;

	private String code;

	private String picUrl;

	private String status;

	private String businessCode;

	private Integer supplierId;

	private Float price;

	private Float cardPrice;

	private String tsc;

	private String outerId;

	private Integer storeId;

	private Float purchasePrice;

	private String binds;

	private String saleProps;

	private Byte verticalMarket;

	private String customerProps;

	private String propertyAlias;

	private Integer productId;

	private Integer cid;

	private String catName;

	private String props;

	private String propsStr;

	private String bindsStr;

	private String salePropsStr;

	private String sellPt;

	private Integer itemTagId;

	private String updateer;

	private Date listTime;

	private Float discountPrice;

	private String title;

	private Integer salesVolume;

	private Integer refundVolume;

	private Byte state;

	private Byte haveSku;

	private Byte haveThis;

	private String getTime;

	private String yushuoTime;

	private Integer limits;

	private Integer tag;

	private Integer renqi;

	private Integer ishot;

	private List<User> userList;

	private Integer num;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created == null ? null : created.trim();
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified == null ? null : modified.trim();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl == null ? null : picUrl.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode == null ? null : businessCode.trim();
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getCardPrice() {
		return cardPrice;
	}

	public void setCardPrice(Float cardPrice) {
		this.cardPrice = cardPrice;
	}

	public String getTsc() {
		return tsc;
	}

	public void setTsc(String tsc) {
		this.tsc = tsc == null ? null : tsc.trim();
	}

	public String getOuterId() {
		return outerId;
	}

	public void setOuterId(String outerId) {
		this.outerId = outerId == null ? null : outerId.trim();
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Float getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Float purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public String getBinds() {
		return binds;
	}

	public void setBinds(String binds) {
		this.binds = binds == null ? null : binds.trim();
	}

	public String getSaleProps() {
		return saleProps;
	}

	public void setSaleProps(String saleProps) {
		this.saleProps = saleProps == null ? null : saleProps.trim();
	}

	public Byte getVerticalMarket() {
		return verticalMarket;
	}

	public void setVerticalMarket(Byte verticalMarket) {
		this.verticalMarket = verticalMarket;
	}

	public String getCustomerProps() {
		return customerProps;
	}

	public void setCustomerProps(String customerProps) {
		this.customerProps = customerProps == null ? null : customerProps.trim();
	}

	public String getPropertyAlias() {
		return propertyAlias;
	}

	public void setPropertyAlias(String propertyAlias) {
		this.propertyAlias = propertyAlias == null ? null : propertyAlias.trim();
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName == null ? null : catName.trim();
	}

	public String getProps() {
		return props;
	}

	public void setProps(String props) {
		this.props = props == null ? null : props.trim();
	}

	public String getPropsStr() {
		return propsStr;
	}

	public void setPropsStr(String propsStr) {
		this.propsStr = propsStr == null ? null : propsStr.trim();
	}

	public String getBindsStr() {
		return bindsStr;
	}

	public void setBindsStr(String bindsStr) {
		this.bindsStr = bindsStr == null ? null : bindsStr.trim();
	}

	public String getSalePropsStr() {
		return salePropsStr;
	}

	public void setSalePropsStr(String salePropsStr) {
		this.salePropsStr = salePropsStr == null ? null : salePropsStr.trim();
	}

	public String getSellPt() {
		return sellPt;
	}

	public void setSellPt(String sellPt) {
		this.sellPt = sellPt == null ? null : sellPt.trim();
	}

	public Integer getItemTagId() {
		return itemTagId;
	}

	public void setItemTagId(Integer itemTagId) {
		this.itemTagId = itemTagId;
	}

	public String getUpdateer() {
		return updateer;
	}

	public void setUpdateer(String updateer) {
		this.updateer = updateer == null ? null : updateer.trim();
	}

	public Date getListTime() {
		return listTime;
	}

	public void setListTime(Date listTime) {
		this.listTime = listTime;
	}

	public Float getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Float discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public Integer getSalesVolume() {
		return salesVolume;
	}

	public void setSalesVolume(Integer salesVolume) {
		this.salesVolume = salesVolume;
	}

	public Integer getRefundVolume() {
		return refundVolume;
	}

	public void setRefundVolume(Integer refundVolume) {
		this.refundVolume = refundVolume;
	}

	public Byte getState() {
		return state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

	public Byte getHaveSku() {
		return haveSku;
	}

	public void setHaveSku(Byte haveSku) {
		this.haveSku = haveSku;
	}

	public Byte getHaveThis() {
		return haveThis;
	}

	public void setHaveThis(Byte haveThis) {
		this.haveThis = haveThis;
	}

	public String getGetTime() {
		return getTime;
	}

	public void setGetTime(String getTime) {
		this.getTime = getTime == null ? null : getTime.trim();
	}

	public String getYushuoTime() {
		return yushuoTime;
	}

	public void setYushuoTime(String yushuoTime) {
		this.yushuoTime = yushuoTime == null ? null : yushuoTime.trim();
	}

	public Integer getLimits() {
		return limits;
	}

	public void setLimits(Integer limits) {
		this.limits = limits;
	}

	public Integer getTag() {
		return tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

	public Integer getRenqi() {
		return renqi;
	}

	public void setRenqi(Integer renqi) {
		this.renqi = renqi;
	}

	public Integer getIshot() {
		return ishot;
	}

	public void setIshot(Integer ishot) {
		this.ishot = ishot;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}