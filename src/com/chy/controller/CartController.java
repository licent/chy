package com.chy.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tools.ResponseCode;
import com.tools.ResponseInfo;

/**
 * @购物车控制器
 */

@Controller
public class CartController {

	/**
	 * 添加购物车
	 */
	@RequestMapping("/manage/cart/addcart")
	@ResponseBody
	public String addcart(@RequestParam Map<String, Object> params) {
		ResponseInfo<Long> info = new ResponseInfo<Long>();
		try {
			// itemId商品编号  num商品数量
			
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 查询购物车
	 */
	@RequestMapping("/manage/cart/getCartInfo")
	@ResponseBody
	public String getCartInfo(@RequestParam Map<String, Object> params) {
		ResponseInfo<Long> info = new ResponseInfo<Long>();
		try {
			// TODO
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

}
