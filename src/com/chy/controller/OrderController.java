package com.chy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chy.pojo.in.OrderGrossEx;
import com.chy.pojo.out.Order;
import com.chy.pojo.out.OrderItem;
import com.chy.service.ItemService;
import com.chy.service.OrderGrossService;
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

	@Autowired
	ItemService itemService;

	@Autowired
	OrderGrossService orderGrossService;

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
			orderItemList = JSONObject.parseArray(ja.toJSONString(), OrderItem.class);

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
		ResponseInfo<Map<String, Integer>> info = new ResponseInfo<Map<String, Integer>>();
		Map<String, Integer> re = new HashMap<String, Integer>();
		try {
			Order order = new Order();
			order.setId((Integer) params.get("orderId"));
			order.setStatus((Byte) params.get("status"));
			int or = orderService.updateByPrimaryKeySelective(order);
			if (or > 0) {
				re.put("order_update_records", or);
				if(order.getId()==1 || order.getId()==2) {
					//有效订单才进行毛利数据存储
					Map<String, Object> p = new HashMap<String, Object>();
					params.put("orderId", order.getId());
					// 查询订单商品情况
					List<OrderGrossEx> result = itemService.selectItemGrossInfolistByOrderId(p);
					if (result != null && result.size() == 1) {
						// 毛利记录表保存
						re.put("order_gross_update_records", orderGrossService.insertBatch(result));
					}
				}
			}
			info.setData(re);
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
			// orderId
			// itemId
			// num
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
	 */
	@RequestMapping("/manage/order/orderList")
	@ResponseBody
	public String orderList(@RequestParam Map<String, Object> params) {
		ResponseInfo<List<Order>> info = new ResponseInfo<List<Order>>();
		try {
			// userId 或 status 或 orderId
			info.setData(orderService.selectListByParams(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

}
