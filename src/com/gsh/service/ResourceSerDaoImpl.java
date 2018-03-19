package com.gsh.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gsh.dao.ResourceDao;
import com.gsh.dto.TreeDTO;
import com.gsh.model.Resource;
/**
 * 
 *<p>Title:ResourceSerDaoImpl</p>
 *<p>Description:菜单操作接口实现类</p>
 *<p>Company:GSH</p>
 * @author gdd
 * @date:2017-3-22 下午6:14:47
 */
@Service
@Transactional
public class ResourceSerDaoImpl extends BaseSerDaoImpl<Resource> implements ResourceSerDao {
	private ResourceDao resourceDao;
	
	@javax.annotation.Resource
	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

	public List<TreeDTO> getChildrenByParentId(int ids[]) throws Exception {
		return resourceDao.getChildrenByParentId(ids);
	}

	public List<Resource> getChildren(int pid) throws Exception {
		return resourceDao.getChildren(pid);
	}
}
