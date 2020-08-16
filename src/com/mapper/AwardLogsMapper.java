package com.mapper;

import com.pojo.out.AwardLogs;

public interface AwardLogsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AwardLogs record);

    int insertSelective(AwardLogs record);

    AwardLogs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AwardLogs record);

    int updateByPrimaryKey(AwardLogs record);
}