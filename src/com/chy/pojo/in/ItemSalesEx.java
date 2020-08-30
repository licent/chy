package com.chy.pojo.in;

/**
 * @商品销售量扩展属性
 */
public class ItemSalesEx {
	// 总销量
	private long totalSales;
	// 总下单人数
	private long totalBuys;

	public long getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(long totalSales) {
		this.totalSales = totalSales;
	}

	public long getTotalBuys() {
		return totalBuys;
	}

	public void setTotalBuys(long totalBuys) {
		this.totalBuys = totalBuys;
	}

}
