package com.gsh.dao;


import java.util.List;
import com.gsh.base.BaseDAO;
import com.gsh.dto.TreeDTO;
import com.gsh.model.Resource;
/**
 * 
 *<p>Title:ResourceDao</p>
 *<p>Description:菜单权限操作接口</p>
 *<p>Company:GSH</p>
 * @author gdd
 * @date:2017-3-23 下午2:14:56
 */
public interface ResourceDao extends BaseDAO<Resource>{
	List<TreeDTO> getChildrenByParentId(int ids[]) throws Exception;
	public List<Resource> getChildren(int pid) throws Exception;
}
