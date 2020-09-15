package com.chy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chy.pojo.out.Cart;
import com.chy.pojo.out.Item;
import com.chy.service.CartService;
import com.chy.service.ItemService;
import com.tools.ResponseCode;
import com.tools.ResponseInfo;
import com.tools.Tools;

/**
 * @购物车控制器
 */

@Controller
public class CartController {

	@Autowired
	CartService cartService;

	@Autowired
	ItemService itemService;
	/**
	 * 添加购物车
	 */
	@RequestMapping("/manage/cart/addcart")
	@ResponseBody
	public String addcart(@RequestParam Map<String, Object> params) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {
			// itemId商品编号 num商品数量 userId用户ID
			Cart cart = new Cart();
			cart.setItemId(Tools.ObjectToInt(params.get("itemId")));
			cart.setUserId((String) params.get("userId"));
			cart.setNum(Tools.ObjectToInt(params.get("num")));

			int i = cartService.insertSelective(cart);
			info.setData(i);
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
		ResponseInfo<List<Item>> info = new ResponseInfo<List<Item>>();
		try {
			// 用户userId 商品itemId
			info.setData(itemService.selectCartItemByParams(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 修改购物车商品数量
	 */
	@RequestMapping("/manage/cart/updateCartItemByParams")
	@ResponseBody
	public String updateCartItemByParams(@RequestParam Map<String, Object> params) {
		ResponseInfo<Long> info = new ResponseInfo<Long>();
		try {
			// 用户userId
			// 商品id
			// 商品数量num
			info.setData(cartService.updateNumByParams(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 删除购物车商品
	 */
	@RequestMapping("/manage/cart/deleteCartItemByParams")
	@ResponseBody
	public String deleteCartItemByParams(@RequestParam Map<String, Object> params) {
		ResponseInfo<Long> info = new ResponseInfo<Long>();
		try {
			// 用户userId
			// 商品itemId
			info.setData(cartService.deleteByParams(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
}
