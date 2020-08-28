package com.chy.mapper;

import org.springframework.stereotype.Component;

import com.chy.pojo.out.Factory;
@Component
public interface FactoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Factory record);

    int insertSelective(Factory record);

    Factory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Factory record);

    int updateByPrimaryKey(Factory record);
}