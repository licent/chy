package com.mapper;

import com.pojo.out.BounsLogs;

public interface BounsLogsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BounsLogs record);

    int insertSelective(BounsLogs record);

    BounsLogs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BounsLogs record);

    int updateByPrimaryKey(BounsLogs record);
}