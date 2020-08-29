package com.chy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chy.pojo.out.User;
import com.chy.pojo.out.UserAddress;
import com.chy.service.UserAddressService;
import com.chy.service.UserService;
import com.tools.ResponseCode;
import com.tools.ResponseInfo;

/**
 * @author Taylor.O
 * @用户类数据操作控制器
 * 
 */

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	UserAddressService userAddressService;

	/**
	 * 新增用户
	 */
	@RequestMapping("/manage/user/createUser")
	@ResponseBody
	public String createUser(@RequestParam Map<String, Object> params) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {
			// name
			// phone
			// openId
			// parentId
			// img

			User record = new User();
			record.setName((String) params.get("name"));
			record.setPhone((String) params.get("phone"));
			record.setOpenId((String) params.get("openId"));
			record.setParentId((Integer) params.get("parentId"));
			record.setImg((String) params.get("img"));

			info.setData(userService.insertSelective(record));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 根据用户ID查询用户信息
	 */
	@RequestMapping("/manage/user/queryUserById")
	@ResponseBody
	public String queryUserById(@RequestParam Map<String, Object> params) {
		ResponseInfo<User> info = new ResponseInfo<User>();
		try {
			// id
			info.setData(userService.selectByPrimaryKey((Integer) params.get("id")));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 根据参数查询用户
	 */
	@RequestMapping("/manage/user/queryUserList")
	@ResponseBody
	public String queryUserList(@RequestParam Map<String, Object> params) {
		ResponseInfo<List<User>> info = new ResponseInfo<List<User>>();
		try {
			// openId phone
			info.setData(userService.selectListByParams(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 修改用户信息
	 */
	@RequestMapping("/manage/user/updateUserInfo")
	@ResponseBody
	public String updateUserInfo(@RequestParam Map<String, Object> params) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {
			// openId
			// id

			// name
			// img
			// parentId
			// phone
			// money
			// idCardImg
			// idCardNo
			// zipai
			info.setData(userService.updateInfoByParams(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 用户地址信息新增
	 */
	@RequestMapping("/manage/user/createUserAddress")
	@ResponseBody
	public String createUserInfo(@RequestParam Map<String, Object> params) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {
			// address
			// userId
			// phone
			// ztdId
			UserAddress record = new UserAddress();
			record.setAddress((String) params.get("address"));
			record.setUserId((String) params.get("userId"));
			record.setPhone((String) params.get("phone"));
			record.setZtdId((Integer) params.get("ztdId"));
			info.setData(userAddressService.createUserAddress(record));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 用户地址信息修改
	 */
	@RequestMapping("/manage/user/updateUserAddress")
	@ResponseBody
	public String updateUserAddress(@RequestParam Map<String, Object> params) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {
			// id
			// address
			// phone
			// ztdId
			UserAddress record = new UserAddress();
			record.setId((Integer) params.get("addressId"));
			record.setAddress((String) params.get("address"));
			record.setUserId((String) params.get("userId"));
			record.setPhone((String) params.get("phone"));
			record.setZtdId((Integer) params.get("ztdId"));
			info.setData(userAddressService.updateUserAddress(record));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 用户地址信息列表查询
	 */
	@RequestMapping("/manage/user/quertUserAddressList")
	@ResponseBody
	public String quertUserAddressList(@RequestParam Map<String, Object> params) {
		ResponseInfo<List<UserAddress>> info = new ResponseInfo<List<UserAddress>>();
		try {
			// userId
			info.setData(userAddressService.selectListByParams(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

}
