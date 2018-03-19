package com.gsh.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import com.gsh.base.BaseDAO;
/**
 * 
*<p>Title:BaseSerDaoImpl </p>
*<p style="color:red;">Description: 基础数据库操作实现类 </p>
*<p>Company: jxxkhotel </p> 
*@author gdd
*@date 2016-12-30 下午4:28:46
**@param <T> 实体类

 */
@Service("baseSerDao")
public class BaseSerDaoImpl<T> implements BaseSerDao<T> {
	private BaseDAO<T> baseDao;
	
	@Resource
	public void setBaseDao(BaseDAO<T> baseDao) {
		this.baseDao = baseDao;
	}
	/**
	 * 保存
	 * @param o 实体
	 */
	public void save(T o) {
		this.baseDao.save(o);
	}
	
	/**
	 * 更新
	 *  @param o 实体
	 */
	public void update(T o) {
		this.baseDao.update(o);
	}
	/**
	 * 删除
	 * @param 0 实体
	 */
	public void delete(T o) {
		this.baseDao.delete(o);
	}
	/**
	 * 分页封装
	 */
	public List<T> find(T o, int currentPage, int pageSize) {
		return  this.baseDao.find(o, currentPage, pageSize);
	}
	
	/**
	 * 根据hql返回指定对象list
	 */
	public List<T> find(String hql) {
		return this.baseDao.find(hql);
	}
	/**
	 * 根据查询条件获得总的记录数
	 */
	public int getTotal(T o) {
		return this.baseDao.getTotal(o);
	}
	public List<T> find(T o) {
		return this.baseDao.find(o);
	}
	/**
	 * 动态条件查询封装
	 * @throws Exception 
	 */
	public List<T> findcri(T o, Integer page, Integer rows) throws Exception{
		return baseDao.findcri(o, page, rows);
	}
	/**
	 * 根据id获取对象
	 */
	public T get(Class<T> c, Serializable id) {
		return baseDao.get(c, id);
	}
	/**
	 * 获取符合条件的记录数
	 */
	public int getCount(String hql) {
		return baseDao.getCount(hql);
	}
	public Long count(String hql) {
		return baseDao.count(hql);
	}
	public List<T> find(String hql, Object[] param) {
		return baseDao.find(hql, param);
	}
	public void saveOrupdate(T o) {
		baseDao.saveOrUpdate(o);
	}
	

}
