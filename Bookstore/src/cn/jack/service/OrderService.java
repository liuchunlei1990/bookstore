package cn.jack.service;

import java.sql.SQLException;
import java.util.List;

import cn.jack.bean.Order;

public interface OrderService {
	/**
	 * @param order
	 * -添加订单
	 */
	void addOrder(Order order) ;
	
	/**
	 * @param uid
	 * @return
	 * -获取我的订单
	 */
	List<Order> orderByUid(String uid) ;
	
	/**
	 * @param id
	 * -修改订单的状态
	 */
	void updateOrderState(int id,String oid);
}
