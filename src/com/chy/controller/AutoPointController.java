package com.chy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chy.pojo.out.AutoPoint;
import com.chy.pojo.out.UserAddress;
import com.chy.service.AutoPointService;
import com.tools.ResponseCode;
import com.tools.ResponseInfo;

/**
 * @自提点控制器
 **/
@Controller
public class AutoPointController {

	@Autowired
	AutoPointService autoPointService;

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
			AutoPoint record = new AutoPoint();
			record.setAddress((String) params.get("address"));
			record.setUserId((Integer) params.get("userId"));
			record.setZtd((String) params.get("ztd"));
			record.setPhone((String) params.get("phone"));
			record.setParentUserId((Integer) params.get("parentUserId"));
			//record.setCode();
			info.setData(autoPointService.insertSelective(record));
			info.setCode(ResponseCode.SUCC);
			return info.toJsonString();
		} catch (Exception e) {
			e.printStackTrace();
			info.setCode(ResponseCode.EXCEPTION);
			return info.toJsonString();
		}
	}

}
