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

import com.chy.pojo.out.AdminUsers;
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
	
	/**
	 * 登录接口
	 */
	@RequestMapping("/admin/adminUserLogin")
	@ResponseBody
	public String adminUserLogin(@RequestParam Map<String, Object> params,HttpServletRequest request) {
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
			
			AdminUsers adminUsers=adminUsersService.selectByParamsForLogin(params);
			if(adminUsers==null) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("用户名或密码错误");
				return info.toJsonString();
			}
			
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
	public String getUserSession(@RequestParam Map<String, Object> params,HttpServletRequest request) {
		ResponseInfo<AdminUsers> info = new ResponseInfo<AdminUsers>();
		try {
			info.setData((AdminUsers)request.getSession().getAttribute("USERSESSION"));
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
	 * */
	@RequestMapping("/admin/adminUserLoginOut")
	@ResponseBody
	public String adminUserLoginOut(@RequestParam Map<String, Object> params,HttpServletRequest request) {
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
	 * */
	@RequestMapping("/admin/insertUser")
	@ResponseBody
	public String insertUser(@RequestParam Map<String, Object> params,HttpServletRequest request) {
		ResponseInfo<AdminUsers> info = new ResponseInfo<AdminUsers>();
		try {
			
			AdminUsers adminUsers =new AdminUsers();
			adminUsers.setEmail(Tools.ObjectToString(params.get("email")));
			adminUsers.setUsername(Tools.ObjectToString(params.get("username")));
			adminUsers.setPhone(Tools.ObjectToLong(params.get("phone")));
			adminUsers.setPassword(Md5.GetMD5Code(Tools.ObjectToString(params.get("password"))));
			
			Map<String,Object> p=new HashMap<String,Object>();
			p.put("phone",params.get("phone"));
			List<AdminUsers> resultList1=adminUsersService.selectListByParams(p);
			p=new HashMap<String,Object>();
			p.put("username",params.get("username"));
			List<AdminUsers> resultList2=adminUsersService.selectListByParams(p);
			if((resultList1!=null && resultList1.size()>0) || (resultList2!=null && resultList2.size()>0)) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("该手机号码或用户名已经注册过用户");
			}else {
				adminUsers.setRegisterTime((int)(new Date()).getTime()/1000);
				int r=adminUsersService.insertSelective(adminUsers);
				if(r>0) {
					info.setCode(ResponseCode.SUCC);
					info.setMsg("新建用户成功");
				}else {
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
	
	
}
