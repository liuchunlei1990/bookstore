package cn.jack.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import cn.jack.bean.Book;
import cn.jack.bean.Order;
import cn.jack.bean.OrderItem;
import cn.jack.dao.OrderDao;
import cn.jack.util.JdbcUtil;

public class OrderDaoImpl implements OrderDao {
	private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());

	@Override
	public void addOrder(Order order) throws SQLException {
		String sql = "INSERT INTO `t_orders` VALUES(?,?,?,?,?,?)";
		qr.update(JdbcUtil.getConnection(), sql, order.getOid(),
				order.getOrdertime(),order.getTotal(),order.getState(),
				order.getUser().getUid(),order.getAddress());
		//添加订单条目
		addOrderItems(order);
	}
	
	
	public void addOrderItems(Order order) throws SQLException {
		String sql = "INSERT INTO `orderitem` VALUES(?,?,?,?,?)";
		Object items[] = order.getOrderitemlist().toArray();
		Object params[][] = new Object[items.length][];
		for(int i = 0 ; i < items.length ; i++) {
			OrderItem item = (OrderItem) items[i];
			params[i] = new Object[5];
		    params[i][0] = item.getIid();
		    params[i][1] = item.getCount();
		    params[i][2] = item.getSubtotal();
		    params[i][3] = item.getOrder().getOid();
		    params[i][4] = item.getBook().getBid();		
		}
		//批量添加
		qr.batch(JdbcUtil.getConnection(), sql, params);
	}
	
	
	

	@Override
	public List<Order> orderByUid(String uid) throws SQLException {
		String sql = "SELECT * FROM `t_orders` WHERE uid = ?";
		List<Order>  orders= qr.query(sql, new BeanListHandler<Order>(Order.class),uid);
		//order里面的订单条目没有设置
		for(Order order:orders) {
			//此订单的订单条目查询出来
			List<OrderItem> items = orderItemsByOid(order.getOid());
			order.setOrderitemlist(items);
		}
		
		return orders;
	}
	
	public List<OrderItem> orderItemsByOid(String oid){
		List<OrderItem> items = new ArrayList<OrderItem>();
		String sql = "SELECT `iid`,`count`,`subtotal`,b.`bid`,`bname`,`price`,`author`,`image`,`cname`"
				+ " FROM `orderitem` o"
				+ " INNER JOIN `t_book` b "
				+ " ON o.`bid` = b.`bid` "
				+ " INNER JOIN `t_category` c"
				+ " ON b.`cid` = c.`cid`"
				+ " WHERE `oid` = ?";
		try {
			List<Map<String,Object>> maps = qr.query(sql, new MapListHandler(),oid);
			for(Map map : maps) {
				//Map >> OrderItem ,Book
				OrderItem item = new OrderItem();
				try {
					BeanUtils.populate(item, map);
					Book book = new Book();
					BeanUtils.populate(book, map);
					item.setBook(book);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				items.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}

	@Override
	public void updateOrderState(int id,String oid) throws SQLException {
		String sql = "update `t_orders` SET `state` = ? WHERE `oid` = ?";
        qr.update(sql, id,oid);
	}

}
