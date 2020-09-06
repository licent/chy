package com.tools;

import java.io.FileInputStream;

import com.alibaba.fastjson.JSONObject;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class Uploader {
	public static String uploadFile(FileInputStream in) throws Exception {
		String picUrlString = "http://qf7ff1sr2.hn-bkt.clouddn.com/";
		// 构造一个带指定 Region 对象的配置类
		Configuration cfg = new Configuration(Region.huanan());
		// ...其他参数参考类注释
		UploadManager uploadManager = new UploadManager(cfg);
		// ...生成上传凭证，然后准备上传
		String accessKey = "44uCYchAyg2p05_yW2mL2XeEa1gy-bB746NF9lQu";
		String secretKey = "DtnmWpI6eiVH-qo1YoLy3Q0ZfGm1m2r6-fUTARcX";
		String bucket = "chioya";
		// 默认不指定key的情况下，以文件内容的hash值作为文件名
		String key = null;
		try {
			Auth auth = Auth.create(accessKey, secretKey);
			String upToken = auth.uploadToken(bucket);
			Response response = uploadManager.put(in, key, upToken, null, null);
			// 解析上传成功的结果
			JSONObject json=JSONObject.parseObject(response.bodyString());
			System.out.println(json.getString("key"));
			System.out.println(json.getString("hash"));
			if (json.getString("hash") != null && !"".equals(json.getString("hash"))) {
				return picUrlString + json.getString("hash");
			} else {
				return null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		uploadFile(new FileInputStream("d:/pic/10.jpg"));
	}
}
