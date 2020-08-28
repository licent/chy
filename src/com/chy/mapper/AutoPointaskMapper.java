package com.chy.mapper;

import com.chy.pojo.out.AutoPointask;

public interface AutoPointaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AutoPointask record);

    int insertSelective(AutoPointask record);

    AutoPointask selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AutoPointask record);

    int updateByPrimaryKey(AutoPointask record);
}