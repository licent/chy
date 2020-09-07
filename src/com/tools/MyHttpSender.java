package com.tools;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class MyHttpSender {
	public static String UPLOAD_URL="https://api.weixin.qq.com/sns/jscode2session";
	
	public static String MSG_CODE_SEND_URL="https://3ke.xyz/api/ali/sms";
	
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
	
}
