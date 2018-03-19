package com.gsh.dao;

import java.util.List;

import com.gsh.base.BaseDAO;
import com.gsh.model.RoleResource;
/**
 * 
 *<p>Title:RoleResDao</p>
 *<p>Description:角色与权限操作接口</p>
 *<p>Company:GSH</p>
 * @author gdd
 * @date:2017-3-22 下午8:29:40
 */
public interface RoleResDao extends BaseDAO<RoleResource> {
	public void deleteall(List<RoleResource> rolereslist);
}
