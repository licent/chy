package com.chy.mapper;

import com.chy.pojo.out.VisitorsTag;

public interface VisitorsTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VisitorsTag record);

    int insertSelective(VisitorsTag record);

    VisitorsTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VisitorsTag record);

    int updateByPrimaryKey(VisitorsTag record);
}