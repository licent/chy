package com.mapper;

import com.pojo.out.Import;

public interface ImportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Import record);

    int insertSelective(Import record);

    Import selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Import record);

    int updateByPrimaryKeyWithBLOBs(Import record);

    int updateByPrimaryKey(Import record);
}