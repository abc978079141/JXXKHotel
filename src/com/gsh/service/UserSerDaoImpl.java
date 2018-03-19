package com.gsh.service;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gsh.dao.UserDao;
import com.gsh.model.User;
/**
 * 
*<p>Title:UserSerDaoImpl </p>
*<p style="color:red;">Description: 员工管理扩展接口实现类 </p>
*<p>Company: jxxkhotel </p> 
*@author gdd
*@date 2016-12-30 下午4:26:48
 */
@Transactional
@Service("userSerDao")
public class UserSerDaoImpl extends BaseSerDaoImpl<User> implements UserSerDao {
	@Resource
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public User checklogin(String username, String password) {
		return null;
	}
	
}
