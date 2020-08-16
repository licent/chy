package com.mapper;

import com.pojo.out.AutoPoint;

public interface AutoPointMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AutoPoint record);

    int insertSelective(AutoPoint record);

    AutoPoint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AutoPoint record);

    int updateByPrimaryKey(AutoPoint record);
}