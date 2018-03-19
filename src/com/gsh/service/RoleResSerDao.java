package com.gsh.service;

import java.util.List;

import com.gsh.model.RoleResource;
/**
 * 
 *<p>Title:RoleResSerDao</p>
 *<p>Description:角色权限服务层接口</p>
 *<p>Company:GSH</p>
 * @author gdd
 * @date:2017-3-22 下午8:32:33
 */
public interface RoleResSerDao extends BaseSerDao<RoleResource> {
	public void deleteall(List<RoleResource> rolereslist);
}
