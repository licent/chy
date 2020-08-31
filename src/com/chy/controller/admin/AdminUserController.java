package com.chy.controller.admin;

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
	
}
