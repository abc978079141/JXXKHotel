package com.gsh.service;

import com.gsh.model.User;
/**
 * 
*<p>Title:UserSerDao </p>
*<p style="color:red;">Description:员工操作扩展接口 </p>
*<p>Company: jxxkhotel </p> 
*@author gdd
*@date 2016-12-30 下午4:26:30
 */
public interface UserSerDao extends BaseSerDao<User> {
		public User checklogin(String username,String password);
}
