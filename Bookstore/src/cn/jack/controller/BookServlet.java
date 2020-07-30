package cn.jack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.jack.bean.Book;
import cn.jack.service.BookService;
import cn.jack.service.impl.BookServiceImpl;
import cn.jack.util.BaseServlet;
import cn.jack.util.Page;


@WebServlet("/BookServlet")
public class BookServlet extends BaseServlet {
	
	private BookService service = new BookServiceImpl();

	private static final long serialVersionUID = 1L;
	

	protected String allbook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String size = request.getParameter("pagesize");
		String currentPageNo = request.getParameter("currentPageNo");
		
		Page<Book> page = new Page<Book>();
		if(size == null) {
			page.setPageSize(9);
		}else {
			page.setPageSize(Integer.parseInt(size));
		}
		page.setDataCount(service.findAll().size());
		if(currentPageNo != null) {
			page.setCurrentPageNo(Integer.parseInt(currentPageNo));
		}
		List<Book> books = service.findAll(page);
		page.setValues(books);
		Gson gson = new Gson();
		String json = gson.toJson(page);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.print(json);
		pw.flush();
		return null;
	}
	
	
	protected String gorybook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String size = request.getParameter("pagesize");
		String currentPageNo = request.getParameter("currentPageNo");
		String cid = request.getParameter("cid");
		Page<Book> page = new Page<Book>();
		if(size == null) {
			page.setPageSize(9);
		}else {
			page.setPageSize(Integer.parseInt(size));
		}
		page.setDataCount(service.findListByCid(cid).size());
		if(currentPageNo != null) {
			page.setCurrentPageNo(Integer.parseInt(currentPageNo));
		}
		List<Book> books = service.findListByCid(page, cid);
		page.setValues(books);
		response.setContentType("text/html;charset=UTF-8");
		request.setAttribute("cid", cid);
		request.setAttribute("page", page);
		
		return "/book/bookgory.jsp";
	}
	
	protected String bookinfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bid = request.getParameter("bid");
		Book book = service.findBookByBid(bid);
		request.setAttribute("book", book);
		return "/book/bookinfo.jsp";
	}
	
	
	
	
	  

}
