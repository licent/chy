package com.chy.service;

import java.util.List;
import java.util.Map;

import com.chy.pojo.out.SearchHistory;

public interface SearchHistoryService {
	List<SearchHistory> selectByParams(Map<String, Object> params);
}
