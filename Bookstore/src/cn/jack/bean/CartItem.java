package cn.jack.bean;

import java.math.BigDecimal;

/**
 * 购物车条目
 *
 */
public class CartItem {
	private Book book;
	private int count;
	
	//小计  =  对应书的价格*购买的数量
	public double getSubtotal() {
		BigDecimal price = new BigDecimal(this.book.getPrice()+"");
		BigDecimal count = new BigDecimal(this.count+"");
		double result = price.multiply(count).doubleValue();
		return result;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	

    
}
