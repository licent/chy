package com.chy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chy.mapper.UserAddressMapper;
import com.chy.pojo.out.UserAddress;
import com.chy.service.UserAddressService;

/**
 * @用户地址服务
 */
@Service
public class UserAddressServiceImpl implements UserAddressService {

	@Autowired
	UserAddressMapper userAddressMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return userAddressMapper.deleteByPrimaryKey(id);
	}

	@Transactional
	@Override
	public int createUserAddress(UserAddress record) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("selected", "0");
		params.put("userId", record.getUserId());

		if (params.get("userId") == null) {
			throw new Exception("新增用户地址参数错误");
		}

		userAddressMapper.updateByUserId(params);
		
		record.setSelected(new Byte("1"));
		if (userAddressMapper.insertSelective(record) > 0) {
			return 1;
		} else {
			throw new Exception("新增用户地址信息失败");
		}
	}

	@Override
	public UserAddress selectByPrimaryKey(Integer id) {
		return userAddressMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(UserAddress record) {
		return userAddressMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(UserAddress record) {
		return userAddressMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<UserAddress> selectListByParams(Map<String, Object> params) {
		return userAddressMapper.selectListByParams(params);
	}

	@Override
	public int insertSelective(UserAddress record) {
		return userAddressMapper.insertSelective(record);
	}

	@Transactional
	@Override
	public int updateUserAddress(UserAddress record) throws Exception {
		//待优化
		return 0;
	}

	@Override
	public int updateCurrentAddressByUserId(Map<String, Object> pararms) {
		return userAddressMapper.updateCurrentAddressByUserId(pararms);
	}

	@Override
	public int updateByPrimaryKeySelectiveWithOutUserId(Map<String, Object> pararms) {
		return userAddressMapper.updateByPrimaryKeySelectiveWithOutUserId(pararms);
	}

}
