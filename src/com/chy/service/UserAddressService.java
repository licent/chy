package com.chy.service;

import java.util.List;
import java.util.Map;

import com.chy.pojo.out.UserAddress;

public interface UserAddressService {
	int deleteByPrimaryKey(Integer id);

	int createUserAddress(UserAddress record) throws Exception;

	int insertSelective(UserAddress record);

	UserAddress selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(UserAddress record);

	int updateUserAddressByParams(UserAddress record) throws Exception;

	int updateByPrimaryKey(UserAddress record);

	List<UserAddress> selectListByParams(Map<String, Object> params);

	int updateCurrentAddressByUserId(Map<String, Object> pararms);
	
	int updateByPrimaryKeySelectiveWithOutUserId(Map<String, Object> pararms);
}
