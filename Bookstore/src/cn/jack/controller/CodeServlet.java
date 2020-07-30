package cn.jack.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;

import cn.jack.util.BaseServlet;
import cn.jack.util.SendSMS;

@WebServlet("/CodeServlet")
public class CodeServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;

	protected String getCode(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String phone = request.getParameter("phone");
		int code =  (int)(Math.random() * 1000000);
		try {
			String value = SendSMS.sendCode(phone, code);
			System.out.println(value);
			request.getSession().setAttribute("code", code);
		} catch (ServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
