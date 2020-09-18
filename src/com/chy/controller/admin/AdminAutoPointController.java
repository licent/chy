package com.chy.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chy.pojo.out.AdminUsers;
import com.chy.pojo.out.AutoPoint;
import com.chy.pojo.out.Factory;
import com.chy.service.AutoPointService;
import com.tools.ResponseCode;
import com.tools.ResponseInfo;
import com.tools.Tools;

@Controller
public class AdminAutoPointController {
	@Autowired
	AutoPointService autoPointService;
	
	@RequestMapping("/admin/AutoPint/SelectAutoPintList")
	@ResponseBody
	public String SelectAutoPintList(@RequestParam Map<String,Object> params,HttpServletRequest request) {
		ResponseInfo<List<AutoPoint>> info = new ResponseInfo<List<AutoPoint>>();
		try {
			// 分页 pageNo pageSize
						AdminUsers adminUser = (AdminUsers) request.getSession().getAttribute("USERSESSION");
						if (!"admin".equals(adminUser.getUsername())) {
							info.setCode(ResponseCode.SUCC);
							info.setMsg("你不是超级管理员");
							return info.toJsonString();
						} else {
							long totalCount = autoPointService.selectAutoPointListCount(params);
							int pageSize = Tools.ObjectToInt(params.get("pageSize"));
							if (pageSize == 0) {
								pageSize = 20;
							}
							int pageNo = Tools.ObjectToInt(params.get("pageNo"));
							if (pageNo == 0) {
								pageNo = 1;
							}
						
							params.put("pageNum", (pageNo - 1) * pageSize);
							List<AutoPoint> factory = autoPointService.selectAutoPointList(params);
							info.setData(factory);
							// 总数据量
							info.setTotalCount(totalCount);
							// 总页数
							info.setTotalPage(totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1);
							// 当前页
							info.setPageNo(Tools.ObjectToInt(params.get("pageNo")));
							// 一页数据量
							info.setPageSize(pageSize);
							info.setCode(ResponseCode.SUCC);
							return info.toJsonString();
						}
			
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toString();
			
		}
	}
	/**
	 * 审核
	 */
	@ResponseBody
	@RequestMapping("/admin/AutoPoint/updateAutoPointStatus")
	public String updateFactoryStatus(@RequestParam Map<String, Object> params, HttpServletRequest request) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {
			AdminUsers adminUser = (AdminUsers) request.getSession().getAttribute("USERSESSION");
			if (!"admin".equals(adminUser.getUsername())) {
				info.setCode(ResponseCode.SUCC);
				info.setMsg("你不是超级管理员");
				return info.toJsonString();
			} else {
				AutoPoint autoPoint = new AutoPoint();
				autoPoint.setId(Tools.ObjectToInt(params.get("id")));
				autoPoint.setStatus(Tools.ObjectToByte(params.get("status")));
				int or = autoPointService.updateByPrimaryKeySelective(autoPoint);
				info.setData(or);
				info.setCode(ResponseCode.SUCC);
				return info.toJsonString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

}
