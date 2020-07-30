package cn.jack.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.jack.bean.Category;
import cn.jack.dao.CategoryDao;
import cn.jack.util.JdbcUtil;

public class CategoryDaoImpl implements CategoryDao {
	QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());

	@Override
	public List<Category> findAll() throws SQLException {
		String sql = "select * from t_category";
		return qr.query(sql, new BeanListHandler<Category>(Category.class));
	}

}
