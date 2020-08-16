package com.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.out.User;
import com.service.UserService;
import com.tools.ResponseCode;
import com.tools.ResponseInfo;
import com.tools.Tools;

/**
 * @author Taylor.O
 * @用户类数据操作控制器
 * 
 */

@Controller
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * 根据用户ID获取用户数据
	 */
	@RequestMapping("/getUserInfoById")
	@ResponseBody
	public String initHomePage(@RequestParam Map<String, String> params) {
		ResponseInfo<User> info = new ResponseInfo<User>();
		try {
			System.out.println("入参:" + params.toString());
			User user = userService.selectByPrimaryKey(Tools.strToInt(params.get("id")));
			if (user == null) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("查无对应ID用户数据记录");
			} else {
				info.setCode(ResponseCode.SUCC);
				info.setMsg("成功");
				info.setData(user);
			}
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
}
