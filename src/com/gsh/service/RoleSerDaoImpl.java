package com.gsh.service;



import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gsh.model.Role;
/**
 * 
 *<p>Title:RoleSerDaoImpl</p>
 *<p>Description:角色操作服务层实现类</p>
 *<p>Company:GSH</p>
 * @author gdd
 * @date:2017-3-23 下午5:41:41
 */
@Transactional
@Service("roleSerDao")
public class RoleSerDaoImpl extends BaseSerDaoImpl<Role> implements RoleSerDao {

}
