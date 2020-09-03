package com.chy.service.admin;

import java.util.List;
import java.util.Map;

import com.chy.pojo.out.AdminUsers;

public interface AdminUsersService {
	int deleteByPrimaryKey(Integer id);

    int insert(AdminUsers record);

    int insertSelective(AdminUsers record);

    AdminUsers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminUsers record);

    int updateByPrimaryKey(AdminUsers record);
    
    AdminUsers selectByParamsForLogin(Map<String,Object> params);
    
    List<AdminUsers> selectListByParams(Map<String,Object> params);
}
