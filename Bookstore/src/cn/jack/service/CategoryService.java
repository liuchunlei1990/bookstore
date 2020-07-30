package cn.jack.service;

import java.util.List;

import cn.jack.bean.Category;

public interface CategoryService {
	/**
	 * 查询所有分类
	 * @return
	 */
	List<Category> findAll();
}
