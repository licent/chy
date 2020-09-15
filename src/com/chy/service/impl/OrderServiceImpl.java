package com.chy.service.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chy.mapper.CartMapper;
import com.chy.mapper.ItemMapper;
import com.chy.mapper.OrderItemMapper;
import com.chy.mapper.OrderMapper;
import com.chy.mapper.OrdersMapper;
import com.chy.pojo.out.Order;
import com.chy.pojo.out.OrderItem;
import com.chy.service.OrderService;
import com.tools.IDMaker;
import com.tools.Md5;
import com.tools.MyHttpSender;
import com.tools.Tools;
import com.tools.WXPayUtil;

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
	
	@Autowired
	ItemMapper itemMapper;

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
			
			
			Map<String,Object> _rlist_param = new HashMap<String,Object>();
			_rlist_param.put("itemIdList", itemList);
			
			//把商品列表每件商品价格查询出来
			List<Map<String,Object>> _rlist=itemMapper.selectItemPriceByIdList(_rlist_param);
			Map<String,String> priceMap=new HashMap<String,String>();
			
			for(Map<String,Object> obj:_rlist) {
				priceMap.put(Tools.ObjectToString(obj.get("id")), Tools.ObjectToString(obj.get("itemStr")));
			}
			
			
			//将商品价格 封装到预处理对象
			for (int e = 0; e < orderItem.size(); e++) {
				orderItem.get(e).setOrderId(_ro.getId() + "");
				orderItem.get(e).setPrice(Float.parseFloat(priceMap.get(orderItem.get(e).getItemId()+"").split(":")[1]));
				orderItem.get(e).setPurchasePrice(Float.parseFloat(priceMap.get(orderItem.get(e).getItemId()+"").split(":")[2]));
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
		if (result != null && result.size() > 0) {
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
	public long selectListOrderPageCount(Map<String, Object> params) {
		return orderMapper.selectListOrderPageCount(params);
	}

	@Override
	public String wechatPay(Order order,String openId) throws Exception{
		String result=null;
		Map<String, String> map = new HashMap<String, String>();
		String appid="wxce31758573e47ce3";
		String mch_id="1601274073";
		String nonce_str=Md5.GetMD5Code(UUID.randomUUID().toString().replaceAll("-", "")).toUpperCase();
		String body="吃货丫-订单支付";
		String out_trade_no=order.getOrderCode();
		float total_fee = order.getTotalMoney();
		if(order.getIsSignFor()) {
			total_fee+=2;
		}
		long final_total_fee=(long) (total_fee*100);
		
		
//		String spbill_create_ip="182.254.202.42";
		String notify_url="<![CDATA[https://chioya.com/manage/pay/wechatPayCallBack.do]]>";
		
		//小程序支付 JSAPI
		String trade_type="JSAPI";
		
		String key="lubenjweiniub6666666666666666666";
		String paramsStr="";
		paramsStr+="appid="+appid+"&";
		paramsStr+="body="+body+"&";
		paramsStr+="mch_id="+mch_id+"&";
		paramsStr+="nonce_str="+nonce_str+"&";
		paramsStr+="notify_url="+notify_url+"&";
		paramsStr+="openid="+openId+"&";
		paramsStr+="out_trade_no="+out_trade_no+"&";
		paramsStr+="spbill_create_ip=182.254.202.42&";
		paramsStr+="total_fee="+final_total_fee+"&";
		paramsStr+="trade_type="+trade_type+"&";
		paramsStr+="key="+key;
		
		map.put("appid",appid);
		map.put("body",body);
		map.put("mch_id", mch_id);
		map.put("nonce_str",nonce_str);
		map.put("notify_url", notify_url);
		map.put("openid", openId);
		map.put("out_trade_no",out_trade_no);
		map.put("spbill_create_ip","182.254.202.42");
		map.put("total_fee",final_total_fee+"");
		map.put("trade_type",trade_type);
		
		String sign=Md5.GetMD5Code(paramsStr);//注：MD5签名方式
		sign=sign.toUpperCase();
		map.put("sign",sign);
		
		
		String paramXml = WXPayUtil.mapToXml(map);
		result=MyHttpSender.commonPost(MyHttpSender.WE_CHAT_PAY, paramXml,mch_id,6000,8000);
		
		return result;
	}
	@Override
	public List<Order> selectListByAutoPint(Map<String,Object> params){
		return orderMapper.selectListByAutoPint(params);
	}
}



