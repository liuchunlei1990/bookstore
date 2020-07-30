package cn.jack.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jack.bean.Cart;
import cn.jack.bean.CartItem;
import cn.jack.bean.Order;
import cn.jack.bean.OrderItem;
import cn.jack.bean.User;
import cn.jack.service.OrderService;
import cn.jack.service.impl.OrderServiceImpl;
import cn.jack.util.BaseServlet;

@WebServlet("/Order/OrderServlet")
public class OrderServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
	private OrderService service = new  OrderServiceImpl();
	

	protected String addOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String address = req.getParameter("address");
		Cart cart = (Cart) req.getSession().getAttribute("cart");
		User user = (User) req.getSession().getAttribute("user");
		Order order = new Order();
		String oid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
		order.setOid(oid);
		order.setOrdertime(new Date());
		order.setTotal(cart.getTotal());
		order.setState(1);
		order.setUser(user);
		//order.setAddress(address);
		List<OrderItem> items = new ArrayList<OrderItem>(); 
		//设置订单条目
		Collection<CartItem> cartitem = cart.getCartItems();
		for(CartItem item: cartitem) {
			//购物车条目转化为订单条目
			OrderItem otm = new OrderItem();
			otm.setIid(UUID.randomUUID().toString().replace("-", "").toUpperCase());
			otm.setCount(item.getCount());
			otm.setSubtotal(item.getSubtotal());
			otm.setOrder(order);
			otm.setBook(item.getBook());
			items.add(otm);
			
		}
		order.setOrderitemlist(items);
		service.addOrder(order);
		//清空购物车
		cart.clear();
        req.setAttribute("order",order);
		return "/order/desc.jsp";
	}
	
	protected String myOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		List<Order> orders = service.orderByUid(user.getUid());
		req.setAttribute("orderlist", orders);
		return "/order/orderlist.jsp";
	}

}
