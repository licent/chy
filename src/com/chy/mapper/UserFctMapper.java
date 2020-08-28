package com.chy.mapper;

import com.chy.pojo.out.UserFct;

public interface UserFctMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserFct record);

    int insertSelective(UserFct record);

    UserFct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserFct record);

    int updateByPrimaryKey(UserFct record);
}