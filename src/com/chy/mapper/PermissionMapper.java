package com.chy.mapper;

import com.chy.pojo.out.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKeyWithBLOBs(Permission record);

    int updateByPrimaryKey(Permission record);
}