package com.gsh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gsh.dao.HotelUserDao;
import com.gsh.model.Hotel;
import com.gsh.model.Role;
import com.gsh.model.User;
import com.gsh.model.UserRole;
import com.gsh.service.UserRoleSerDao;
import com.gsh.service.UserSerDao;

/**
*<p>Title:LoginControl </p>
*<p style="color:red;">Description: 登录控制类 </p>
*<p>Company: jxxkhotel </p> 
*@author gdd
*@date 2016-12-30 下午4:23:14
*/
@Controller
@RequestMapping("login")
public class LoginControl {
	private UserSerDao userSerDao;
	private HotelUserDao hotelUserDao;
	private UserRoleSerDao userRoleSerDao;
	
	@javax.annotation.Resource
	public void setUserSerDao(UserSerDao userSerDao) {
		this.userSerDao = userSerDao;
	}
	
	@javax.annotation.Resource
	public void setHotelUserDao(HotelUserDao hotelUserDao) {
		this.hotelUserDao = hotelUserDao;
	}
	

	@javax.annotation.Resource
	public void setUserRoleSerDao(UserRoleSerDao userRoleSerDao) {
		this.userRoleSerDao = userRoleSerDao;
	}
	/**
	 * 
	*Description:<p style="color:red"> 登录验证</p>
	*@param user
	*@param request
	*@return
	 * @throws Exception 
	 */
	@RequestMapping("/login.do")
	@ResponseBody
	public Map<String, String> login(User u,HttpSession session) throws Exception{
		System.out.println("----------------------------jrebel Test----------------------");
		Map<String, String> map=new HashMap<String, String>();
		List<User> ulist=userSerDao.find(u);
		if(ulist.size()!=0){
			User user=ulist.get(0);
			//查询特定列
			//Role role=userRoleSerDao.find(" from UserRole as ur where ur.user = ? ", new Object[]{user}).get(0).getRole();
			Role role=user.getUserRole().getRole();
			/*set iterator 循环
			 * Iterator<RoleResource> iterator=resset.iterator();
			while(iterator.hasNext()){
						resources.add((com.gsh.model.Resource) iterator.next().getResource());
						}
				for(com.gsh.model.Resource res :resources){
				System.out.println("res"+res.getName());
				}*/
			Hotel hotel=user.getHotelUser().getHotel();
			session.setAttribute("User", user);
			session.setAttribute("uid", user.getId());
			session.setAttribute("username", user.getUsername());
			session.setAttribute("userpass", user.getPassword());
			session.setAttribute("roleid", role.getRoleid());
			session.setAttribute("role", role);
			session.setAttribute("hid", hotel.getHid());
			session.setAttribute("hotelname", hotel.getHname());
			session.setAttribute("hotelnum", hotel.getHnum());
			if(role.getRolename().equals("注册用户"))
				map.put("msg", "jump/manager/main.do");
			else if(role.getRolename().equals("酒店前台"))
				map.put("msg", "jump/reception/main.do");
		}
		else 
			 map.put("msg", "error") ; 
		return map;
	}
	/**
	 * 
	 *<p>Description: 安全退出</p>
	 * @return
	 */
	@RequestMapping("loginout.do")
	public String loginout(HttpSession session){
		session.invalidate();
		return "redirect:../index.jsp";
	}
	
	

}
