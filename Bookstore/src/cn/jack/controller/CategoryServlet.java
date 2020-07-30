package cn.jack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.jack.bean.Category;
import cn.jack.service.CategoryService;
import cn.jack.service.impl.CategoryServiceImpl;
import cn.jack.util.BaseServlet;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends BaseServlet{
    private CategoryService service = new CategoryServiceImpl();
	private static final long serialVersionUID = 1L;

	protected String getAllCate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> list = service.findAll();
	    Gson json = new Gson();
	    String js = json.toJson(list);
	    PrintWriter pw = response.getWriter();
	    pw.print(js);
	    pw.flush();
		return null;
	}
}
