package com.service;

import com.pojo.out.User;

/**
 * @author Taylor.O
 * @用户-服务接口
 */
public interface UserService {
	User selectByPrimaryKey(Integer id);
}
