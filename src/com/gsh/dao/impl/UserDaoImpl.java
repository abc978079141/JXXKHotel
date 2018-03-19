package com.gsh.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gsh.base.BaseDAOImpl;
import com.gsh.dao.UserDao;
import com.gsh.model.User;




/**
*<p>Title:UserDaoImpl </p>
*<p>Description: </p>
*<p>Company: </p> 
*@author gdd
*@date 2016-12-30 下午3:48:53
 */
@Transactional
@Repository("userDao")
public class UserDaoImpl extends BaseDAOImpl<User> implements UserDao {

	
	/**
	 * 分页查询列表信息 
	 */
	public List<User> findByPagination2(int currentPage, int pageSize  ,String[] m)
	{
		System.out.println("userdaoimpl中findByPagination loading");
		String hql = "from User  as u where u.startTime > ? and u.endTime < ? ";
		//sql = sql +" limit " + (currentPage-1)*pageSize +" , "  + pageSize ;
		System.out.println("UserDaoImpl中findByPagination的hql");
		return (List<User>) (this.find(hql,m));
	}
	
	/**
	 * 查询表中的所有记录数 
	 */
	public int getTotal(Map<String ,Object> m) throws Exception {
//		System.out.println("UserDaoImpl中getTotal loading...");
//		Connection conn = DBUtils.createConn();
//		String sql = " select count(*) from user  where 1=1 ";
//		
//		Set<Entry<String, Object>> set = m.entrySet();
//		Iterator io = set.iterator();
//		while (io.hasNext()) {
//			Map.Entry<String, Object> me = (Map.Entry<String, Object>) io.next();
//			if("username".equals(me.getKey()) && !"".equals(me.getValue())){
//				sql += " and " + me.getKey() + " like '%"+ me.getValue()  +"%'" ;
//			}
//			if("startTime".equals(me.getKey()) && !"".equals(me.getValue())){
//				sql += " and " + me.getKey() + " >= '" + me.getValue() +"'";
//			}
//			if("endTime".equals(me.getKey()) && !"".equals(me.getValue())){
//				sql += " and " + me.getKey() + " <= '" + me.getValue() +"'";
//			}
//			if("sort".equals(me.getKey()) && !"".equals(me.getValue())){
//				sql += " order by " + me.getValue();
//			}
//			if("order".equals(me.getKey()) && !"".equals(me.getValue())){
//				sql += " " + me.getValue();
//			}			
//		}		
//		PreparedStatement ps = DBUtils.getPs(conn, sql);
//		ResultSet rs = ps.executeQuery();		
//		int count = 0 ;
//		if(rs.next()){
//			count = rs.getInt(1);
//		}
//		System.out.println("UserDaoImpl中getTotal的hql");
//		System.out.println(sql);
//		return count;
		return 0;
	}

	
	
	/**
	 * 根据名字查询记录
	 */
	/*public List<User> searchByName(String q) throws Exception {
		Connection conn = DBUtils.createConn();
		String sql =" select * from user where username like '%" + q + "%'" ;
		PreparedStatement ps = DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<User> ulist = new ArrayList<User>();
		while(rs.next()){
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setAge(rs.getInt("age"));
			user.setBirthday(rs.getString("birthday"));
			user.setCity(rs.getInt("city"));
			user.setSalary(rs.getString("salary"));
			user.setSex(rs.getString("sex"));
			user.setStartTime(rs.getString("startTime"));
			user.setEndTime(rs.getString("endTime"));
			user.setDescription(rs.getString("description"));
			ulist.add(user);
		}		
		
		return ulist;
	}*/
	/**
	 * 根据用户民查询
	 */
	public List<User> searchByName(String q) throws Exception {
		System.out.println("UserDaoImpl中searchByName loading...");
		List<User> ulist = new ArrayList<User>();
		Object[] o = null;
		o[0]=q;
		String hql =" from User as u where u.username like '% ? %'" ;
		this.find(hql, o);
		System.out.println("ulist.size():"+ulist.size());
		return ulist;
	}



	
}
