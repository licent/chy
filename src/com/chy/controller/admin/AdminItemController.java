package com.chy.controller.admin;

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

import com.chy.pojo.out.AdminUsers;
import com.chy.pojo.out.Item;
import com.chy.pojo.out.ItemCats;
import com.chy.pojo.out.ItemWithBLOBs;
import com.chy.service.ItemCatsService;
import com.chy.service.ItemService;
import com.tools.IDMaker;
import com.tools.ResponseCode;
import com.tools.ResponseInfo;
import com.tools.Tools;
import com.tools.Uploader;

@Controller
public class AdminItemController {
	
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	ItemCatsService itemCatsService;
	 
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
	 * 商品图片上传
	 * */
	@RequestMapping("/manage/uploadPicForApp")
	@ResponseBody
	public String uploadPicForApp(@RequestParam("file") MultipartFile file) {
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
