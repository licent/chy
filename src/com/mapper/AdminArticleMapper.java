package com.mapper;

import com.pojo.out.AdminArticle;

public interface AdminArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminArticle record);

    int insertSelective(AdminArticle record);

    AdminArticle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminArticle record);

    int updateByPrimaryKey(AdminArticle record);
}