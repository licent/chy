package com.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.CartMapper;
import com.pojo.out.Cart;
import com.service.CartService;

/**
 * @购物车
 */
@Service
public class CartServiceImpl implements CartService {

	@Autowired
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

}
