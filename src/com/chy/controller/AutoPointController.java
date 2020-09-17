package com.chy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chy.pojo.out.AutoPoint;
import com.chy.pojo.out.AutoPointask;
import com.chy.pojo.out.Order;
import com.chy.pojo.out.User;
import com.chy.pojo.out.UserAddress;
import com.chy.service.AutoPointService;
import com.chy.service.AutoPointTaskService;
import com.chy.service.OrderService;
import com.chy.service.UserAddressService;
import com.chy.service.UserService;
import com.tools.IDMaker;
import com.tools.ResponseCode;
import com.tools.ResponseInfo;
import com.tools.Tools;

/**
 * @自提点控制器
 **/
@Controller
public class AutoPointController {

	@Autowired
	AutoPointService autoPointService;

	@Autowired
	UserAddressService userAddressService;

	@Autowired
	UserService userService;

	@Autowired
	AutoPointTaskService autoPointTaskService;
	@Autowired
	OrderService orderService;
	/**
	 * 新增自提点
	 */
	@RequestMapping("/manage/autopoint/createAutoPoint")
	@ResponseBody
	public String createAutoPoint(@RequestParam Map<String, Object> params) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {
			// userId
			// parentUserId
			// localX
			// localY
			// idCardNo

			// codeHead
			AutoPoint record = new AutoPoint();
			record.setZtd(Tools.ObjectToString(params.get("ztd")));
			record.setAddress(Tools.ObjectToString(params.get("address")));
			record.setUserId(Tools.ObjectToInt(params.get("userId")));
			record.setParentUserId(Tools.ObjectToInt(params.get("parentUserId")));
			record.setCode(IDMaker.createAutoPointCode(Tools.ObjectToJsonString(params.get("codeHead"))));
			record.setLocalX(Tools.ObjectToString(params.get("localX")));
			record.setLocalY(Tools.ObjectToString(params.get("localY")));
			record.setIsOpen(true);

			User ucount = userService.selectByPrimaryKey(record.getUserId());

			if (ucount == null) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("用户不存在");
				return info.toJsonString();
			}
			int r = autoPointService.insertSelective(record);
			if (r > 1) {
				User userparams = new User();
				userparams.setId(record.getUserId());
				userparams.setIdCardNo(Tools.ObjectToString(params.get("idCardNo")));
				r += userService.updateByPrimaryKey(userparams);
			}

