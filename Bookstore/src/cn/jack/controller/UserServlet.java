package cn.jack.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jack.bean.Cart;
import cn.jack.bean.User;
import cn.jack.service.UserService;
import cn.jack.service.impl.UserServiceImpl;
import cn.jack.util.BaseServlet;

@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet{
    private UserService service = new  UserServiceImpl();
	private static final long serialVersionUID = 1L;

	protected String loginByUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String msg = service.loginByUsername(username, password);
		if(msg == null) {
			String path = this.getServletContext().getContextPath();
			//如果登录成功保存到session
			User user  = service.getUser(username);
			request.getSession().setAttribute("user", user);
			Cart cart = new Cart();
			request.getSession().setAttribute("cart",cart);
			return "redirect:"+path +"/main.jsp";
		}else {
			request.setAttribute("msg",msg);
		}
		return "/user/login.jsp";
	}
	
	protected String loginByPhone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String phone = request.getParameter("phone");
		String inputCode = request.getParameter("code");
		Object code = request.getSession().getAttribute("code");
		PrintWriter pw = response.getWriter();
		if(inputCode != null && code != null) {
			if(!inputCode.equals(code.toString())) {
		        //pw.print("验证码错误");
		        //pw.flush();
				//return null;
			}
		}else {
			 //pw.print("验证码未获取或者未输入");
		     //pw.flush();
			 //return null;
		}
		String msg = service.loginByPhone(phone);
		
		if(msg == null) {
			User user  = service.getUserPhone(phone);
			request.getSession().setAttribute("user", user);
			String path = this.getServletContext().getContextPath();
			Cart cart = new Cart();
			request.getSession().setAttribute("cart",cart);
			//System.out.println(path+"/main.jsp");
			return "redirect:"+path +"/main.jsp";
		}else {
			pw.print(msg);
		    pw.flush();
			return null;
		}
		
	}
}
