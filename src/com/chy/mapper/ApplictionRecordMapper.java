package com.chy.mapper;

import com.chy.pojo.out.ApplictionRecord;

public interface ApplictionRecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(ApplictionRecord record);

    int insertSelective(ApplictionRecord record);

    ApplictionRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ApplictionRecord record);

    int updateByPrimaryKey(ApplictionRecord record);
}