package com.chy.service;

import java.util.List;
import java.util.Map;

import com.chy.pojo.out.SearchHistory;

public interface SearchHistoryService {
	int deleteByPrimaryKey(Integer id);

	int insert(SearchHistory record);

	int insertSelective(SearchHistory record);

	SearchHistory selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(SearchHistory record);

	int updateByPrimaryKey(SearchHistory record);
	
	List<SearchHistory> selectByParams(Map<String, Object> params);
}
