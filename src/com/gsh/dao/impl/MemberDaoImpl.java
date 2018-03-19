package com.gsh.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gsh.base.BaseDAOImpl;
import com.gsh.dao.MemberDao;
import com.gsh.model.Members;
/**
 * 
*<p>Title:MemberDaoImpl </p>
*<p>Description: </p>
*<p>Company: </p> 
*@author gdd
*@date 2016-12-30 下午3:49:35
 */
@Transactional
@Repository("MemberDao")
public class MemberDaoImpl extends BaseDAOImpl<Members> implements MemberDao {
	public List<Members> searchbymap(Map<String, Object> param,int currentpage,int pagesize) {
		String hql = " from Memberers as m where 1=1 ";
		Set<Entry<String, Object>> set = param.entrySet();
		Iterator io = set.iterator();
		while (io.hasNext()) {
			Map.Entry<String, Object> me = (Map.Entry<String, Object>) io.next();
			if("memname".equals(me.getKey()) && ""!=me.getValue()){
				hql += " and m." + me.getKey() + " ="+ me.getValue();
			}
			if("memnum".equals(me.getKey()) && ""!=me.getValue()){
				hql += " and m." + me.getKey() + " = " + me.getValue();
			}
			if("birthday".equals(me.getKey()) && ""!=me.getValue()){
				hql += " and m." + me.getKey() + " =" + me.getValue();
			}
		}	return (List<Members>) super.getHibernateTemplate().find(hql);
	}
	
	

	public List<Members> findcriteria(Members m, int currentPage, int pageSize) throws Exception {
		List<Members> list=new ArrayList<Members>();
		DetachedCriteria criteria=DetachedCriteria.forClass(Members.class);
		if(m.getMemname()!=null){
			criteria.add(Restrictions.eq("memname", m.getMemname()));
		}
		if(m.getMemnum()!=null&&!m.getMemnum().equals("")){
			criteria.add(Restrictions.eq("memnum", m.getMemnum()));
		}
		if(m.getState()!=null)criteria.add(Restrictions.eq("state", m.getState()));
		if(m.getMemType()!=null)criteria.add(Restrictions.eq("memType", m.getMemType()));
		return  (List<Members>)super.findcri(m,currentPage,pageSize);
	}
	
	
	
	
}
