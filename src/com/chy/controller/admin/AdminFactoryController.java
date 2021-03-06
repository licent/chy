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
import com.chy.pojo.out.Factory;
import com.chy.service.FactoryService;
import com.chy.service.admin.AdminUsersService;
import com.tools.Md5;
import com.tools.ResponseCode;
import com.tools.ResponseInfo;
import com.tools.Tools;

@Controller
public class AdminFactoryController {
	@Autowired
	FactoryService factoryService;
	
	@Autowired
	AdminUsersService adminUsersService;

	/**
	 * 查询FactoryList
	 */
	@ResponseBody
	@RequestMapping("/admin/factory/SelectFactoryList")
	public String selectFactory(@RequestParam Map<String, Object> params, HttpServletRequest request) {
		ResponseInfo<List<Factory>> info = new ResponseInfo<List<Factory>>();
		try {
			// 分页 pageNo pageSize
			AdminUsers adminUser = (AdminUsers) request.getSession().getAttribute("USERSESSION");
			if (!"admin".equals(adminUser.getUsername())) {
				info.setCode(ResponseCode.SUCC);
				info.setMsg("你不是超级管理员");
				return info.toJsonString();
			} else {
				long totalCount = factoryService.selectFactoryListCount(params);
				int pageSize = Tools.ObjectToInt(params.get("pageSize"));
				if (pageSize == 0) {
					pageSize = 20;
				}
				int pageNo = Tools.ObjectToInt(params.get("pageNo"));
				if (pageNo == 0) {
					pageNo = 1;
				}
				params.put("pageNum", (pageNo - 1) * pageSize);
				List<Factory> factory = factoryService.selectFactoryList(params);
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
			return info.toJsonString();
		}

	}

	/**
	 * 修改状态
	 */
	@ResponseBody
	@RequestMapping("/admin/factory/updateFactoryStatus")
	public String updateFactoryStatus(@RequestParam Map<String, Object> params, HttpServletRequest request) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {
			AdminUsers adminUser = (AdminUsers) request.getSession().getAttribute("USERSESSION");
			if (!"admin".equals(adminUser.getUsername())) {
				info.setCode(ResponseCode.SUCC);
				info.setMsg("你不是超级管理员");
				return info.toJsonString();
			} else {
				Factory factory = new Factory();
				factory.setId(Tools.ObjectToInt(params.get("id")));
				factory.setfStatus(Tools.ObjectToByte(params.get("fStatus")));
				int or = factoryService.updateByPrimaryKeySelective(factory);
				
				if(or>0) {
					Factory f=factoryService.selectByPrimaryKey(Tools.ObjectToInt(params.get("id")));
					
					AdminUsers adminUsers =new AdminUsers();
					adminUsers.setBusCode(f.getfCode());
					adminUsers.setUsername(f.getfPhone());
					adminUsers.setPassword(Md5.GetMD5Code(f.getfPhone()));
					adminUsers.setPhone(Tools.strToLong(f.getfPhone()));
					adminUsers.setStatus(true);
					adminUsers.setRegisterTime(System.currentTimeMillis());
					
					
					adminUsersService.insertSelective(adminUsers);
				}
				
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
