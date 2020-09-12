package com.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class MyHttpSender {
	public static String UPLOAD_URL="https://api.weixin.qq.com/sns/jscode2session";
	
	public static String MSG_CODE_SEND_URL="https://3ke.xyz/api/ali/sms";
	
	public static String WE_CHAT_PAY="https://api.mch.weixin.qq.com/pay/unifiedorde";
	
	/**
	 * @图片上传公共接口调用 
	 * */
	public static String commonGet(String u,String params) throws Exception {
		String strResult = "9";
		try {
			String url = u +"?" + params;
			System.out.println(url);
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url);
			CloseableHttpResponse response = httpClient.execute(httpGet);
			if (response != null && response.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = response.getEntity(); 
				strResult = EntityUtils.toString(entity, "UTF-8");
			} else {
				strResult = "404";
			}
			if (response != null) {
				response.close();
			}
			if (httpClient != null) {
				httpClient.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strResult;
	}
	
	
	/**
	 * post公共接口
	 * */
	public static String commonPost(String u,Map<String,String> params) throws Exception {
		String strResult = "9";
		try {
			String url = u;
			System.out.println(url);
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);
			
			
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
	        for (Map.Entry<String, String> entry : params.entrySet()) {
	            parameters.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
	        }

			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters,"UTF-8");
			httpPost.setEntity(formEntity);
				
			CloseableHttpResponse response = httpClient.execute(httpPost);
			if (response != null && response.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = response.getEntity(); 
				strResult = EntityUtils.toString(entity, "UTF-8");
			} else {
				strResult = "404";
			}
			if (response != null) {
				response.close();
			}
			if (httpClient != null) {
				httpClient.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strResult;
	}
	
	
	/**
	 * post公共 xml参数
	 * */
	public static String commonPost(String u,String xmlString) throws Exception {
		String strResult = "9";
		try {
			String url = u;
			System.out.println(url);
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);

			StringEntity stringEntity=new StringEntity(xmlString);

			httpPost.setEntity(stringEntity);
				
			CloseableHttpResponse response = httpClient.execute(httpPost);
			if (response != null && response.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = response.getEntity(); 
				strResult = EntityUtils.toString(entity, "UTF-8");
			} else {
				strResult = "404";
			}
			if (response != null) {
				response.close();
			}
			if (httpClient != null) {
				httpClient.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strResult;
	}
	
}
