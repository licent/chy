package com.chy.mapper;

import com.chy.pojo.out.AbnormalOrder;

public interface AbnormalOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AbnormalOrder record);

    int insertSelective(AbnormalOrder record);

    AbnormalOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AbnormalOrder record);

    int updateByPrimaryKey(AbnormalOrder record);
}