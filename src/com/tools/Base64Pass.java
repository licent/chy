package com.tools;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Pass {

	// base64加密
	public static String encode(String password) throws Exception {
		return new BASE64Encoder().encode(password.getBytes());
	}

	// base64解密
	public static String decode(String password) throws Exception {
		return new String(new BASE64Decoder().decodeBuffer(password));
	}

}
