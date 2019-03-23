package src.com.bdqn.zmj.entity;

import java.util.List;

public class Page<T> {
	private int currentPage;// 当前页
	private int pageSize;// 每页大小
	private int count;// 总条数
	private int totalPage;// 总页数
	private List<T> data;// 数据写出泛型比较方便使用
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}

}