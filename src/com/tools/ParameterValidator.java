package com.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Taylor.O
 * @参数校验器
 * 
 * */
public class ParameterValidator {
	
	//数字 大小写字母 下划线 8-20位长度
	public static final String USERNAME_REGEX="^([a-z0-9A-Z_]){8,20}$";
	//移动 联通 电信 三大运营商所有号段
	public static final String TELEPHONE_REGEX="^(133|149|153|173|177|180|181|189|191|199|130|131|132|145|155|156|166|171|175|176|185|186|134|135|136|137|138|139|147|150|151|152|157|158|159|172|178|182|183|184|187|188|198)\\d{8}$";
	
	
	//通用校验器
	public static boolean genericMatcher(String regexExpre,String testStr){
		Pattern pattern=Pattern.compile(regexExpre);
	    Matcher matcher = pattern.matcher(testStr);
	    return matcher.matches();
	}
	
	
	//调用示例
	public static void main(String[] args) {
		System.out.println(genericMatcher(USERNAME_REGEX,"asDHU12_31"));
		System.out.println(genericMatcher(TELEPHONE_REGEX,"13100020003"));
	}
}
