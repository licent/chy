package com.chy.controller;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.chy.pojo.in.ItemSalesEx;
import com.chy.pojo.out.AdminUsers;
import com.chy.pojo.out.Item;
import com.chy.pojo.out.ItemCats;
import com.chy.pojo.out.ItemWithBLOBs;
import com.chy.pojo.out.User;
import com.chy.service.ItemCatsService;
import com.chy.service.ItemService;
import com.chy.service.UserService;
import com.tools.IDMaker;
import com.tools.ResponseCode;
import com.tools.ResponseInfo;
import com.tools.Tools;
import com.tools.Uploader;

/**
 * @author Taylor.O
 * @产品控制器
 */
@Controller
public class ItemController {

	@Autowired
	ItemService itemService;

	@Autowired
	UserService userService;
	
	@Autowired
	ItemCatsService itemCatsService;
	
	/**
	 * 新增商品列表
	 */
	@RequestMapping("/admin/item/createItem")
	@ResponseBody
	public String createItem(@RequestParam Map<String, Object> params) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {
			ItemWithBLOBs i = JSONObject.parseObject(Tools.ObjectToJsonString(params), ItemWithBLOBs.class);
			i.setCode(IDMaker.createItemCode());
			// itemTagId
			info.setData(itemService.insertSelective(i));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 获取商品列表
	 */
	@RequestMapping("/manage/item/getItemListByParams")
	@ResponseBody
	public String getItemListByParams(@RequestParam Map<String, Object> params) {
		ResponseInfo<List<Item>> info = new ResponseInfo<List<Item>>();
		try {
			// itemTagId
			// userId
			// pageNo
			// pageSize
			
			int i=Tools.ObjectToInt(params.get("pageNo"));
			int pageNo =Tools.ObjectToInt(params.get("pageNo"));
			
			params.put("startindex", (i-1)*pageNo);
			
			info.setData(itemService.getItemListByParams(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 产品详情
	 */
	@RequestMapping("/manage/item/getById")
	@ResponseBody
	public String getById(@RequestParam Map<String, Object> params) {
		ResponseInfo<Item> info = new ResponseInfo<Item>();
		try {
			// itemId
			info.setData(itemService.selectByPrimaryKey(Tools.ObjectToInt(params.get("itemId"))));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 查询产品的总购买人数 和 总销量
	 */
	@RequestMapping("/manage/item/getItemBuysAndSales")
	@ResponseBody
	public String getItemBuysAndSales(@RequestParam Map<String, Object> params) {
		ResponseInfo<ItemSalesEx> info = new ResponseInfo<ItemSalesEx>();
		try {
			// itemId
			info.setData(itemService.selectItemBuysAndSales(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 查询某个产品最近的十个人下单人的购买记录
	 */
	@RequestMapping("/manage/item/getNearlyUserInfo")
	@ResponseBody
	public String getNearlyUserInfo(@RequestParam Map<String, Object> params) {
		ResponseInfo<List<User>> info = new ResponseInfo<List<User>>();
		try {
			// itemId
			info.setData(userService.selectNearlyCustomersListByItemId(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
	
	
	/**
	 * 商品图片上传
	 * */
	@RequestMapping("/admin/uploadPic")
	@ResponseBody
	public String uploadPic(@RequestParam("file") MultipartFile file) {
		ResponseInfo<String> info = new ResponseInfo<String>();
		try {
			info.setData(Uploader.uploadFile(file.getInputStream()));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
	
	
	/**
	 * 商品信息保存
	 * */
	@RequestMapping("/admin/addItemInfo")
	@ResponseBody
	public String addItemInfo(@RequestParam Map<String,Object> params,HttpServletRequest request) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {
			
			ItemWithBLOBs record =new ItemWithBLOBs();
			record.setName(Tools.ObjectToString(params.get("name")));
			record.setPrice(Tools.ObjectToFloat(params.get("price")));
			record.setPicUrl(Tools.ObjectToString(params.get("picUrl")));
			record.setCid(Tools.ObjectToInt(params.get("cid")));
			record.setCode(IDMaker.createItemCode());
			record.setDetails(Tools.ObjectToString(params.get("details")));
			record.setItemTagId(Tools.ObjectToInt(params.get("itemTagId")));
			record.setPurchasePrice(Tools.ObjectToFloat(params.get("purchasePrice")));
			record.setGetTime(Tools.ObjectToString(params.get("getTime")));
			record.setYushuoTime(Tools.ObjectToString(params.get("yushouTime")));
			record.setIshot(Tools.ObjectToInt(params.get("ishot")));
			record.setBusinessCode(Tools.ObjectToString(params.get("businessCode")));
			record.setCreated(((AdminUsers)request.getSession().getAttribute("USERSESSION")).getUsername());
			record.setState(new Byte("0"));
			record.setState(new Byte("onsale"));
			SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
			record.setModified(dateFormat.format(new Date()));
			info.setData(itemService.insertSelective(record));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
	
	/**
	 * 商品信息列表获取
	 * */
	@RequestMapping("/admin/getItemListInfo")
	@ResponseBody
	public String getItemListInfo(@RequestParam Map<String,Object> params) {
		ResponseInfo<List<Item>> info = new ResponseInfo<List<Item>>();
		try {
			
			int pageNo=Tools.ObjectToInt(params.get("pageNo"));
			if(pageNo==0) {
				pageNo=1;
			}
			
			int pageSize=Tools.ObjectToInt(params.get("pageSize"));
			if(pageSize==0) {
				pageNo=20;
			}
			
			params.put("startindex", (pageNo-1)*pageSize);
			params.put("endindex", pageNo*pageSize);
			long totalCount=itemService.selectAllByPageCount(params);
			info.setData(itemService.selectAllByPage(params));
			info.setPageNo(Tools.ObjectToInt(params.get("pageNo")));
			info.setPageSize(Tools.ObjectToInt(params.get("pageSize")));
			info.setTotalCount(totalCount);
			info.setTotalPage(totalCount%pageNo==0?totalCount/pageNo:totalCount/pageNo+1);
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
	
	
	/**
	 * 查询所有标签
	 * */
	@RequestMapping("/admin/getCatAllInfo")
	@ResponseBody
	public String getCatAllInfo(@RequestParam Map<String,Object> params) {
		ResponseInfo<List<ItemCats>> info = new ResponseInfo<List<ItemCats>>();
		try {
			//isParent
			//parentCid
			info.setData(itemCatsService.selectAllByParams(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
	
	
	/**
	 * 产品详情
	 */
	@RequestMapping("/admin/getItemList")
	@ResponseBody
	public String getItemList(@RequestParam Map<String, Object> params) {
		ResponseInfo<List<Item>> info = new ResponseInfo<List<Item>>();
		try {
			// state=9是查询全部审核状态 
			if(9==Tools.ObjectToInt(params.get("state"))) {
				params.put("state", null);
			}
			info.setData(itemService.selectAllForAdmin(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
	
}
