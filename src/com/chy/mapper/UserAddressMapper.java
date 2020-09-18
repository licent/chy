package com.chy.mapper;

import java.util.List;
import java.util.Map;

import com.chy.pojo.out.UserAddress;

public interface UserAddressMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(UserAddress record);

	int insertSelective(UserAddress record);

	UserAddress selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(UserAddress record);

	int updateByPrimaryKey(UserAddress record);

	List<UserAddress> selectListByParams(Map<String, Object> params);

	int updateUserAddressByParams(UserAddress record);

	int updateByUserId(Map<String, Object> params);

	int updateCurrentAddressByUserId(Map<String, Object> params);

	int updateByPrimaryKeySelectiveWithOutUserId(Map<String, Object> params);
	
	int deleteByUserIdAndZtdId(Map<String,Object> params);

}