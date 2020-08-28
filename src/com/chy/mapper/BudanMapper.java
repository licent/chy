package com.chy.mapper;

import org.springframework.stereotype.Component;

import com.chy.pojo.out.Budan;
@Component
public interface BudanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Budan record);

    int insertSelective(Budan record);

    Budan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Budan record);

    int updateByPrimaryKey(Budan record);
}