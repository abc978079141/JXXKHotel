package com.gsh.model;
/**
 * 
 *<p>Title:PageInfo</p>
 *<p>Description:页面分页数据</p>
 *<p>Company:GSH</p>
 * @author gdd
 * @date:2017-3-26 下午9:00:21
 */
public class PageInfo {
	private Integer page;
	private Integer rows;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public PageInfo(Integer page, Integer rows) {
		super();
		this.page = page;
		this.rows = rows;
	}
	public PageInfo() {
		super();
	}
	@Override
	public String toString() {
		System.out.println("page="+this.page);
		System.out.println("rows="+this.rows);
		return super.toString();
	}
	
}
