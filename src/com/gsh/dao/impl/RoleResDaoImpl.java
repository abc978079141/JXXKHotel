package com.gsh.dao.impl;




import java.util.List;

import org.springframework.stereotype.Repository;

import com.gsh.base.BaseDAOImpl;
import com.gsh.dao.RoleResDao;
import com.gsh.model.RoleResource;
/**
 * 
 *<p>Title:RoleResDaoImpl</p>
 *<p>Description:角色权限操作接口实现类</p>
 *<p>Company:GSH</p>
 * @author gdd
 * @date:2017-3-22 下午8:31:08
 */
@Repository("roleResDao")
public class RoleResDaoImpl  extends BaseDAOImpl<RoleResource> implements RoleResDao {
	/**
	 * 根据角色删除多个roleresource
	 */
	public void deleteall(List<RoleResource> rolereslist) {
		super.getHibernateTemplate().deleteAll(rolereslist);
	}	
}
