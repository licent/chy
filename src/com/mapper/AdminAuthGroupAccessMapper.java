package com.mapper;

import com.pojo.out.AdminAuthGroupAccess;

public interface AdminAuthGroupAccessMapper {
    int insert(AdminAuthGroupAccess record);

    int insertSelective(AdminAuthGroupAccess record);
}