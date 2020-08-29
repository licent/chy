package com.chy.mapper;

import java.util.List;
import java.util.Map;

import com.chy.pojo.out.User;

public interface UserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	List<User> selectListByParams(Map<String, Object> params);

	int updateInfoByParams(Map<String, Object> params);
}