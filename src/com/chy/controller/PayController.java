package com.chy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chy.pojo.out.Order;
import com.chy.pojo.out.User;
import com.chy.service.OrderService;
import com.tools.ResponseCode;
import com.tools.ResponseInfo;
import com.tools.Tools;

@Controller
public class PayController {
	
	@Autowired
	OrderService orderService;
	
	/**
	 * 微信支付接口
	 * */
	@RequestMapping("/manage/pay/wechatPay")
	@ResponseBody
	public String wechatPay(@RequestParam Map<String, Object> params) {
		ResponseInfo<String> info = new ResponseInfo<String>();
		try {
			
			if(params.get("orderId")==null) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("参数缺失orderId");
				return info.toJsonString();
			}
			
			Order record =new Order();
			record.setId(Tools.ObjectToInt(params.get("orderId")));
			
			Order rcount=orderService.selectByPrimaryKey(record.getId());
			if(rcount==null) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("订单不存在");
				return info.toJsonString();
			}
			
			record.setStatus(new Byte("1"));
			//orderId
			String re=orderService.wechatPay(rcount,Tools.ObjectToString(params.get("openId")));
			if(re!=null && re.contains("<return_code><![CDATA[SUCCESS]]></return_code>") && re.contains("<result_code><![CDATA[SUCCESS]]></result_code>")) {
				info.setCode(ResponseCode.SUCC);
				info.setMsg("支付成功");
				int r=orderService.updateByPrimaryKeySelective(record);
				info.setMsg(r+"行订单状态修改");
				info.setData("支付回调报文:"+re);
			}else {
				info.setData(re);
				info.setCode(ResponseCode.FAIL);
				info.setMsg("支付失败");
			}
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
	
	
	/**
	 * 微信支付回调接口
	 * */
	@RequestMapping("/manage/pay/wechatPayCallBack")
	@ResponseBody
	public String wechatPayCallBack(@RequestBody String wePayParams) {
		ResponseInfo<User> info = new ResponseInfo<User>();
		try {
			System.out.println(wePayParams);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
	
	
}
