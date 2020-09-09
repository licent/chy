package com.chy.service.impl.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chy.mapper.AdminUsersMapper;
import com.chy.mapper.OrderMapper;
import com.chy.pojo.out.AdminUsers;
import com.chy.pojo.out.Order;
import com.chy.service.OrderService;
import com.chy.service.admin.AdminUsersService;

@Service
public class AdminUsersServiceImpl implements AdminUsersService{
	
	@Autowired
	AdminUsersMapper adminUsersMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return adminUsersMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(AdminUsers record) {
		return adminUsersMapper.insert(record);
	}

	@Override
	public int insertSelective(AdminUsers record) {
		return adminUsersMapper.insertSelective(record);
	}

	@Override
	public AdminUsers selectByPrimaryKey(Integer id) {
		return adminUsersMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(AdminUsers record) {
		return adminUsersMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(AdminUsers record) {
		return adminUsersMapper.updateByPrimaryKey(record);
	}

	@Override
	public AdminUsers selectByParamsForLogin(Map<String, Object> params) {
		return adminUsersMapper.selectByParamsForLogin(params);
	}

	@Override
	public List<AdminUsers> selectListByParams(Map<String, Object> params) {
		return adminUsersMapper.selectListByParams(params);
	}
}
