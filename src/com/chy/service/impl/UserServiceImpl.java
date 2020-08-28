package com.chy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chy.mapper.UserMapper;
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

}
