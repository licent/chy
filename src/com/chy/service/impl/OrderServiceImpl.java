package com.chy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chy.mapper.CartMapper;
import com.chy.mapper.OrderItemMapper;
import com.chy.mapper.OrderMapper;
import com.chy.pojo.out.Order;
import com.chy.pojo.out.OrderItem;
import com.chy.service.OrderService;
import com.tools.IDMaker;

/**
 * @订单服务
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderMapper orderMapper;

	@Autowired
	OrderItemMapper orderItemMapper;

	@Autowired
	CartMapper cartMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return orderMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Order record) {
		return orderMapper.insert(record);
	}

	@Override
	public int insertSelective(Order record) {
		return orderMapper.insertSelective(record);
	}

	@Override
	public Order selectByPrimaryKey(Integer id) {
		return orderMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Order record) {
		return orderMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Order record) {
		return orderMapper.updateByPrimaryKey(record);
	}

	@Transactional(value="txManager",rollbackFor = Exception.class)
	@Override
	public Order creatOrder(Order order, List<OrderItem> orderItem, String itemList) throws Exception {
		List<Order> result = null;
		if (order != null && orderItem != null) {
			// 初始化订单编码
			order.setOrderCode(IDMaker.createOrderCode());
		} else {
			return null;
		}
		// 创建订单
		long or = orderMapper.insertSelective(order);
		if (or > 0) {
			Map<String, Object> _qp = new HashMap<String, Object>();
			_qp.put("orderCode", order.getOrderCode());
			Order _ro = orderMapper.selectListByParams(_qp).get(0);

			for (int e = 0; e < orderItem.size(); e++) {
				orderItem.get(e).setOrderId(_ro.getId() + "");
			}

			long oir = orderItemMapper.insertBatch(orderItem);
			if (oir > 0) {
				// 删除购物车
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("itemIdList", itemList);
				params.put("userId", order.getUserId());
				long dc = cartMapper.deleteByParams(params);
				/*
					if(dc==0) {
						throw new Exception("订单关联数据新增失败t_order_item");
					}
				*/
				Map<String, Object> p = new HashMap<String, Object>();
				p.put("orderCode", order.getOrderCode());
				// 查询订单数据
				result = orderMapper.selectListByParams(p);
			} else {
				// 订单创建失败
				throw new Exception("订单关联数据新增失败t_order_item");
			}
		} else {
			// 创建订单失败
			throw new Exception("订单基础数据新增失败t_order");
		}
		if (result != null && result.size() > 1) {
			return result.get(0);
		} else {
			return null;
		}

	}

	@Override
	public List<Order> selectListByParams(Map<String, Object> params) {
		return orderMapper.selectListByParams(params);
	}

	@Override
	public List<Order> selectListByParamsPageing(Map<String, Object> params) {
		return orderMapper.selectListByParamsPageing(params);
	}

	@Override
	public int selectListOrderPageCount(Map<String, Object> params) {
		return orderMapper.selectListOrderPageCount(params);
	}

}
