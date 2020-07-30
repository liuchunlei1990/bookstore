package cn.jack.dao;

import java.sql.SQLException;
import java.util.List;

import cn.jack.bean.Category;

public interface CategoryDao {
   
	/**
	 * 查询所有分类
	 * @return
	 */
	List<Category> findAll() throws SQLException ;
}
