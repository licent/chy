package com.chy.mapper;

import com.chy.pojo.out.FlowEnter;

public interface FlowEnterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FlowEnter record);

    int insertSelective(FlowEnter record);

    FlowEnter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FlowEnter record);

    int updateByPrimaryKey(FlowEnter record);
}