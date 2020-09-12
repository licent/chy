package com.chy.service;

import java.util.Map;

import com.chy.pojo.out.AutoPointask;

public interface AutoPointTaskService {
	
	int deleteByPrimaryKey(Integer id);

    int insert(AutoPointask record);

    int insertSelective(AutoPointask record);

    AutoPointask selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AutoPointask record);

    int updateByPrimaryKey(AutoPointask record);
    
    int deleteByParams(Map<String,Object> params);
    
    AutoPointask selectByParams(Map<String,Object> params);
    
    int autoPointUpdateTask(Map<String,Object> params);
    
    int autoPointDeteleTask(Map<String,Object> params);
    
    int updateByParams(Map<String,Object> params);
}
