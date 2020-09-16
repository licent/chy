package com.chy.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tools.MyHttpSender;
import com.tools.ResponseCode;
import com.tools.ResponseInfo;
import com.tools.Tools;


/**
 * @邀请二维码生成
 * */
@Controller
public class InviteController {
	
	@ResponseBody
	@RequestMapping("/manage/invite/inviteFactory")
	public String inviteFactory(@RequestParam Map<String, Object> params, HttpServletRequest request) {
		ResponseInfo<String> info = new ResponseInfo<String>();
		try {
			
			if(params.get("userId")==null) {
				info.setCode(ResponseCode.SUCC);
				info.setMsg("参数缺失userId");
				return info.toJsonString();
			}
			//user.getId()
			String urlTail="/pages/aboutus_firm_apply_for/aboutus_firm_apply_for?parentId="+Tools.ObjectToInt(params.get("userId"));
			
		    String result =MyHttpSender.commonGet(MyHttpSender.GET_ACCESS_TOKEN, "grant_type=client_credential&appid=wxce31758573e47ce3&secret=50745ba9b3b68f32a005a14ecf438ec5");
		    JSONObject ja =JSONObject.parseObject(result);
		    
		    Map<String,String> pa =new HashMap<String, String>();
		    pa.put("path", urlTail);
		    String base64=MyHttpSender.commonPostJsonParams(MyHttpSender.GET_QR_CODE+"?access_token="+ja.getString("access_token"), pa);
			info.setCode(ResponseCode.SUCC);
			info.setMsg(base64);
			info.setData(base64);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
	
	@ResponseBody
	@RequestMapping("/manage/invite/inviteAutoPoint")
	public String inviteAutoPoint(@RequestParam Map<String, Object> params, HttpServletRequest request) {
		ResponseInfo<String> info = new ResponseInfo<String>();
		try {
			
			if(params.get("userId")==null) {
				info.setCode(ResponseCode.SUCC);
				info.setMsg("参数缺失userId");
				return info.toJsonString();
			}
			//user.getId()
			String urlTail="/pages/shopowner/apply?parentId="+Tools.ObjectToInt(params.get("userId"));
			
		    String result =MyHttpSender.commonGet(MyHttpSender.GET_ACCESS_TOKEN, "grant_type=client_credential&appid=wxce31758573e47ce3&secret=50745ba9b3b68f32a005a14ecf438ec5");
		    JSONObject ja =JSONObject.parseObject(result);
		    
		    Map<String,String> pa =new HashMap<String, String>();
		    pa.put("path", urlTail);
		    String base64=MyHttpSender.commonPostJsonParams(MyHttpSender.GET_QR_CODE+"?access_token="+ja.getString("access_token"), pa);
			info.setCode(ResponseCode.SUCC);
			info.setData(base64);
			info.setMsg(base64);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
}
