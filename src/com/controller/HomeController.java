package com.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tools.ResponseCode;
import com.tools.ResponseInfo;

import net.sf.json.processors.JsonBeanProcessor;

/**
 * @author Taylor.O
 * @首页控制器
 * 
 */

@Controller
public class HomeController {
	/**
	 * 首页数据初始化
	 * */
	@RequestMapping("/initHomePage")
	@ResponseBody
	public String initHomePage(@RequestParam Map<String,String> params) {
		ResponseInfo<String> info =new ResponseInfo<String>();
		try {
			System.out.println(params.toString());
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
}
