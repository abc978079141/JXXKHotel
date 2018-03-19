package com.gsh.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

import com.gsh.dao.MemberDao;
import com.gsh.model.Members;
/**
 * 
*<p>Title:MemSerDaoImpl </p>
*<p style="color:red;">Description:会员操作扩展实现类 </p>
*<p>Company: jxxkhotel </p> 
*@author gdd
*@date 2016-12-30 下午4:25:27
 */
@Repository("memSerDao")
public class MemSerDaoImpl extends BaseSerDaoImpl<Members> implements MemSerDao {
	@Resource
	private MemberDao memDao;
	
	public void setMemDao(MemberDao memDao) {
		this.memDao = memDao;
	}

	public List<Members> searchbymap(Map<String, Object> param) {
		return 	memDao.searchbymap(param, 1, 1000);
	}

	public List<Members> findcriteria(Members m, int currentPage, int pageSize) throws Exception {
		return memDao.findcriteria(m, currentPage, pageSize);
	}

	

}
