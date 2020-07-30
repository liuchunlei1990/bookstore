package cn.jack.util;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset-UTF-8");
		String method = request.getParameter("method");
		if (method == null || method.trim().isEmpty()) {
			throw new RuntimeException("无法确认您想要调用的方法，请提供method参数！");
		}
		Class cls = this.getClass();
		Method mt = null;
		try {
			mt = cls.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
			mt.setAccessible(true);
			String value = (String) mt.invoke(this, request, response);
			if (value == null || value.trim().isEmpty()) {
				return;
			}
			// 要取冒号前，以及冒号后的数据
			int index = value.lastIndexOf(":");
			if (index == -1) {
               //默认请求转发
				request.getRequestDispatcher(value).forward(request, response);
				return;
			}
			String before = value.substring(0, index);
			String after = value.substring(index + 1);
			if(before.equalsIgnoreCase("forward")) {
				request.getRequestDispatcher(after).forward(request, response);
			}else if(before.equalsIgnoreCase("redirect")){
				response.sendRedirect(after);
			}else {
				throw new RuntimeException("当前版本不支持您要操作！");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
		    //throw new RuntimeException("您要调用的方法不存在！");
			e.printStackTrace();
		}

	}

}
