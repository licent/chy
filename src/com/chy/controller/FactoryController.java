package com.chy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.chy.pojo.out.AutoPoint;
import com.chy.pojo.out.Factory;
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
	@RequestMapping("/manage/factory/createFactory")
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
			params.put("fCode",IDMaker.createFatoryCode());
			Factory f = JSONObject.parseObject(Tools.ObjectToJsonString(params), Factory.class);
			info.setData(factoryService.insertSelective(f));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
	/**
	 * 查询产商申请信息
	 */
	@RequestMapping("/manage/factory/selectFatoryApply")
	@ResponseBody
	public String selectFatoryApply(@RequestParam Map<String ,Object> params) {
		ResponseInfo<Factory> info = new ResponseInfo<Factory>();
		try {
			info.setData(factoryService.selectFatoryApply(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
	/**
	 * 删除申请信息
	 */
	@RequestMapping("/manage/factory/deleteFatoryApply")
	@ResponseBody
	public String deleteFatoryApply(@RequestParam Map<String,Object> params) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {
			int count = factoryService.deleteByPrimaryKey(Tools.ObjectToInt(params.get("id")));
			if(count>0) {
				info.setCode(ResponseCode.SUCC);
				return info.toJsonString();
			}
			info.setCode(ResponseCode.FAIL);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
}
