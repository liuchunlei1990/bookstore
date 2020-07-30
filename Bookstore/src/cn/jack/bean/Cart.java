package cn.jack.bean;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车
 *
 */
public class Cart {
	//Key: book.id  value
	private Map<String,CartItem> map = new LinkedHashMap<String,CartItem>();
     
	public void changeCount(String bid,int count) {
		CartItem item = map.get(bid);
		count = item.getCount()+count;
		if(count<=0) {
			//移除条目
			removeCartItem(bid);
			return;
		}
		item.setCount(count);
	}
	
	
	/**
	 * 清空购物车
	 */
	public void clear() {
		map.clear();
	}
	
	/**
	 * 添加购物条目
	 * @param item
	 */
	public void addCartItem(CartItem item) {
		//判断此条目是否已经存在
		if(map.containsKey(item.getBook().getBid())) {
			//如果包含此条目 得到原来的数量
			int old =  map.get(item.getBook().getBid()).getCount();
			BigInteger num1 = new BigInteger(old+"");
			BigInteger num2  = new BigInteger(item.getCount()+"");
			//数量
			item.setCount(num1.add(num2).intValue());
		}
		map.put(item.getBook().getBid(),item);
	}
	
	/**
	 * 删除指定条目
	 */
	public void removeCartItem(String bid) {
		map.remove(bid);
	}
	
	/**
	 * 获取我的购物车
	 * @return
	 */
	//cartItems
	public Collection<CartItem>  getCartItems(){
		return map.values();
	}
	
	
	/**
	 * 商品价格总计
	 * @return
	 */
	public double getTotal() {
		BigDecimal sum = new BigDecimal(0+"");
		for(CartItem item:map.values()) {
			BigDecimal dc = new BigDecimal(item.getSubtotal()+"");
			sum = sum.add(dc);
		}
		return sum.doubleValue();
	}

	
	
	
}
