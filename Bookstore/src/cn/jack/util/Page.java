package cn.jack.util;

import java.util.List;

public class Page<T> {
    
	//数据总量
	private int dataCount;
	//页面大小
	private int pageSize = 5;
	//当前页码
	private int currentPageNo = 1;
	//总页码数
	private int totalPageCount;
	//当前页码数据
	private List<T> values;
	
	public int getDataCount() {
		return dataCount;
	}
	public void setDataCount(int dataCount) {
		if(dataCount <= 0 ) {
			return;
		}
		this.dataCount = dataCount;
		//计算总页面数 
		this.totalPageCount = this.dataCount % this.pageSize == 0 ?
				this.dataCount / this.pageSize : this.dataCount / this.pageSize + 1;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if(pageSize <= 0 ) {
			return;
		}
		this.pageSize = pageSize;
		this.totalPageCount = this.dataCount % this.pageSize == 0 ?
				this.dataCount / this.pageSize : this.dataCount / this.pageSize + 1;
	}
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		if(currentPageNo <= 0) {
			return;
		}
		if(currentPageNo > totalPageCount) {
			return;
		}
		this.currentPageNo = currentPageNo;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}

	
	public List<T> getValues() {
		return values;
	}
	public void setValues(List<T> values) {
		this.values = values;
	}
	
	
	
}
