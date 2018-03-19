package com.gsh.base;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gsh.base.BaseDAO;

/**
 * 
*<p>Title:BaseDAOImpl </p>
*<p>Description: 基础数据库操作实现类 </p>
*<p>Company: </p> 
*@author gdd
*@date 2016-12-30 下午3:51:13
 */
@Transactional
@Component("baseDao")
@SuppressWarnings("unchecked")
public class BaseDAOImpl<T>  extends HibernateDaoSupport implements BaseDAO<T> {
	@Resource(name="sessionFactory")  
    public void setSupSessionFactory(SessionFactory sessionFactory){  
        super.setSessionFactory(sessionFactory);  
    } 
	 @Resource(name="hibernateTemplate")  
	  public void setSuperHibernateTemplate(org.springframework.orm.hibernate4.HibernateTemplate hibernateTemplate){  
	      super.setHibernateTemplate(hibernateTemplate);  
	 } 
	 /**
	  * 保存
	  */
	public Serializable save(T o) {
		return this.getHibernateTemplate().save(o);
	}
	
	/**
	 * 删除
	 */
	public void delete(T o) {
		this.getHibernateTemplate().delete(o);
	}
	/**
	 * 更新
	 */
	public void update(T o) {
		this.getHibernateTemplate().update(o);
	}
	/**
	 * 删除或更新
	 */
	public void saveOrUpdate(T o) {
		this.getHibernateTemplate().saveOrUpdate(o);
	}
	

	/**
	 * 根据hql查询
	 */
	public List<T> find(String hql) {
		return (List<T>) this.getHibernateTemplate().find(hql);
	}
	

	public List<T> find(String hql, Object[] param) {
		return (List<T>) this.getHibernateTemplate().find(hql,param);
	}

	public List<T> find(String hql, List<Object> param) {
		return (List<T>) this.getHibernateTemplate().find(hql,param);
	}

	public List<T> find(String hql, Object[] param, Integer page, Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		return (List<T>) this.getHibernateTemplate().find(hql, param,page,rows);
	}

	public List<T> find(String hql, List<Object> param, Integer page,Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		return (List<T>) this.getHibernateTemplate().find(hql, param,(page - 1) * rows,rows);
	}

	public T get(Class<T> c, Serializable id) {
		return (T) this.getHibernateTemplate().get(c, id);
	}

	public T get(String hql, Object[] param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	public T get(String hql, List<Object> param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}
	/**
	 * 根据hql查询，返回总得记录数
	 */
	public Long count(String hql) {
		return (Long) this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql).uniqueResult();
	}
	/**
	 *根据hql，多参数查询
	 */
	public Long count(String hql, Object[] param) {
		Query q = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return (Long) q.uniqueResult();
	}
	/**
	 * 
	 */
	public Long count(String hql, List<Object> param) {
		Query q = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return (Long) q.uniqueResult();
	}

	public Integer executeHql(String hql) {
		return this.getHibernateTemplate().find(hql).size();
	}
	/**
	 * 根据hql动态条件查询，返回总得记录数
	 */
	public Integer executeHql(String hql, Object[] param) {
		return this.find(hql, param).size();
	}
	/**
	 * 根据hql多条件参数绑定查询
	 */
	public Integer executeHql(String hql, List<Object> param) {
		Query q = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.executeUpdate();
	}
	/**
	 * 分页动态查询
	 */
	public List<T> find(T o,int page,int rows) {
		return 	this.getHibernateTemplate().findByExample(o, (page-1)*rows, rows);
	}
	/**
	 * 根据对象查询返回总得记录数
	 */
	public int getTotal(T o) {
		return 	this.getHibernateTemplate().findByExample(o).size();
	}
	/**
	 * 根据对象查询返回list
	 */
	public List<T> find(T o) {
		return this.getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(o.getClass()).add(Example.create(o)).list();  
	}
	
	/**
	 * 通用动态多条件查询通用方法
	 */
	public List<T> findcri(T o, Integer page, Integer rows) throws Exception {
		DetachedCriteria c = DetachedCriteria.forClass(o.getClass());
		Field[] fields = o.getClass().getDeclaredFields();
		String name="";
		Object value=null;
		for (Field f : fields) {
			 f.setAccessible(true);
			 if(!f.getType().toString().endsWith("Set")){
				name = f.getName();
				value = f.get(o); 
			 }
			if (null!=value &&!("").equals(value)) {
				if(name.endsWith("name")||name.endsWith("code")){
					 c.add(Restrictions.like(name,"%"+value+"%"));
					}
				else if(name.endsWith("ttime")){
						c.add(Restrictions.between("starttime", value, "9999-12-12"));
						}
				else if(name.endsWith("dtime")){
						c.add(Restrictions.between("endtime", "1000-01-01", value));
					}
				else 
					c.add(Restrictions.eq(name, value));
				System.out.println("name="+name+"||value="+value);
			}
		}
		return (List<T>) this.getHibernateTemplate().findByCriteria(c, (page-1)*rows, rows);
	}
	
	/**
	 * 根据hql查询记录数
	 */
	public int getCount(String hql){
		Integer count = (Integer)getHibernateTemplate().find(hql).listIterator().next();
		  return count.intValue();
	}
	
	public Serializable add(T o) {
		return this.getHibernateTemplate().save(o);
	}
	
	
}















