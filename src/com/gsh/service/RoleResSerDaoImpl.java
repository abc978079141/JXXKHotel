package com.gsh.service;



import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gsh.dao.RoleResDao;
import com.gsh.model.RoleResource;
/**+
 * 
 *<p>Title:RoleResSerDaoImpl</p>
 *<p>Description:角色权限服务层操作接口实现类</p>
 *<p>Company:GSH</p>
 * @author gdd
 * @date:2017-3-22 下午8:34:06
 */
@Transactional
@Service("roleResSerDao")
public class RoleResSerDaoImpl extends BaseSerDaoImpl<RoleResource> implements RoleResSerDao {

	private RoleResDao roleResDao;
	@Resource
	public void setRoleResDao(RoleResDao roleResDao) {
		this.roleResDao = roleResDao;
	}
	/**
	 * 删除多个roleresource
	 */
	public void deleteall(List<RoleResource> rolereslist) {
		this.roleResDao.deleteall(rolereslist);
	}
	
}
