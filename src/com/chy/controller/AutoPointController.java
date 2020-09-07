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
import com.chy.pojo.out.User;
import com.chy.pojo.out.UserAddress;
import com.chy.service.AutoPointService;
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

	/**
	 * 新增自提点
	 */
	@RequestMapping("/manage/autopoint/createAutoPoint")
	@ResponseBody
	public String createAutoPoint(@RequestParam Map<String, Object> params) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {
			// address
			// userId
			// phone
			// parentUserId
			// localX
			// localY
			// idCardNo

			// codeHead
			AutoPoint record = new AutoPoint();
			record.setAddress((String) params.get("address"));
			record.setUserId(Tools.ObjectToInt( params.get("userId")));
			record.setParentUserId(Tools.ObjectToInt( params.get("parentUserId")));
			record.setPhone((String) params.get("phone"));
			record.setCode(IDMaker.createAutoPointCode((String) params.get("codeHead")));
			
			User ucount=userService.selectByPrimaryKey(record.getUserId());
			
			if(ucount==null) {
				info.setCode(ResponseCode.FAIL);
				info.setMsg("用户不存在");
				return info.toJsonString();
			}
			int r=autoPointService.insertSelective(record);
			if(r>1) {
				User userparams=new User();
				userparams.setId(record.getUserId());
				userparams.setIdCardNo(Tools.ObjectToString(params.get("idCardNo")));
				r+=userService.updateByPrimaryKey(userparams);
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
			UserAddress record=new  UserAddress();
			record.setUserId(Tools.ObjectToString(params.get("userId")));
			record.setSelected(new Byte("1"));
			record.setZtdId(Tools.ObjectToInt(params.get("ztdId")));
			int r=userAddressService.insertSelective(record);
			if(r>0) {
				Map<String,Object> p=new HashMap<String,Object>();
				p.put("userId", params.get("userId"));
				p.put("ztdId", params.get("ztdId"));
				p.put("selected",new Byte("0"));
				p.put("tag", 2);
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
	 * 查询一公里内的所有自提点
	 */
	@RequestMapping("/manage/autopoint/nearlyAutoPoint")
	@ResponseBody
	public String nearlyAutoPoint(@RequestParam Map<String, Object> params) {
		ResponseInfo<List<AutoPoint>> info = new ResponseInfo<List<AutoPoint>>();
		try {
			// localX 正负小数
			// localY 正负小数
			// ztdName 自提点名称  模糊查询
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
	 * 切换当前自提点
	 */
	@RequestMapping("/manage/autopoint/changeCurrentAutopoint")
	@ResponseBody
	public String changeCurrentAutopoint(@RequestParam Map<String, Object> params) {
		ResponseInfo<Integer> info = new ResponseInfo<Integer>();
		try {
			// userId
			// ztdId
			int r=userAddressService.updateCurrentAddressByUserId(params);
			if(r>0) {
				Map<String,Object> p=new HashMap<String,Object>();
				p.put("userId", params.get("userId"));
				p.put("ztdId", params.get("ztdId"));
				p.put("selected",new Byte("0"));
				p.put("tag", 2);
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
	 *  查询用户自提点和历史自提点
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
			info.setCode(ResponseCode.FAIL);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
}
