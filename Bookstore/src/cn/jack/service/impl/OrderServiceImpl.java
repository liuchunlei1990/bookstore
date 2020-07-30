package cn.jack.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.jack.bean.Order;
import cn.jack.dao.OrderDao;
import cn.jack.dao.impl.OrderDaoImpl;
import cn.jack.service.OrderService;
import cn.jack.util.JdbcUtil;

public class OrderServiceImpl implements OrderService {
	private OrderDao dao = new OrderDaoImpl();

	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
        try {
			JdbcUtil.beginTransaction();
			dao.addOrder(order);
			JdbcUtil.commitTransaction();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				JdbcUtil.rollbackTranaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	@Override
	public List<Order> orderByUid(String uid) {
		// TODO Auto-generated method stub
		try {
			return dao.orderByUid(uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateOrderState(int id, String oid) {
		// TODO Auto-generated method stub
        try {
			dao.updateOrderState(id, oid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
