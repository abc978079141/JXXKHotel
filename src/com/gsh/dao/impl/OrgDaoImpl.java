package com.gsh.dao.impl;


import java.util.List;

import com.gsh.base.BaseDAOImpl;
import com.gsh.dao.OrgDao;
import com.gsh.model.Org;
/**
 * 
*<p>Title:OrgDaoImpl </p>
*<p>Description: </p>
*<p>Company: </p> 
*@author gdd
*@date 2016-12-30 下午3:49:26
 */
public class OrgDaoImpl extends BaseDAOImpl<Org> implements OrgDao{

	public List<Org> findList(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Org> getChildren(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

//	public List<Org> findList(String id) throws Exception {
//		Connection conn = DBUtils.createConn();
//		String sql = "";
//		if("".equals(id) || id == null){
//			sql = "select * from org where parent_id = 0";
//		} else {
//			sql = "select * from org where parent_id = " + id ;
//		}
//		PreparedStatement ps = DBUtils.getPs(conn, sql);
//		ResultSet rs = ps.executeQuery();
//		
//		List<Org> rlist = new ArrayList<Org>();
//		while(rs.next()){
//			Org org = new Org();
//			org.setId(rs.getInt("id"));
//			org.setIconCls(rs.getString("iconCls")); 
//			org.setName(rs.getString("name"));
//			org.setPrincipal(rs.getString("principal"));
//			org.setCount(rs.getInt("count"));
//			org.setParent_id(rs.getInt("parent_id"));
//			org.setDescription(rs.getString("description"));
//			if(getChildren(org.getId()).size() >0){
//				org.setState("closed");
//			}
//			rlist.add(org);
//		}
//		return rlist;
//	}
//	
//	
//	public List<Org> getChildren(int id) throws Exception{
//		
//		Connection conn = DBUtils.createConn();
//		String sql = "";
//			sql = "select * from org where parent_id = " + id ;
//		PreparedStatement ps = DBUtils.getPs(conn, sql);
//		ResultSet rs = ps.executeQuery();
//		
//		List<Org> rlist = new ArrayList<Org>();	
//		while(rs.next()){
//			Org org = new Org();
//			org.setId(rs.getInt("id"));
//			org.setIconCls(rs.getString("iconCls")); 
//			org.setName(rs.getString("name"));
//			org.setPrincipal(rs.getString("principal"));
//			org.setCount(rs.getInt("count"));
//			org.setParent_id(rs.getInt("parent_id"));
//			org.setDescription(rs.getString("description"));
//			rlist.add(org);
//		}		
//		return rlist;
//	}
//	
//	
//	
//	
//	

}
