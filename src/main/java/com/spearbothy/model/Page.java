package com.spearbothy.model;

import java.util.List;

/**
 * 分页对象
 * 
 * @author alex_mahao
 *
 * @param <T>
 */
public class Page<T> {

	/**
	 * 总记录数
	 */
	private int maxRow;

	/**
	 * 当前页号
	 */
	private int currentPage;

	/**
	 * 分页大小
	 */
	private int pageSize;

	/**
	 * 保存数据
	 */
	private List<T> data;

	/**
	 * 分页大小
	 */
	private int totalPage;

	/**
	 * 是否还有下一页
	 */
	private boolean isHasNext;

	public boolean isHasNext() {
		return isHasNext;
	}

	public void setHasNext(boolean isHasNext) {
		this.isHasNext = isHasNext;
	}

	public int getMaxRow() {
		return maxRow;
	}

	public void setMaxRow(int maxRow) {
		this.maxRow = maxRow;
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

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
