package com.gsh.dao.impl;


import org.springframework.stereotype.Repository;

import com.gsh.base.BaseDAOImpl;
import com.gsh.dao.RoleDao;
import com.gsh.model.Role;
/**
 * 
 *<p>Title:RoleDaoImpl</p>
 *<p>Description:角色操作持久层实现类</p>
 *<p>Company:GSH</p>
 * @author gdd
 * @date:2017-3-23 下午5:39:26
 */
@Repository("roleDao")
public class RoleDaoImpl extends BaseDAOImpl<Role> implements RoleDao {
	
}
