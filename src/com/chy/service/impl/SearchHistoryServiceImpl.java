package com.chy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chy.mapper.SearchHistoryMapper;
import com.chy.pojo.out.SearchHistory;
import com.chy.service.SearchHistoryService;

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
