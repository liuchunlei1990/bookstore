package cn.jack.service;

import java.util.List;

import cn.jack.bean.Book;
import cn.jack.util.Page;

public interface BookService {
	
	List<Book> findAll();

	/**
	 * 查询所有图书信息
	 * @return
	 */
	List<Book> findAll(Page<Book> page);
	
	/**
	 * 根据分类id查询图书信息
	 * @return
	 */
	List<Book> findListByCid(Page<Book> page,String cid);
	
	List<Book> findListByCid(String cid);
	
	/**
	 * 根据bid查询图书详细
	 * @param bid
	 * @return
	 */
	Book findBookByBid(String bid);
}
