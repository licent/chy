package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.SearchHistoryMapper;
import com.pojo.out.SearchHistory;
import com.service.SearchHistoryService;

/**
 * @搜索页服务
 */
@Service
public class SearchHistoryServiceImpl implements SearchHistoryService {

	@Autowired
	SearchHistoryMapper searchHistoryMapper;

	@Override
	public List<SearchHistory> selectByParams(Map<String, Object> params) {
		return searchHistoryMapper.selectByParams(params);
	}

}