			info.setData(r);
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 选择自提点
	 */
	@RequestMapping("/manage/autopoint/choiceAutoPoint")
	@ResponseBody
	public String choiceAutoPoint(@RequestParam Map<String, Object> params) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {
			// userId
			// ztdId
			UserAddress record = new UserAddress();
			record.setUserId(Tools.ObjectToString(params.get("userId")));
			// record.setId(Tools.ObjectToInt(params.get("addressId")));
			record.setSelected(new Byte("1"));
			record.setZtdId(Tools.ObjectToInt(params.get("ztdId")));

			Map<String, Object> _p = new HashMap<String, Object>();
			_p.put("userId", record.getUserId());
			_p.put("ztdId", record.getZtdId());

			List<UserAddress> list = userAddressService.selectListByParams(_p);

			int r = 0;

			if (list != null && list.size() > 0) {
				r = userAddressService.updateUserAddressByParams(record);
			} else {
				r = userAddressService.insertSelective(record);
			}

			if (r > 0) {
				Map<String, Object> p = new HashMap<String, Object>();
				//p.put("addressId", params.get("addressId"));
				p.put("userId", params.get("userId"));
				p.put("ztdId", params.get("ztdId"));
				p.put("selected", new Byte("0"));
				p.put("tag", 2);
				r += userAddressService.updateByPrimaryKeySelectiveWithOutUserId(p);
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
	 * 查询一公里内的所有自提点
	 */
	@RequestMapping("/manage/autopoint/nearlyAutoPoint")
	@ResponseBody
	public String nearlyAutoPoint(@RequestParam Map<String, Object> params) {
		ResponseInfo<List<AutoPoint>> info = new ResponseInfo<List<AutoPoint>>();
		try {
			// localX 正负小数
			// localY 正负小数
			// ztdName 自提点名称 模糊查询
			info.setData(autoPointService.selectNearlyInfo(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 查询用户自提点和历史自提点
	 */
	@RequestMapping("/manage/autopoint/queryUserAutoPoint")
	@ResponseBody
	public String queryUserAutoPoint(@RequestParam Map<String, Object> params) {
		ResponseInfo<List<AutoPoint>> info = new ResponseInfo<List<AutoPoint>>();
		try {
			// userId
			// selected
			info.setData(autoPointService.selectListByParams(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 店长停业信息新增
	 */
	@RequestMapping("/manage/autopoint/addTask")
	@ResponseBody
	public String addTask(@RequestParam Map<String, Object> params) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {

			if (params.get("autoPointId") == null || params.get("userId") == null || params.get("startTime") == null
					|| params.get("endTime") == null) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("参数缺失autoPointId,userId,startTime,endTime");
				return info.toJsonString();
			}

			params.put("justOne", true);
			params.put("isEnd", 0);

			AutoPointask autoPointask = autoPointTaskService.selectByParams(params);
			if (autoPointask != null) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("新增失败，数据已经存在");
				return info.toJsonString();
			}

			AutoPointask record = new AutoPointask();
			record.setAutoPointId(Tools.ObjectToInt(params.get("autoPointId")));
			record.setUserId(Tools.ObjectToInt(params.get("userId")));
			record.setStartTime(Tools.ObjectToString(params.get("startTime")));
			record.setEndTime(Tools.ObjectToString(params.get("endTime")));
			record.setIsStart(true);
			record.setIsEnd(false);

			AutoPoint r = new AutoPoint();
			r.setIsOpen(false);
			r.setId(Tools.ObjectToInt(params.get("autoPointId")));
			autoPointService.updateByPrimaryKeySelective(r);

			info.setData(autoPointTaskService.insertSelective(record));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 店长停业信息删除
	 */
	@RequestMapping("/manage/autopoint/deleteTask")
	@ResponseBody
	public String deleteTask(@RequestParam Map<String, Object> params) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {
			// id
			if (params.get("id") != null) {
				info.setData(autoPointTaskService.deleteByPrimaryKey(Tools.ObjectToInt(params.get("params"))));
			} else if (params.get("userId") != null && params.get("autoPointId") != null) {
				info.setData(autoPointTaskService.deleteByParams(params));
			} else {
				info.setCode(ResponseCode.SUCC);
				info.setMsg("参数缺失id不能为空或者userId和autoPointId不能为空");
				return info.toJsonString();
			}

			AutoPoint record = new AutoPoint();
			record.setId(
					autoPointTaskService.selectByPrimaryKey(Tools.ObjectToInt(params.get("params"))).getAutoPointId());
			record.setIsOpen(true);
			autoPointService.updateByPrimaryKeySelective(record);
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 店长停业信息更新（用于提前停止歇业状态）
	 */
	@RequestMapping("/manage/autopoint/updateTask")
	@ResponseBody
	public String updateTask(@RequestParam Map<String, Object> params) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {
			// 
			if (params.get("id") == null) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("参数缺失id");
				return info.toJsonString();
			}
			AutoPoint record = new AutoPoint();
			record.setId(Tools.ObjectToInt(params.get("id")));
			record.setIsOpen(true);
			
			Map<String,Object> m=new HashMap<String,Object>();
			m.put("autoPointId", params.get("id"));
			m.put("isEnd",1);
			
			if (autoPointTaskService.updateByParams(m) > 0) {
				info.setData(autoPointService.updateByPrimaryKeySelective(record));
				info.setCode(ResponseCode.SUCC);
			} else {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("未查询到停业信息");
			}
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 店长查看自己自提点信息
	 */
	@RequestMapping("/manage/autopoint/queryAutoPointByUserId")
	@ResponseBody
	public String queryAutoPointByUserId(@RequestParam Map<String, Object> params) {
		ResponseInfo<AutoPoint> info = new ResponseInfo<AutoPoint>();
		try {
			// userId
			if (params.get("userId") == null) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("参数缺失userId");
				return info.toJsonString();
			}
			info.setData(autoPointService.selectAutoPointByParams(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
	/**
	 * 店长订单管理
	 */
	@ResponseBody
	@RequestMapping("/manage/autopoint/queryAutopointOrder")
	public String queryAutopintOrder(@RequestParam Map<String, Object> params) {
		ResponseInfo<List<Order>> info = new ResponseInfo<List<Order>>();
		try {
			//ztdId status
			info.setData(orderService.selectListByAutoPint(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
	/**
	 * 店长注销
	 */
	@ResponseBody
	@RequestMapping("/manage/autopoint/autopointOut")
	public String autopintOut(@RequestParam Map<String, Object> params) {
		ResponseInfo<String> info = new ResponseInfo<String>();
		try {
			//id
			int count = autoPointService.deleteByPrimaryKey(Tools.ObjectToInt(params.get("id")));
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
	/**
	 * 店长修改订单状态
	 */
	@ResponseBody
	@RequestMapping("/manage/autopoint/autopointUpdateOrder")
	public String autopintUpdateOrder(@RequestParam Map<String, Object> params) {
		ResponseInfo<String> info =  new ResponseInfo<String>();
		try {
			//id status
			Order record = new Order();
			record.setId(Tools.ObjectToInt(params.get("id")));
			record.setStatus(Tools.ObjectToByte(params.get("status")));
			int count = orderService.updateByPrimaryKeySelective(record);
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
