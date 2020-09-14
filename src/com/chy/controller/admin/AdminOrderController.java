package com.chy.controller.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chy.pojo.out.Item;
import com.chy.pojo.out.Order;
import com.chy.service.OrderService;
import com.tools.ResponseCode;
import com.tools.ResponseInfo;
import com.tools.Tools;

/**
 * 后台订单管理控制器
 *
 */
@Controller
public class AdminOrderController {
	
	@Autowired
	OrderService orderService; 
	/**
	 * 用户订单列表查询分页
	 */
	@ResponseBody
	@RequestMapping("/admin/order/selectAdminUserOrderPage")
	public String selectAdminUserOrderPage(@RequestParam Map<String ,Object> params) {
		ResponseInfo<List<Order>> info = new ResponseInfo<List<Order>>();
		try {
			// userId 或 status 或 orderCode 分页 pageNum pageSize
			long totalCount = orderService.selectListOrderPageCount(params);
			int pageSize =Tools.ObjectToInt(params.get("pageSize"));
			if(pageSize==0) {
				pageSize=20;
			}
			int pageNo=Tools.ObjectToInt(params.get("pageNo"));
			if(pageNo==0) {
				pageNo=1;
			}
			params.put("pageNum", (pageNo-1)*pageSize);
			params.put("endindex", pageNo*pageSize);
			List<Order> or = orderService.selectListByParamsPageing(params);
			info.setData(or);
			//总数据量
			info.setTotalCount(totalCount);
			//总页数
			info.setTotalPage(totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1);
			//当前页
			info.setPageNo(Tools.ObjectToInt(params.get("pageNo")));
			//一页数据量
			info.setPageSize(pageSize);
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
		
	}
	
}
