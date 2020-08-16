package com.mapper;

import com.pojo.out.TitleHistory;

public interface TitleHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TitleHistory record);

    int insertSelective(TitleHistory record);

    TitleHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TitleHistory record);

    int updateByPrimaryKey(TitleHistory record);
}