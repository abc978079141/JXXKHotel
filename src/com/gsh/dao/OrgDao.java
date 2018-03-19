package com.gsh.dao;

import java.util.List;

import com.gsh.base.BaseDAO;
import com.gsh.model.Org;

public interface OrgDao extends BaseDAO<Org>{
	List<Org> findList(String id) throws Exception;
	public List<Org> getChildren(int id) throws Exception;

}
