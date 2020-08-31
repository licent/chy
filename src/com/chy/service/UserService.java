package com.chy.service;

import java.util.List;
import java.util.Map;

import com.chy.pojo.out.User;

/**
 * @author Taylor.O
 * @用户-服务接口
 */
public interface UserService {
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	List<User> selectListByParams(Map<String, Object> params);

	int updateInfoByParams(Map<String, Object> params);

	List<User> selectNearlyCustomersListByItemId(Map<String, Object> params);
	
	List<User> selectUserFansListByUserId(Map<String, Object> params);
}
