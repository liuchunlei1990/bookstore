package cn.jack.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.jack.bean.Category;
import cn.jack.dao.CategoryDao;
import cn.jack.dao.impl.CategoryDaoImpl;
import cn.jack.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDao dao = new CategoryDaoImpl();

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		try {
			return dao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
