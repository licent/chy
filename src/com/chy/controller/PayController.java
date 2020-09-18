package com.chy.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chy.pojo.in.OrderGrossEx;
import com.chy.pojo.out.Order;
import com.chy.pojo.out.User;
import com.chy.service.ItemService;
import com.chy.service.OrderGrossService;
import com.chy.service.OrderService;
import com.chy.service.UserService;
import com.tools.ResponseCode;
import com.tools.ResponseInfo;
import com.tools.StreamUtil;
import com.tools.Tools;

@Controller
public class PayController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	OrderGrossService orderGrossService;
	
	@Autowired
	UserService userService;

	/**
	 * 微信支付接口
	 */
	@RequestMapping("/manage/pay/wechatPay")
	@ResponseBody
	public String wechatPay(@RequestParam Map<String, Object> params) {
		ResponseInfo<Map<String, String>> info = new ResponseInfo<Map<String, String>>();
		try {

			if (params.get("orderId") == null) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("参数缺失orderId");
				return info.toJsonString();
			}

			Order rcount = orderService.selectByPrimaryKey(Tools.ObjectToInt(params.get("orderId")));
			if (rcount == null) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("订单不存在");
				return info.toJsonString();
			}

			Map<String, String> resultData = new HashMap<String, String>();

			
			// orderId
			String re = orderService.wechatPay(rcount, Tools.ObjectToString(params.get("openId")));
			if (re != null && re.contains("<return_code><![CDATA[SUCCESS]]></return_code>")
					&& re.contains("<result_code><![CDATA[SUCCESS]]></result_code>")) {

				re = re.replace("<![CDATA[", "");
				re = re.replace("]]>", "");

				String sign = re.split("<sign>")[1].split("</sign>")[0];
				String nonce_str = re.split("<nonce_str>")[1].split("</nonce_str>")[0];
				String prepay_id = re.split("<prepay_id>")[1].split("</prepay_id>")[0];
				resultData.put("sign", sign);
				resultData.put("nonce_str", nonce_str);
				resultData.put("prepay_id", prepay_id);
				info.setData(resultData);
				info.setCode(ResponseCode.SUCC);
				info.setMsg("发起支付成功");
				
			} else {
				resultData.put("error", re);
				info.setData(resultData);
				info.setCode(ResponseCode.FAIL);
				info.setMsg("发起支付失败");
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
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/manage/pay/wechatPayCallBack")
	@ResponseBody
	public String wechatPayCallBack(HttpServletRequest request) throws Exception {
		InputStream is = request.getInputStream();
		String xml = StreamUtil.inputStream2String(is, "UTF-8");
		
		System.out.println(xml);
		
		xml=xml.replace("<![CDATA[", "");
		xml=xml.replace("]]>", "");
		
		String orderCode=xml.split("<out_trade_no>")[1].split("</out_trade_no>")[0];
		
		Order record = new Order();
		record.setOrderCode(orderCode);
		record.setStatus(new Byte("1"));
		
		int r = orderService.updateStatusByOrderCode(record);
		int r2=0;
		if (r>0) {
			// 有效订单才进行毛利数据存储
			Map<String, Object> p = new HashMap<String, Object>();
			p.put("orderCode", record.getOrderCode());
			// 查询订单商品情况
			List<OrderGrossEx> result = itemService.selectItemGrossInfolistByOrderId(p);
			if (result != null && result.size() == 1) {
				// 毛利记录表保存
				r2=orderGrossService.insertBatch(result);
				System.out.println("[ORDER]:"+orderCode+" success pay! And "+r2+" rows gross produce!");
			}else {
				System.out.println("[ORDER]:"+orderCode+" success pay! And no gross produce!");
			}
		}else {
			System.out.println("[ORDER]:"+orderCode+" status change fail!!!");
		}
		
		//返回给微信
		String resultXml="<xml>"+
				  "<return_code><![CDATA[SUCCESS]]></return_code>"+
				  "<return_msg><![CDATA[OK]]></return_msg>"+
				"</xml>";
		return resultXml;
	}
	
	
	/**
	 * 微信提现
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/manage/pay/wechatGetCash")
	@ResponseBody
	public String wechatGetCash(@RequestParam Map<String, Object> params) throws Exception {
		ResponseInfo<Map<String, String>> info = new ResponseInfo<Map<String, String>>();
		try {

			if (params.get("userId") == null) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("参数缺失userId");
				return info.toJsonString();
			}

			User user = userService.selectByPrimaryKey(Tools.ObjectToInt(params.get("userId")));
			if (user == null) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("用户不存在");
				return info.toJsonString();
			}

			Map<String, String> resultData = new HashMap<String, String>();

			// orderId
			String re = orderService.wechatGetCash(user);
			
			if (re != null && re.contains("<return_code><![CDATA[SUCCESS]]></return_code>")
					&& re.contains("<result_code><![CDATA[SUCCESS]]></result_code>")) {

				re = re.replace("<![CDATA[", "");
				re = re.replace("]]>", "");

				String sign = re.split("<sign>")[1].split("</sign>")[0];
				String nonce_str = re.split("<nonce_str>")[1].split("</nonce_str>")[0];
				String prepay_id = re.split("<prepay_id>")[1].split("</prepay_id>")[0];
				resultData.put("sign", sign);
				resultData.put("nonce_str", nonce_str);
				resultData.put("prepay_id", prepay_id);
				info.setData(resultData);
				info.setCode(ResponseCode.SUCC);
				info.setMsg("发起支付成功");
				
			} else {
				resultData.put("error", re);
				info.setData(resultData);
				info.setCode(ResponseCode.FAIL);
				info.setMsg("发起支付失败");
			}
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

}
