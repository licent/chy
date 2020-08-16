package com.mapper;

import com.pojo.out.Tab;

public interface TabMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tab record);

    int insertSelective(Tab record);

    Tab selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tab record);

    int updateByPrimaryKey(Tab record);
}