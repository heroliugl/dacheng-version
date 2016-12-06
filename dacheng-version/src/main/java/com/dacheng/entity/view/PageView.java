package com.dacheng.entity.view;

import java.util.List;

/**
 * //分页封装函数
 * 
 * @param <T>
 */
public class PageView<T> {
	
	public PageView() {
	}

	/**
	 * 默认每页10条
	 */
	public static final int DEFAULT_ITEMS_PER_PAGE = 10;

	/**
	 * 支持最大的分页条数
	 */
	public static final int MAX_ITEMS = Integer.MAX_VALUE;

	/**
	 * 当前页码，从1开始
	 */
	private int page = 1;

	/**
	 * 总记录数
	 */
	private int rowCount;

	/**
	 * 总页数
	 */
	private int pageCount;

	/**
	 * 分页当前页第一条数据在数据库索引
	 */
	private int beginIndex = 0;
	/**
	 * 每页记录条数
	 */
	private int pageSize;

	/**
	 * 是否查询总数 默认是true，首先查询总数。
	 */
	private boolean doAount = true;

	private List<T> records;
	

	/**
	 * 是否还有下一页。
	 */
	private boolean hasNextPage;
	

	/**
	 * 是否还有上一页。
	 */
	private boolean hasPrePage;
	

	/**
	 * 上一页。
	 */
	private int prePage;
	
	/**
	 * 下一页。
	 */
	private int nextPage;

	/**
	 * 获取总页数
	 * 
	 * @return
	 */
	public int getPages() {
		return (int) Math.ceil((double) rowCount / pageSize);
	}

	/**
	 * 获取当前页
	 * 
	 * @return
	 */
	public int getPage() {
		return page;
	}

	/**
	 * 设置当前页
	 * 
	 * @param page
	 *            当前页码
	 * @return
	 */
	public int setPage(int page) {
		return this.page = page;
	}

	/**
	 * 获取总记录数
	 * 
	 * @return
	 */
	public int getRowCount() {
		return rowCount;
	}

	/**
	 * 设置总记录数，并重新计算当前页码以确保其不超过总页数
	 * 
	 * @param items
	 *            总记录数
	 * @return
	 */
	public int setRowCount(int rowCount) {
		this.rowCount = (rowCount >= 0) ? rowCount : 0;
		this.pageSize = (pageSize > 0) ? pageSize : DEFAULT_ITEMS_PER_PAGE;

		setPage(calcPage(page));
		setPageCount(getPages());
		setBeginIndex((pageSize * (page - 1)));

		return this.rowCount;
	}

	/**
	 * 获取每页记录数
	 * 
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置每页记录数，并重新计算当前页码
	 * 
	 * @param itemsPerPage
	 *            每页记录数
	 * @return
	 */
	public int setPageSize(int pageSize) {
		this.pageSize = (pageSize > 0) ? pageSize : DEFAULT_ITEMS_PER_PAGE;
		return this.pageSize;
	}

	/**
	 * 获取开始索引，从1开始，应用于数据库层分页
	 * 
	 * @return
	 */
	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	/**
	 * 获取结束索引，应用于数据库层分页
	 * 
	 * @return
	 */
	public int getEndIndex() {
		return Math.min(pageSize * page, rowCount);
	}

	/**
	 * 获取第一页
	 * 
	 * @return
	 */
	public int getFirstPage() {
		return calcPage(1);
	}

	/**
	 * 获取最后一页
	 * 
	 * @return
	 */
	public int getLastPage() {
		return calcPage(getPages());
	}

	/**
	 * 获取前一页
	 * 
	 * @return
	 */
	public int getPreviousPage() {
		return calcPage(page - 1);
	}

	/**
	 * 获取前<code>n</code>页
	 * 
	 * @param n
	 * @return
	 */
	public int getPreviousPage(int n) {
		return calcPage(page - n);
	}

	/**
	 * 获取后一页
	 * 
	 * @return
	 */
	public int getNextPage() {
		return calcNextPage(this.getPage() + 1);
	}
	

	/**
	 * 确保给定的页码不小于1，不超过总页码
	 * 
	 * @param page
	 * @return
	 */
	protected int calcNextPage(int page) {
		int pages = getPages();
		if (page < 1) {
			return 1;
		}
		if (page > pages && pages != 0) {
			return pages;
		}
		return page;
	}

	/**
	 * 获取后<code>n</code>页
	 * 
	 * @param n
	 * @return
	 */
	public int getNextPage(int n) {
		return calcPage(page + n);
	}

	/**
	 * 确保给定的页码不小于1，不超过总页码
	 * 
	 * @param page
	 * @return
	 */
	protected int calcPage(int page) {
		int pages = getPages();
		if (page < 1) {
			return 1;
		}
		if (page > pages && pages != 0) {
			return pages;
		}
		return page;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public boolean isDoAount() {
		return doAount;
	}

	public void setDoAount(boolean doAount) {
		this.doAount = doAount;
	}

	public boolean isHasNextPage() {
		if(pageCount > this.getPage() ){
			return true;
		}else{
			return false;
		}
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public boolean isHasPrePage() {
		if(page>1){
			return true;
		}else{
			return false;
		}
	}

	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}

	public int getPrePage() {
		System.out.println(page);
		if(page > 1){
			return page -1;
		}else{
			return page;
		}
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	
	

	@Override
	public String toString() {
		return "PageView [page=" + page + ", rowCount=" + rowCount
				+ ", pageCount=" + pageCount + ", beginIndex=" + beginIndex
				+ ", pageSize=" + pageSize + ", doAount=" + doAount
				+ ", records=" + records + ", hasNextPage=" + isHasNextPage()
				+ ", hasPrePage=" + isHasPrePage()+ ", prePage=" + getPrePage()
				+ ", nextPage=" + getNextPage() + "]";
	}

}
