package com.gsh.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.gsh.base.BaseDAOImpl;
import com.gsh.dao.ProvinceDao;
import com.gsh.model.City;
import com.gsh.model.Province;
/**
 * 
*<p>Title:ProvinceDaoImpl </p>
*<p>Description: </p>
*<p>Company: </p> 
*@author gdd
*@date 2016-12-30 下午3:49:22
 */
@Repository("provinceDao")
public class ProvinceDaoImpl extends BaseDAOImpl<Province> implements ProvinceDao{

	public List<City> findCitiesByProId(int parseInt) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

//	public List<City> findCitiesByProId(int pid) throws Exception {
//		Connection conn = DBUtils.createConn();
//		String sql = "select * from city where pro_id =" +pid;
//		PreparedStatement ps = DBUtils.getPs(conn, sql);
//		ResultSet rs = ps.executeQuery();
//		List<City> clist = new ArrayList<City>();
//		while(rs.next()){
//			City c =new City();
//			c.setId(rs.getInt("id"));
//			c.setName(rs.getString("name"));
//			c.setPro_id(rs.getInt("pro_id"));
//			clist.add(c);
//		}
//		
//		return clist;
//	}


	
}
