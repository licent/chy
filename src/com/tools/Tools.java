package com.tools;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;

/**
 * 常用工具类封装
 * 
 * @author Taylor.O
 */
public class Tools {
	/**
	 * 调整字符编码
	 * 
	 * @author Only
	 */
	public static String changeEncode(String str) {
		if (str != null) {
			try {
				return new String(str.getBytes("iso8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	/**
	 * 字符串转int
	 */
	public static int strToInt(String str) {
		return str != null && !str.equals("") ? Integer.parseInt(str) : 0;
	}

	/**
	 * 字符串转long
	 */
	public static long strToLong(String str) {
		return str != null && !str.equals("") ? Long.parseLong(str) : 0;
	}

	/**
	 * Object转String
	 */
	public static String ObjectToString(Object obj) {
		return obj != null ? obj.toString() : "";
	}
	
	/**
	 * Object转String
	 */
	public static Float ObjectToFloat(Object obj) {
		return obj != null ? Float.parseFloat(obj.toString()) : 0f;
	}

	/**
	 * Object转JSONSTRING
	 */
	public static String ObjectToJsonString(Object obj) {
		return JSON.toJSONString(obj);
	}

	/**
	 * Object转int
	 */
	public static int ObjectToInt(Object obj) {
		return obj != null ? Integer.parseInt(obj.toString()) : 0;
	}
	/**
	 * Object转Byte
	 */
	public static Byte ObjectToByte(Object obj) {
		return obj !=null ? Byte.parseByte(obj.toString()) :null;
	}
	/**
	 * Object转long
	 **/
	public static long ObjectToLong(Object obj) {
		return obj != null ? Long.parseLong(obj.toString()) : 0;
	}

	/**
	 * bean转map
	 */
	public static Map<String, Object> beanToMap(Object bean) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (bean == null) {
			return map;
		}
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				if (!key.equals("class")) {
					Method getter = property.getReadMethod();
					Object value = getter.invoke(bean);
					map.put(key, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * bean转map
	 */
	public static Map<String, Object> beanToMap2(Map<String, Object> map, Object bean) {
		if (bean == null) {
			return map;
		}
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				if (!key.equals("class")) {
					Method getter = property.getReadMethod();
					Object value = getter.invoke(bean);
					map.put(key, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * null转换�?""
	 */
	public static String nullToEmpty(String str) {
		return str == null ? "" : str;
	}

	/**
	 * 获取当前时间
	 */
	public static String getCurrentTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date());
	}

	/**
	 * 获取当前时间
	 */
	public static String getCurrentTimeStr() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return df.format(new Date());
	}

	/**
	 * 去掉时间末尾�?.0
	 */
	public static String removeTimeTail(String time) {
		return time.replace(".0", "");
	}

	/**
	 * 获取项目根目�?
	 */
	public static String getRealPath(HttpServletRequest request) {
		return request.getSession().getServletContext().getRealPath("/");
	}

	/**
	 * 获取配置信息
	 */
	public static String getConfigInfo(String key) {
		String filename = "config";
		ResourceBundle resource = ResourceBundle.getBundle(filename);
		return key = resource.getString(key);
	}

	/**
	 * 对象转换成String
	 */
	public static String valueOf(Object obj) {
		return (obj == null) ? "" : obj.toString();
	}

	/**
	 * 空�?? 空字符串判断
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.equals("") ? true : false;
	}

	public static String escape(String src) {
		int i;
		char j;
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length() * 6);
		for (i = 0; i < src.length(); i++) {
			j = src.charAt(i);
			if (Character.isDigit(j) || Character.isLowerCase(j) || Character.isUpperCase(j))
				tmp.append(j);
			else if (j < 256) {
				tmp.append("%");
				if (j < 16)
					tmp.append("0");
				tmp.append(Integer.toString(j, 16));
			} else {
				tmp.append("%u");
				tmp.append(Integer.toString(j, 16));
			}
		}
		return tmp.toString();
	}

	public static String unescape(String src) {
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length());
		int lastPos = 0, pos = 0;
		char ch;
		while (lastPos < src.length()) {
			pos = src.indexOf("%", lastPos);
			if (pos == lastPos) {
				if (src.charAt(pos + 1) == 'u') {
					ch = (char) Integer.parseInt(src.substring(pos + 2, pos + 6), 16);
					tmp.append(ch);
					lastPos = pos + 6;
				} else {
					ch = (char) Integer.parseInt(src.substring(pos + 1, pos + 3), 16);
					tmp.append(ch);
					lastPos = pos + 3;
				}
			} else {
				if (pos == -1) {
					tmp.append(src.substring(lastPos));
					lastPos = src.length();
				} else {
					tmp.append(src.substring(lastPos, pos));
					lastPos = pos;
				}
			}
		}
		return tmp.toString();
	}

	/**
	 * 取1-i范围内的随机整数
	 */
	public static long randomNumber(long i) {
		return (long) (1 + Math.random() * (i - 1 + 1));
	}

}