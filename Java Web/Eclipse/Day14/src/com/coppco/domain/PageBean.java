package com.coppco.domain;

import java.util.List;

public class PageBean<T> {
	private List<T> list;      //查询内容
	private int currentPage;  //当前页码
	private int pageSize;     //每页显示条数
	private int totalCount;   //总条数
	private int totalPage;    //总页数
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
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
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	/**
	 * 获取总页数
	 * @return
	 */
	public int getTotalPage() {
		return (int) Math.ceil(1.0 * totalCount / pageSize);
	}
	
	
	public PageBean(List<T> list, int currentPage, int pageSize, int totalCount) {
		super();
		this.list = list;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}

	
	
	
}
