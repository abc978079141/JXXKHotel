package com.gsh.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gsh.base.BaseDAOImpl;
import com.gsh.dao.ResourceDao;
import com.gsh.dto.TreeDTO;
import com.gsh.model.Resource;

/**
*<p>Title:ResourceDaoImpl </p>
*<p>Description:  </p>
*<p>Company: </p> 
*@author gdd
*@date 2016-12-30 下午3:48:28
*/
@Repository("resourceDao")
public class ResourceDaoImpl extends BaseDAOImpl<Resource> implements ResourceDao{

	/**
	 * 根据父id获取子节点们 
	 */
	public List<TreeDTO> getChildrenByParentId(int ids[]) throws Exception {
		String hql = "from Resource as r where r.parentId = 1";
		/*if("".equals(id) || id == null){
			hql = "from Resource as r where r.parentId = 0";
		} else {
			hql = "from Resource as r where r.parentId = " + id ;
		}*/
		List<Resource> rlist = new ArrayList<Resource>();
		rlist=this.find(hql);
		System.out.println("***************rlist.size="+rlist.size());
		List<TreeDTO> tlist = new ArrayList<TreeDTO>();
		for (Iterator iterator = rlist.iterator(); iterator.hasNext();) {
			Resource resource = (Resource) iterator.next();
			System.out.println(resource.getId());
			TreeDTO tree = new TreeDTO();
			tree.setId(resource.getId());
			tree.setText(resource.getName());
			for(int id:ids){
			if(resource.getId()==id){
				tree.setChecked(1);
				}
			}
			//tree.setChecked(resource.getChecked());
			tree.setIconCls(resource.getIcon());
			tree.setParent_id(resource.getParentId());
			if(getChildren(resource.getId()).size() > 0){
				tree.setState("closed");
			} else {
				tree.setState("open");
			}
			Map<String, Object>  map = new HashMap<String, Object>();
			map.put("url", resource.getUrl());
			tree.setAttributes(map);
			tlist.add(tree);
		}
		return tlist;
	}
	
	
	
	/**
	 * 根据pid 获取孩子 
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	public List<Resource> getChildren(int pid) throws Exception{
		String hql = "from Resource as r where r.parentId = " + pid;
		List<Resource> children = new ArrayList<Resource>();
		children=this.find(hql);
		//System.out.println("getChildren"+children.size());
		return children;
	}
	
	

}
