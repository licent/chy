package com.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @专门用于ID生成
 */
public class IDMaker {
	// 商品
	private static final String SP = "SP";
	// 厂商
	private static final String CS = "CS";
	// 订单号
	private static final String DH = "DH";

	// test
	public static void main(String[] args) {
		System.out.println(new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date()));
	}

	public static synchronized String createOrderCode() {
		return DH + new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date());
	}

	public static synchronized String createFatoryCode() {
		return CS + new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date());
	}

	public static synchronized String createItemCode() {
		return SP + new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date());
	}
}
