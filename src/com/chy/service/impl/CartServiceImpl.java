package com.chy.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chy.mapper.CartMapper;
import com.chy.pojo.out.Cart;
import com.chy.service.CartService;

/**
 * @购物车
 */
@Service
public class CartServiceImpl implements CartService {

	@Resource
	CartMapper cartMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return cartMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Cart record) {
		return cartMapper.insert(record);
	}

	@Override
	public int insertSelective(Cart record) {
		return cartMapper.insertSelective(record);
	}

	@Override
	public Cart selectByPrimaryKey(Integer id) {
		return cartMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Cart record) {
		return cartMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Cart record) {
		return cartMapper.updateByPrimaryKey(record);
	}

	@Override
	public long selectCountByParams(Map<String, Object> params) {
		return cartMapper.selectCountByParams(params);
	}

	@Override
	public long deleteByParams(Map<String, Object> params) {
		return cartMapper.deleteByParams(params);
	}

	@Override
	public long updateNumByParams(Map<String, Object> params) {
		return cartMapper.updateNumByParams(params);
	}

}
