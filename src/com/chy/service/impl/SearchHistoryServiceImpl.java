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

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return searchHistoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SearchHistory record) {
		return searchHistoryMapper.insert(record);
	}

	@Override
	public int insertSelective(SearchHistory record) {
		return searchHistoryMapper.insertSelective(record);
	}

	@Override
	public SearchHistory selectByPrimaryKey(Integer id) {
		return searchHistoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SearchHistory record) {
		return searchHistoryMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SearchHistory record) {
		return searchHistoryMapper.updateByPrimaryKey(record);
	}

}
