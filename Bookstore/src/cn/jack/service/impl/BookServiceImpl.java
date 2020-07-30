package cn.jack.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.jack.bean.Book;
import cn.jack.dao.BookDao;
import cn.jack.dao.impl.BookDaoImpl;
import cn.jack.service.BookService;
import cn.jack.util.Page;

public class BookServiceImpl implements BookService {
    private BookDao dao = new BookDaoImpl();
	@Override
	public List<Book> findAll(Page<Book> page) {
		// TODO Auto-generated method stub
		try {
			return dao.findAll(page);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> findListByCid(Page<Book> page,String cid) {
		// TODO Auto-generated method stub
		try {
			return dao.findListByCid(page,cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Book findBookByBid(String bid) {
		// TODO Auto-generated method stub
		try {
			return dao.findBookByBid(bid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		try {
			return dao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> findListByCid(String cid) {
		// TODO Auto-generated method stub
		try {
			return dao.findListByCid(cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
