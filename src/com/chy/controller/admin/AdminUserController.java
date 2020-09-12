package com.chy.controller.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chy.pojo.in.UserEx;
import com.chy.pojo.out.AdminUsers;
import com.chy.pojo.out.Order;
import com.chy.service.OrderService;
import com.chy.service.admin.AdminUsersService;
import com.tools.Md5;
import com.tools.ResponseCode;
import com.tools.ResponseInfo;
import com.tools.Tools;

/**
 * 后台用户控制器
 */
@Controller
public class AdminUserController {

	@Autowired
	AdminUsersService adminUsersService;

	@Autowired
	OrderService orderService;

	/**
	 * 登录接口
	 */
	@RequestMapping("/admin/adminUserLogin")
	@ResponseBody
	public String adminUserLogin(@RequestParam Map<String, Object> params, HttpServletRequest request) {
		ResponseInfo<AdminUsers> info = new ResponseInfo<AdminUsers>();
		try {

			String msg = null;
			if (params.get("username") == null) {
				msg += "用户名不能为空";
			}

			if (params.get("password") == null) {
				msg += "密码不能为空";
			}

			if (msg != null) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg(msg);
				return info.toJsonString();
			}

			// username
			// password
			params.put("password", Md5.GetMD5Code(Tools.ObjectToString(params.get("password"))));

			AdminUsers adminUsers = adminUsersService.selectByParamsForLogin(params);
			if (adminUsers == null) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("用户名或密码错误");
				return info.toJsonString();
			}

			if (!adminUsers.getStatus()) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("用户被禁止使用");
				return info.toJsonString();
			}

			AdminUsers r = new AdminUsers();
			r.setId(adminUsers.getId());
			r.setLastLoginTime(System.currentTimeMillis());
			
			if(r.getLastLoginTime()==0) {
				r.setLastLoginTime(null);
			}
			
			adminUsersService.updateByPrimaryKeySelective(r);

			request.getSession().setAttribute("USERSESSION", adminUsers);
			info.setData(adminUsers);
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 获取用户session信息
	 */
	@RequestMapping("/admin/getUserSession")
	@ResponseBody
	public String getUserSession(@RequestParam Map<String, Object> params, HttpServletRequest request) {
		ResponseInfo<AdminUsers> info = new ResponseInfo<AdminUsers>();
		try {
			info.setData((AdminUsers) request.getSession().getAttribute("USERSESSION"));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 用户注销
	 */
	@RequestMapping("/admin/adminUserLoginOut")
	@ResponseBody
	public String adminUserLoginOut(@RequestParam Map<String, Object> params, HttpServletRequest request) {
		ResponseInfo<AdminUsers> info = new ResponseInfo<AdminUsers>();
		try {
			request.getSession().removeAttribute("USERSESSION");
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 新增用户
	 */
	@RequestMapping("/admin/insertUser")
	@ResponseBody
	public String insertUser(@RequestParam Map<String, Object> params, HttpServletRequest request) {
		ResponseInfo<AdminUsers> info = new ResponseInfo<AdminUsers>();
		try {

			AdminUsers adminUsers = new AdminUsers();
			adminUsers.setEmail(Tools.ObjectToString(params.get("email")));
			adminUsers.setUsername(Tools.ObjectToString(params.get("username")));
			adminUsers.setPhone(Tools.ObjectToLong(params.get("phone")));
			adminUsers.setPassword(Md5.GetMD5Code(Tools.ObjectToString(params.get("password"))));

			Map<String, Object> p = new HashMap<String, Object>();
			p.put("phone", params.get("phone"));
			List<AdminUsers> resultList1 = adminUsersService.selectListByParams(p);
			p = new HashMap<String, Object>();
			p.put("username", params.get("username"));
			List<AdminUsers> resultList2 = adminUsersService.selectListByParams(p);
			if ((resultList1 != null && resultList1.size() > 0) || (resultList2 != null && resultList2.size() > 0)) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("该手机号码或用户名已经注册过用户");
			} else {
				adminUsers.setRegisterTime(System.currentTimeMillis());
				int r = adminUsersService.insertSelective(adminUsers);
				if (r > 0) {
					info.setCode(ResponseCode.SUCC);
					info.setMsg("新建用户成功");
				} else {
					info.setCode(ResponseCode.FAIL);
					info.setMsg("新建用户失败");
				}
			}
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 用户列表查询
	 */
	@RequestMapping("/admin/getAdminUserList")
	@ResponseBody
	public String getAdminUserList(@RequestParam Map<String, Object> params) {
		ResponseInfo<List<AdminUsers>> info = new ResponseInfo<List<AdminUsers>>();
		try {
			List<AdminUsers> reuslt = adminUsersService.selectListByParams(params);
			info.setCode(ResponseCode.SUCC);
			info.setData(reuslt);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 用户状态修改
	 */
	@ResponseBody
	@RequestMapping("/admin/updateAdminUsersStaus")
	public String updateAdminUsersStaus(@RequestParam Map<String, Object> params) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {
			// id
			// status
			AdminUsers record = new AdminUsers();
			record.setId(Tools.ObjectToInt(params.get("id")));

			if (1 == Tools.ObjectToInt(params.get("status"))) {
				record.setStatus(true);
			} else {
				record.setStatus(false);
			}

			info.setData(adminUsersService.updateByPrimaryKeySelective(record));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
	/**
	 * 用户订单列表查询分页
	 *//*
		 * @ResponseBody
		 * 
		 * @RequestMapping("/admin/selectAdminUserOrderPage") public String
		 * selectAdminUserOrderPage(@RequestParam Map<String ,Object> params) {
		 * ResponseInfo<List<Order>> info = new ResponseInfo<List<Order>>(); try { //
		 * userId 或 status 或 orderId 分页 pageNum pageSize int totalPageSize; List<Order>
		 * or = orderService.selectListByParamsPageing(params); int totalCount =
		 * orderService.selectListOrderPageCount(params); int pageNum =
		 * Tools.ObjectToInt(params.get("pageNum")); int pageSize
		 * =Tools.ObjectToInt(params.get("pageSize")); if(pageSize==0) { pageSize=20; }
		 * if(totalCount % pageSize==0) { totalPageSize = totalCount / pageSize; }else {
		 * totalPageSize = totalCount / pageSize+1; } info.setData(or); //总数据量
		 * info.setTotalCount(totalCount); //总页数 info.setTotalPage(totalPageSize); //当前页
		 * info.setPageNo(pageNum); info.setCode(ResponseCode.SUCC); return
		 * info.toJsonString(); } catch (Exception e) { e.printStackTrace();
		 * info.setCode(ResponseCode.EXCEPTION); return info.toJsonString(); } }
		 */
}
