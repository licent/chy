package com.chy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.chy.pojo.out.Factory;
import com.chy.pojo.out.ItemWithBLOBs;
import com.chy.pojo.out.UserAddress;
import com.chy.service.FactoryService;
import com.tools.IDMaker;
import com.tools.ResponseCode;
import com.tools.ResponseInfo;
import com.tools.Tools;

/**
 * @厂商控制器
 */
@Controller
public class FactoryController {

	@Autowired
	FactoryService factoryService;

	/**
	 * 新增厂商
	 */
	@RequestMapping("/manage/autopoint/createFatory")
	@ResponseBody
	public String createFatory(@RequestParam Map<String, Object> params) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {
			// fName
			// fMark
			// fFool
			// fBoss
			// fPhone
			// fAlipay
			// fTenypay
			// userId
			// parentUserId
			// ft
			Factory f = JSONObject.parseObject(Tools.ObjectToJsonString(params), Factory.class);
			f.setfMr(IDMaker.createFatoryCode());
			info.setData(factoryService.insertSelective(f));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
}
