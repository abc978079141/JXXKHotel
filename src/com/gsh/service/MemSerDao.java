package com.gsh.service;


import java.util.List;
import java.util.Map;

import com.gsh.model.Members;
/**
 * 
*<p>Title:MemSerDao </p>
*<p style="color:red;">Description: 会员操作扩展接口 </p>
*<p>Company: jxxkhotel </p> 
*@author gdd
*@date 2016-12-30 下午4:24:50
 */
public interface MemSerDao extends BaseSerDao<Members> {
	public List<Members> searchbymap(Map<String ,Object> param);
	public List<Members> findcriteria(Members m, int currentPage, int pageSize) throws Exception;
}
