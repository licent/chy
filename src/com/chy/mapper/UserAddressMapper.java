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

	int updateByUserId(Map<String, Object> pararms);

	int updateCurrentAddressByUserId(Map<String, Object> pararms);
	
	int updateByPrimaryKeySelectiveWithOutUserId(Map<String, Object> pararms);
}