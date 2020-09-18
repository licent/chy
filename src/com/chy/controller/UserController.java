package com.chy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.chy.pojo.in.UserEx;
import com.chy.pojo.out.OrderGross;
import com.chy.pojo.out.OrderGrossDalyrecords;
import com.chy.pojo.out.User;
import com.chy.pojo.out.UserAddress;
import com.chy.service.OrderGrossDalyrecordsService;
import com.chy.service.OrderGrossService;
import com.chy.service.UserAddressService;
import com.chy.service.UserService;
import com.tools.Md5;
import com.tools.MyHttpSender;
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

			if (params.get("phone") == null) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("参数缺失");
				return info.toJsonString();
			}

			Map<String, Object> p = new HashMap<String, Object>();
			p.put("openId", params.get("openId"));
			List<User> l = userService.selectListByParams(p);
			if (l != null && l.size() != 0) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("该openId已经注册用户");
				return info.toJsonString();
			}

			User record = new User();
			record.setName((String) params.get("name"));
			record.setPhone((String) params.get("phone"));
			record.setOpenId((String) params.get("openId"));
			record.setParentId(Tools.ObjectToInt(params.get("parentId")));
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
			if (params.get("id") == null) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("参数缺失id");
				return info.toJsonString();
			}
			info.setData(userService.selectByPrimaryKey(Tools.ObjectToInt(params.get("id"))));
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
			record.setName((String) params.get("name"));
			int r = userAddressService.createUserAddress(record);
			info.setCode(ResponseCode.SUCC);
			info.setData(r);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 用户粉丝查询
	 */
	@RequestMapping("/manage/user/getUserFans")
	@ResponseBody
	public String getUserFans(@RequestParam Map<String, Object> params) {
		ResponseInfo<List<User>> info = new ResponseInfo<List<User>>();
		try {
			// userId
			// fansId
			// fansName
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
			record.setId(Tools.ObjectToInt(params.get("addressId")));
			if (params.get("address") != null)
				record.setAddress(Tools.ObjectToString(params.get("address")));
			if (params.get("userId") != null)
				record.setUserId(Tools.ObjectToString(params.get("userId")));
			if (params.get("phone") != null)
				record.setPhone(Tools.ObjectToString(params.get("phone")));
			if (params.get("name") != null)
				record.setName(Tools.ObjectToString(params.get("name")));

			record.setSelected(new Byte("1"));

			int r = userAddressService.updateByPrimaryKeySelective(record);
			if (r > 0) {
				params.put("tag", 1);
				params.put("selected", new Byte("0"));
				r += userAddressService.updateByPrimaryKeySelectiveWithOutUserId(params);
				info.setData(r);
				info.setCode(ResponseCode.SUCC);
			} else {
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
			// selected
			params.put("tag", 1);
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
	 * @查询店长佣金列表
	 */
	@RequestMapping("/manage/gross/getAutoPointBrokerageInfoList")
	@ResponseBody
	public String getAutoPointBrokerageInfoList(@RequestParam Map<String, Object> params) {
		ResponseInfo<List<OrderGross>> info = new ResponseInfo<List<OrderGross>>();
		try {
			// userId
			// begintime
			// endtime
			if (params.get("userId") == null) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("参数缺失userId");
				return info.toJsonString();
			}

			// 查询一天的结果 begintime和 endtime传同一个值 yyyy-mm-dd
			info.setData(orderGrossService.selectAutoPointBrokeAgeByParams(params));
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

	/**
	 * 微信openid获取
	 * 
	 */
	@ResponseBody
	@RequestMapping("/manage/user/getOpenId")
	public String getOpenId(@RequestParam Map<String, Object> params) {
		ResponseInfo<String> info = new ResponseInfo<String>();
		try {
			// js_code

			String app_id = "wxce31758573e47ce3";
			String app_key = "50745ba9b3b68f32a005a14ecf438ec5";
			String paramsStr = "";
			paramsStr += "appid=" + app_id + "&secret=" + app_key + "&grant_type=authorization_code&js_code="
					+ Tools.ObjectToString(params.get("js_code"));

			String result = MyHttpSender.commonGet(MyHttpSender.UPLOAD_URL, paramsStr);
			JSONObject json = JSONObject.parseObject(result);
			if (json.getString("errcode") == null || "".equals(json.getString("errcode"))) {
				info.setData(json.getString("openid"));
				info.setCode(ResponseCode.SUCC);
				info.setMsg(result);
			} else {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("微信调用失败");
			}
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * @获取手机短信验证码
	 */
	@ResponseBody
	@RequestMapping("/manage/user/sendMsgCode")
	public String sendMsgCode(@RequestParam Map<String, Object> params, HttpServletRequest request) {
		ResponseInfo<String> info = new ResponseInfo<String>();
		try {
			// phone

			Map<String, String> paramsStr = new HashMap<String, String>();
			paramsStr.put("mobile", Tools.ObjectToString(params.get("phone")));
			paramsStr.put("secretkey", "abe7dfc9db2ff3046dbf4dd6b8fe91bd");
			paramsStr.put("templateid", "7");
			int code = (int) ((Math.random() * 9 + 1) * 100000);
			paramsStr.put("code", code + "");

			request.getSession().setAttribute("MSGCODE", Tools.ObjectToString(params.get("phone")) + ":" + code);
			request.getSession().setAttribute("MSGCODE_TIME", System.currentTimeMillis());

			String result = MyHttpSender.commonPost(MyHttpSender.MSG_CODE_SEND_URL, paramsStr);
			JSONObject json = JSONObject.parseObject(result);
			System.out.println(json.toJSONString());
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * @校验短信验证码
	 */
	@ResponseBody
	@RequestMapping("/manage/user/checkMsgCode")
	public String checkMsgCode(@RequestParam Map<String, Object> params, HttpServletRequest request) {
		ResponseInfo<String> info = new ResponseInfo<String>();
		try {
			// code
			// phone
			String paramsStr = Tools.ObjectToString(params.get("phone")) + ":"
					+ Tools.ObjectToString(params.get("code"));

			long tim = Tools.ObjectToLong(request.getSession().getAttribute("MSGCODE_TIME"));
			String pcStr = Tools.ObjectToString(request.getSession().getAttribute("MSGCODE"));
			if (pcStr == null || "".equals(pcStr) || tim == 0) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("尚未发送验证码");
			} else if (!pcStr.equals(paramsStr)) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("验证码错误");
			} else if (System.currentTimeMillis() - tim > 60000) {

				request.getSession().removeAttribute("MSGCODE_TIME");
				request.getSession().removeAttribute("MSGCODE");

				info.setCode(ResponseCode.FAIL);
				info.setMsg("验证码失效,请重新发送");
			} else {
				info.setCode(ResponseCode.SUCC);
				info.setMsg("校验成功");
				request.getSession().removeAttribute("MSGCODE_TIME");
				request.getSession().removeAttribute("MSGCODE");
			}
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 修改用户交易密码
	 */
	@ResponseBody
	@RequestMapping("/manage/user/changeOrInsertPayPwd")
	public String changeOrInsertPayPwd(@RequestParam Map<String, Object> params, HttpServletRequest request) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {
			// userId
			// payPwd
			if (params.get("userId") == null || params.get("payPwd") == null) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("参数缺失 userId payPwd");
				return info.toJsonString();
			}

			User record = new User();
			record.setId(Tools.ObjectToInt(params.get("userId")));
			record.setBsnsPwd(Md5.GetMD5Code(Tools.ObjectToString(params.get("payPwd"))));
			info.setData(userService.updateByPrimaryKeySelective(record));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 查询用户钱包 未提现金额 已体现金额 总金额
	 */
	@ResponseBody
	@RequestMapping("/manage/user/queryUserGrossByUserId")
	public String queryUserGrossByUserId(@RequestParam Map<String, Object> params, HttpServletRequest request) {
		ResponseInfo<Map<String, Object>> info = new ResponseInfo<Map<String, Object>>();
		try {
			// userId
			if (params.get("userId") == null) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("参数缺失 userId");
				return info.toJsonString();
			}
			info.setData(orderGrossDalyrecordsService.queryUserGrossByUserId(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
	/**
	 * 删除用户自提点信息
	 */
	@ResponseBody
	@RequestMapping("/manage/user/deleteByUserIdAndZtdId")
	public String deleteByUserIdAndZtdId(@RequestParam Map<String, Object> params) {
		ResponseInfo<Map<String, Object>> info = new ResponseInfo<Map<String, Object>>();
		try {
			// id ztdId
			if (params.get("id") == null) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("参数缺失 userId");
				return info.toJsonString();
			}
			int count = userAddressService.deleteByUserIdAndZtdId(params);
			if(count>0) {
				info.setCode(ResponseCode.SUCC);
				return info.toJsonString();
			}
			info.setCode(ResponseCode.FAIL);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
}
