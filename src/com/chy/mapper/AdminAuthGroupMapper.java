package com.chy.mapper;

import com.chy.pojo.out.AdminAuthGroup;

public interface AdminAuthGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminAuthGroup record);

    int insertSelective(AdminAuthGroup record);

    AdminAuthGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminAuthGroup record);

    int updateByPrimaryKeyWithBLOBs(AdminAuthGroup record);

    int updateByPrimaryKey(AdminAuthGroup record);
}