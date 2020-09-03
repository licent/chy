package com.chy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chy.pojo.in.UserEx;
import com.chy.pojo.out.OrderGross;
import com.chy.pojo.out.OrderGrossDalyrecords;
import com.chy.pojo.out.User;
import com.chy.pojo.out.UserAddress;
import com.chy.service.OrderGrossDalyrecordsService;
import com.chy.service.OrderGrossService;
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

	@Autowired
	OrderGrossService orderGrossService;

	@Autowired
	OrderGrossDalyrecordsService orderGrossDalyrecordsService;

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
			// openId
			// phone
			// parentId
			// fParentId
			// ztdParentId

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
			int r=userAddressService.createUserAddress(record);
			if(r>0) {
				Map<String,Object> p =new HashMap<String,Object>();
				p.put("tag", 1);
				p.put("userId", params.get("userId"));
				params.put("selected", new Byte("0"));
				r+=userAddressService.updateByPrimaryKeySelectiveWithOutId(p);
				info.setData(r);
				info.setCode(ResponseCode.SUCC);
			}else {
				info.setCode(ResponseCode.FAIL);
			}
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
	
	/**
	 * 用户粉丝查询
	 * */
	@RequestMapping("/manage/user/getUserFans")
	@ResponseBody
	public String getUserFans(@RequestParam Map<String, Object> params) {
		ResponseInfo<List<User>> info = new ResponseInfo<List<User>>();
		try {
			// userId
			//fansId
			//fansName
			info.setData(userService.selectUserFansListByUserId(params));
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
			UserAddress record = new UserAddress();
			record.setId((Integer) params.get("addressId"));
			record.setAddress((String) params.get("address"));
			record.setUserId((String) params.get("userId"));
			record.setPhone((String) params.get("phone"));
			record.setSelected(new Byte("1"));
			int r=userAddressService.updateByPrimaryKeySelective(record);
			if(r>0) {
				params.put("tag", 1);
				params.put("selected", new Byte("0"));
				r+=userAddressService.updateByPrimaryKeySelectiveWithOutId(params);
				info.setData(r);
				info.setCode(ResponseCode.SUCC);
			}else {
				info.setCode(ResponseCode.FAIL);
			}
			
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
			//selected
			params.put("tag",1);
			info.setData(userAddressService.selectListByParams(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 查询当前用户毛利详情列表
	 */
	@RequestMapping("/manage/gross/getUserGrossInfoList")
	@ResponseBody
	public String getUserGrossInfoList(@RequestParam Map<String, Object> params) {
		ResponseInfo<List<OrderGross>> info = new ResponseInfo<List<OrderGross>>();
		try {
			// userId
			// type 1用户分红 2店长分红 3厂商分红
			// begintime
			// endtime
			// 查询一天的结果 begintime和 endtime传同一个值 yyyy-mm-dd
			info.setData(orderGrossService.selectUserGrossByParams(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 查询每日毛利产生列表
	 */
	@RequestMapping("/manage/gross/getUserGrossDalyInfoList")
	@ResponseBody
	public String getUserGrossDalyInfoList(@RequestParam Map<String, Object> params) {
		ResponseInfo<List<OrderGrossDalyrecords>> info = new ResponseInfo<List<OrderGrossDalyrecords>>();
		try {
			// userId
			// type 1消费者 2自提点 3厂商
			// status 0未提现 1已提现
			// begintime
			// endtime
			// 查询一天的结果 begintime和 endtime传同一个值 yyyy-mm-dd
			info.setData(orderGrossDalyrecordsService.selectUserDalyGrossByParams(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 按照时间更改用户毛利信息
	 */
	@RequestMapping("/manage/gross/updateUserDalyGrossInfo")
	@ResponseBody
	public String updateUserDalyGrossInfo(@RequestParam Map<String, Object> params) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {
			// userId
			// status
			// begintime
			// endtime
			// 修改一天的结果 begintime和 endtime传同一个值 yyyy-mm-dd
			info.setData(orderGrossDalyrecordsService.updateStatusByUserIdAndTime(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
	
	
	/**
	 * 判断用户是否是厂商或店长
	 */
	@ResponseBody
	@RequestMapping("/manage/gross/selectUserRolesStatus")
	public String selectUserRolesStatus(@RequestParam Map<String, Object> params) {
		ResponseInfo<UserEx> info = new ResponseInfo<UserEx>();
		try {
			// userId
			info.setData(userService.selectUserRolesStatus(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

}
