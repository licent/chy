package com.chy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.JsonArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chy.pojo.out.Order;
import com.chy.pojo.out.OrderItem;
import com.chy.service.OrderItemService;
import com.chy.service.OrderService;
import com.tools.ResponseCode;
import com.tools.ResponseInfo;
import com.tools.Tools;

/**
 * @订单控制器
 */

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderItemService orderItemService;

	/**
	 * 新建订单
	 */
	@RequestMapping("/manage/order/create")
	@ResponseBody
	public String createOrder(@RequestParam Map<String, Object> params) {
		ResponseInfo<Order> info = new ResponseInfo<Order>();
		try {
			Order order = new Order();
			order.setTotalMoney((Float) params.get("totalMoney"));
			order.setThd((String) params.get("thd"));
			order.setThr((String) params.get("thr"));
			order.setThTime((String) params.get("thTime"));
			order.setThPhone((String) params.get("thPhone"));
			order.setUserId((String) params.get("userId"));
			order.setZtdId((Integer) params.get("ztdId"));

			/**
			 * itemId orderId num
			 */
			List<OrderItem> orderItemList = new ArrayList<OrderItem>();
			JSONArray ja = JSONArray.parseArray(Tools.ObjectToJsonString(params.get("orderItemList")));
			orderItemList=JSONObject.parseArray(ja.toJSONString(), OrderItem.class);

			info.setData(orderService.creatOrder(order, orderItemList, Tools.ObjectToString(params.get("itemList"))));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
	
	/**
	 * 修改订单状态
	 */
	@RequestMapping("/manage/order/updateStatus")
	@ResponseBody
	public String updateOrder(@RequestParam Map<String, Object> params) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {
			Order order =new Order();
			order.setId((Integer)params.get("orderId"));
			order.setStatus((Byte)params.get("status"));
			
			info.setData(orderService.updateByPrimaryKeySelective(order));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
	
	
	/**
	 * 修改订单商品数量
	 */
	@RequestMapping("/manage/order/updateOrderItemNum")
	@ResponseBody
	public String updateOrderItemNum(@RequestParam Map<String, Object> params) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {
			//orderId
			//itemId
			//num
			info.setData(orderItemService.updateByParams(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
	
	/**
	 * 查询订单 
	 * */

}
