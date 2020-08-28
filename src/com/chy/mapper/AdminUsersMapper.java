package com.chy.mapper;

import com.chy.pojo.out.AdminUsers;

public interface AdminUsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminUsers record);

    int insertSelective(AdminUsers record);

    AdminUsers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminUsers record);

    int updateByPrimaryKey(AdminUsers record);
}