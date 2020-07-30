package cn.jack.dao;

import java.sql.SQLException;
import java.util.List;

import cn.jack.bean.Order;

public interface OrderDao {

	/**
	 * @param order
	 * -添加订单
	 */
	void addOrder(Order order) throws SQLException ;
	
	/**
	 * @param uid
	 * @return
	 * -获取我的订单
	 */
	List<Order> orderByUid(String uid) throws SQLException ;
	
	/**
	 * @param id
	 * -修改订单的状态
	 */
	void updateOrderState(int id,String oid) throws SQLException ;
}
