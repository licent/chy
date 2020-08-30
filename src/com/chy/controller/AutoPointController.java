package com.chy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chy.pojo.out.AutoPoint;
import com.chy.service.AutoPointService;
import com.chy.service.UserAddressService;
import com.tools.IDMaker;
import com.tools.ResponseCode;
import com.tools.ResponseInfo;

/**
 * @自提点控制器
 **/
@Controller
public class AutoPointController {

	@Autowired
	AutoPointService autoPointService;

	@Autowired
	UserAddressService userAddressService;

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
			// ztd
			// phone
			// parentUserId
			// localX
			// localY

			// codeHead
			AutoPoint record = new AutoPoint();
			record.setAddress((String) params.get("address"));
			record.setUserId((Integer) params.get("userId"));
			record.setZtd((String) params.get("ztd"));
			record.setParentUserId((Integer) params.get("parentUserId"));
			record.setPhone((String) params.get("phone"));
			record.setCode(IDMaker.createAutoPointCode((String) params.get("codeHead")));
			info.setData(autoPointService.insertSelective(record));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

	/**
	 * 查询最近的三个自提点
	 */
	@RequestMapping("/manage/autopoint/nearlyAutoPoint")
	@ResponseBody
	public String nearlyAutoPoint(@RequestParam Map<String, Object> params) {
		ResponseInfo<List<AutoPoint>> info = new ResponseInfo<List<AutoPoint>>();
		try {
			// localX 正负小数
			// localY 正负小数
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
			info.setData(userAddressService.updateCurrentAddressByUserId(params));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}
}
