package cn.jack.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.jack.bean.Book;
import cn.jack.dao.BookDao;
import cn.jack.util.JdbcUtil;
import cn.jack.util.Page;

public class BookDaoImpl implements BookDao {
	QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());

	@Override
	public List<Book> findAll(Page<Book> page) throws SQLException {
		String sql = "select * from t_book limit ?,?";
		return qr.query(sql, new BeanListHandler<Book>(Book.class), (page.getCurrentPageNo() - 1) * page.getPageSize(),
				page.getPageSize());
	}

	@Override
	public List<Book> findListByCid(Page<Book> page, String cid) throws SQLException {

		String sql = "select * from t_book where cid = ? limit ?,?";
		return qr.query(sql, new BeanListHandler<Book>(Book.class), cid,
				(page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());

	}

	@Override
	public Book findBookByBid(String bid) throws SQLException {
		String sql = "select * from t_book where bid = ?";
		return qr.query(sql, new BeanHandler<Book>(Book.class), bid);

	}

	@Override
	public List<Book> findAll() throws SQLException {
		String sql = "select * from t_book";
		return qr.query(sql, new BeanListHandler<Book>(Book.class));
	}

	@Override
	public List<Book> findListByCid(String cid) throws SQLException {
		String sql = "select * from t_book where cid = ?";
		return qr.query(sql, new BeanListHandler<Book>(Book.class), cid);
	}

}
