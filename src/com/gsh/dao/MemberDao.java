package com.gsh.dao;

import java.util.List;
import java.util.Map;
import com.gsh.base.BaseDAO;
import com.gsh.model.Members;

public interface MemberDao extends BaseDAO<Members>{
	public List<Members> searchbymap(Map<String ,Object> param,int currentpage,int pagesize);
	public List<Members> findcriteria(Members m, int currentPage, int pageSize) throws Exception;
}
