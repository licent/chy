package com.chy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chy.pojo.out.Item;
import com.chy.pojo.out.SearchHistory;
import com.chy.service.ItemService;
import com.chy.service.SearchHistoryService;
import com.tools.ResponseCode;
import com.tools.ResponseInfo;

/**
 * @搜索控制器
 */

@Controller
public class SearchController {
	@Autowired
	SearchHistoryService searchHistoryService;

	@Autowired
	ItemService itemService;

	/**
	 * 获取搜索历史记录
	 */
	@RequestMapping("/manage/search/getHistory")
	@ResponseBody
	public String getHistory(@RequestParam Map<String, Object> params) {
		ResponseInfo<List<SearchHistory>> info = new ResponseInfo<List<SearchHistory>>();
		try {
			// userId
			info.setData(searchHistoryService.selectByParams(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 获取热门商品
	 */
	@RequestMapping("/manage/search/getHotItem")
	@ResponseBody
	public String getHotItem(@RequestParam Map<String, Object> params) {
		ResponseInfo<List<Item>> info = new ResponseInfo<List<Item>>();
		try {
			// ishot=1
			info.setData(itemService.selectAllByParams(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 模糊查询商品
	 */
	@RequestMapping("/manage/search/getItem")
	@ResponseBody
	public String getItem(@RequestParam Map<String, Object> params) {
		ResponseInfo<List<Item>> info = new ResponseInfo<List<Item>>();
		try {
			// key
			info.setData(itemService.selectInfoLikeKey(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

}
