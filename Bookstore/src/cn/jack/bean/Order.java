package cn.jack.bean;

import java.util.Date;
import java.util.List;
import cn.jack.bean.OrderItem;;

/**
 * 订单类
 *
 */
public class Order {
	private String oid; // 订单编号 ：UUID
	private Date ordertime; // 下单时间：java.sql.Date 是java.util.Date子类
	private double total; // 总计
	private int state; // 订单状态： 1.未支付 2.已支付未发货 3.已发货 4.已收货
	private User user; //用户
	private String address;  //地址
	private List<OrderItem> orderitemlist;  //此订单下的所有条目

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<OrderItem> getOrderitemlist() {
		return orderitemlist;
	}

	public void setOrderitemlist(List<OrderItem> orderitemlist) {
		this.orderitemlist = orderitemlist;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", ordertime=" + ordertime + ", total=" + total + ", state=" + state + ", user="
				+ user + ", address=" + address + ", orderitemlist=" + orderitemlist + "]";
	}
	
	

}
