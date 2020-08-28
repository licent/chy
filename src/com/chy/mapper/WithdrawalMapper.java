package com.chy.mapper;

import com.chy.pojo.out.Withdrawal;

public interface WithdrawalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Withdrawal record);

    int insertSelective(Withdrawal record);

    Withdrawal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Withdrawal record);

    int updateByPrimaryKey(Withdrawal record);
}