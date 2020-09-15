package com.tools;

import static com.tools.WXPayConstants.USER_AGENT;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.imageio.stream.FileImageOutputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class MyHttpSender {
	public static String UPLOAD_URL = "https://api.weixin.qq.com/sns/jscode2session";

	public static String MSG_CODE_SEND_URL = "https://3ke.xyz/api/ali/sms";

	public static String WE_CHAT_PAY = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	public static String GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token";

	public static String GET_QR_CODE = "https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode";

	/**
	 * @图片上传公共接口调用
	 */
	public static String commonGet(String u, String params) throws Exception {
		String strResult = "9";
		try {
			String url = u + "?" + params;
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
	 */
	public static String commonPost(String u, Map<String, String> params) throws Exception {
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

			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters, "UTF-8");
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
	 * post公共接口
	 */
	public static String commonPostJsonParams(String u, Map<String, String> params) throws Exception {
		String base64str="";
		try {
			
			String url = u;
			System.out.println(url);
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);

			StringEntity requestEntity = new StringEntity(Tools.ObjectToJsonString(params), "utf-8");
			requestEntity.setContentEncoding("UTF-8");
			httpPost.setHeader("Content-type", "application/json");

			httpPost.setEntity(requestEntity);


			CloseableHttpResponse response = httpClient.execute(httpPost);
			if (response != null && response.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = response.getEntity();
				byte [] strResult = EntityUtils.toByteArray(entity);
				
				//FileImageOutputStream imageOutput = new FileImageOutputStream(new File("D:\\qrCode.png"));// 打开输入流
				
				base64str = Base64.encode(strResult);
//
//				imageOutput.write(strResult, 0, strResult.length);// 将byte写入硬盘
//
//				imageOutput.close();
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
		
		return base64str;
		
	}

	/**
	 * post公共 xml参数
	 */
	public static String commonPost(String u, String xmlString, String MchId, int readTimeoutMs, int connectTimeoutMs)
			throws Exception {
		String strResult = "9";
		try {
			BasicHttpClientConnectionManager connManager = new BasicHttpClientConnectionManager(
					RegistryBuilder.<ConnectionSocketFactory>create()
							.register("http", PlainConnectionSocketFactory.getSocketFactory())
							.register("https", SSLConnectionSocketFactory.getSocketFactory()).build(),
					null, null, null);
			HttpClient httpClient = HttpClientBuilder.create().setConnectionManager(connManager).build();

			HttpPost httpPost = new HttpPost(u);

			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(readTimeoutMs)
					.setConnectTimeout(connectTimeoutMs).build();
			httpPost.setConfig(requestConfig);

			StringEntity postEntity = new StringEntity(xmlString, "UTF-8");
			httpPost.addHeader("Content-Type", "text/xml");
			httpPost.addHeader("User-Agent", USER_AGENT + " " + MchId);
			httpPost.setEntity(postEntity);

			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			return EntityUtils.toString(httpEntity, "UTF-8");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return strResult;
	}

}
