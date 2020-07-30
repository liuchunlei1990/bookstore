package cn.jack.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jack.bean.Book;
import cn.jack.bean.Cart;
import cn.jack.bean.CartItem;
import cn.jack.service.BookService;
import cn.jack.service.impl.BookServiceImpl;
import cn.jack.util.BaseServlet;

@WebServlet("/cart/CartServlet")
public class CartServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	private BookService service = new BookServiceImpl();

	protected String addCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bid = request.getParameter("bid");
		String count = request.getParameter("count");
		Book book = service.findBookByBid(bid);
		// 得到车
		Object ct = request.getSession().getAttribute("cart");
		Cart cart = (Cart) ct;
		// 创建购物车条目
		CartItem item = new CartItem();
		item.setBook(book);
		if (count != null) {
			item.setCount(Integer.parseInt(count));
		}
		// 设置车
		cart.addCartItem(item);
		return "/cart/mycart.jsp";
	}

	protected String clear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.clear();
		return "/cart/mycart.jsp";
	}

	protected String changeCount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		String count = request.getParameter("count");
		String bid = request.getParameter("bid");
		cart.changeCount(bid, Integer.parseInt(count));
		return "/cart/mycart.jsp";
	}

	protected String removeItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		String bid = request.getParameter("bid");
		cart.removeCartItem(bid);
		return "/cart/mycart.jsp";
	}
	
	
	
	

}
