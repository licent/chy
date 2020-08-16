package com.mapper;

import com.pojo.out.AdminAuthRule;

public interface AdminAuthRuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminAuthRule record);

    int insertSelective(AdminAuthRule record);

    AdminAuthRule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminAuthRule record);

    int updateByPrimaryKey(AdminAuthRule record);
}