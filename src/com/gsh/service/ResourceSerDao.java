package com.gsh.service;

import java.util.List;

import com.gsh.dto.TreeDTO;
import com.gsh.model.Resource;
/**
 * 
 *<p>Title:ResourceSerDao</p>
 *<p>Description:菜单操作接口</p>
 *<p>Company:GSH</p>
 * @author gdd
 * @date:2017-3-22 下午6:11:57
 */
public interface ResourceSerDao extends BaseSerDao<Resource> {
	List<TreeDTO> getChildrenByParentId(int ids[]) throws Exception;
	public List<Resource> getChildren(int pid) throws Exception;
}
