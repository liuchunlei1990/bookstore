package cn.jack.dao;

import java.sql.SQLException;
import java.util.List;

import cn.jack.bean.Book;
import cn.jack.util.Page;

public interface BookDao {
	
	List<Book> findAll() throws SQLException ;
   
	/**
	 * 查询所有图书信息并分页
	 * @return
	 */
	List<Book> findAll(Page<Book> page) throws SQLException ;
	
	List<Book> findListByCid(String cid) throws SQLException ;
	
	/**
	 * 根据分类id查询图书信息并分页
	 * @return
	 */
	List<Book> findListByCid(Page<Book> page,String cid) throws SQLException ;
	
	/**
	 * 根据bid查询图书详细
	 * @param bid
	 * @return
	 */
	Book findBookByBid(String bid) throws SQLException ;
}
