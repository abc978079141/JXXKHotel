package com.gsh.service;

import java.io.Serializable;
import java.util.List;

/**
 * 
*<p>Title:BaseSerDao </p>
*<p style="color:red;">Description: 基础服务层接口</p>
*<p>Company: jxxkhotel </p> 
*@author gdd
*@date 2016-12-30 下午4:27:39
 */
public interface BaseSerDao<T>  {
	public void save(T o);
	public void update(T o);
	public void saveOrupdate(T o);
	public void delete(T o);
	
	public List<T> find(T o,int currentPage, int pageSize);
	public int getTotal(T o);
	public List<T> find(String hql);
	public List<T> find(T o);
	public List<T> findcri(T o, Integer page, Integer rows) throws Exception;
	public T get(Class<T> c, Serializable id);
	public int getCount(String hql);
	public Long count(String hql);
	public List<T> find(String hql, Object[] param);

}
