package com.chy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chy.mapper.UserMapper;
import com.chy.pojo.in.UserEx;
import com.chy.pojo.out.User;
import com.chy.service.UserService;

/**
 * @author Taylor.O
 * 
 * @用户-服务接口实现类
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public User selectByPrimaryKey(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(User record) {
		return userMapper.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		return userMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		return userMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<User> selectListByParams(Map<String, Object> params) {
		return userMapper.selectListByParams(params);
	}

	@Override
	public int updateInfoByParams(Map<String, Object> params) {
		return userMapper.updateInfoByParams(params);
	}

	@Override
	public List<User> selectNearlyCustomersListByItemId(Map<String, Object> params) {
		return userMapper.selectNearlyCustomersListByItemId(params);
	}

	@Override
	public List<User> selectUserFansListByUserId(Map<String, Object> params) {
		return userMapper.selectUserFansListByUserId(params);
	}

	@Override
	public UserEx selectUserRolesStatus(Map<String, Object> params) {
		return userMapper.selectUserRolesStatus(params);
	}
	@Override
	public User selectUserPayPwd(Map<String, Object> params) {
		return userMapper.selectUserPayPwd(params);
	}
}
