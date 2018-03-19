package com.gsh.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsh.model.City;
import com.gsh.model.Hotel;
import com.gsh.model.HotelUser;
import com.gsh.model.PageInfo;
import com.gsh.model.Role;
import com.gsh.model.User;
import com.gsh.model.UserRole;
import com.gsh.service.HotelUserSerDao;
import com.gsh.service.RoleSerDao;
import com.gsh.service.RoleSerDaoImpl;
import com.gsh.service.UserRoleSerDao;
import com.gsh.service.UserSerDao;
import com.gsh.util.DateUtil;


/**
*<p>Title:UserControl </p>
*<p>Description: 员工管理模块</p>
*<p>Company: </p> 
*@author gdd
*@date 2016-12-30 下午3:25:09
*/
@Controller
@RequestMapping("user")
public class UserControl {
	private UserRoleSerDao userRoleSerDao;
	private UserSerDao userSerDao;
	private RoleSerDao roleSerDao;
	private HotelUserSerDao hotelUserSerDao;
	@Resource
	public void setUserSerDao(UserSerDao userSerDao) {
		this.userSerDao = userSerDao;
	}
	
	@Resource
	public void setUserRoleSerDao(UserRoleSerDao userRoleSerDao) {
		this.userRoleSerDao = userRoleSerDao;
	}
	
	
	@Resource
	public void setHotelUserSerDao(HotelUserSerDao hotelUserSerDao) {
		this.hotelUserSerDao = hotelUserSerDao;
	}

	/**
	 * 获取城市数据
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
//	public List<City> getCity() {
//		System.out.println("getCity");
//			List<City> clist = new ArrayList<City>();
//			clist.add(new City(1, "北京", 0));
//			clist.add(new City(2, "上海", 0));
//			clist.add(new City(3, "深圳", 0));
//			clist.add(new City(4, "长春", 0));
//		return clist;
//	}
	@Resource
	public void setRoleSerDao(RoleSerDao roleSerDao) {
		this.roleSerDao = roleSerDao;
	}

	/**
	 * 用户保存
	 * @param u
	 * @return
	 */
	@RequestMapping("/save.do")
	public Map<String,String> save(User u,int roleid,HttpSession session) {
		u.setHid(Integer.parseInt(session.getAttribute("hid").toString()));
		City c=new City();
		c.setId(11);
		u.setCity(c);
		this.userSerDao.save(u);
		User saveu=userSerDao.find(u).get(0);
		UserRole userrole=new UserRole();
		Role role=new Role();
		role.setRoleid(roleid);
		userrole.setRole(role);
		userrole.setUser(saveu);
		userRoleSerDao.save(userrole);
		System.out.println("save user roleid="+roleid);
		Map<String, String> map=new HashMap<String, String>();	
			map.put("status", "ok");
			map.put("message", "操作成功");
			return map;
	}
	/**
	 * 用户注册
	 * @param u
	 * @return
	 */
	@RequestMapping("/reg.do")
	@ResponseBody
	public Map<String, String> reg(User u){
		Map<String, String> map=new HashMap<String, String>();	
		u.setHid(0);
		u.setStarttime(DateUtil.getDay());
		u.setEndtime(DateUtil.getAfterDayDate("7"));
		this.userSerDao.save(u);
		User saveu=userSerDao.find(u).get(0);
		Role role=new Role();
		role.setRoleid(2);
		UserRole userrole=new UserRole();
		userrole.setRole(role);
		userrole.setUser(saveu);
		userRoleSerDao.save(userrole);
		Hotel h=new Hotel();
		h.setHid(1);
		HotelUser hu=new HotelUser();
		hu.setHotel(h);
		hu.setUser(saveu);
		hotelUserSerDao.save(hu);
		map.put("status", "ok");
		map.put("message", "操作成功");
		return map;
	}
 
	/**
	 * 得到用户信息列表
	 * @param p
	 * @param u
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/getlist.do")
	@ResponseBody
	public Map<String , Object> getList(PageInfo p, User u,HttpSession session) throws Exception {
			System.out.println("user getlist.do ....");
			//String order1 = order == null ? "" : order; // 排序的方式
			//String sort1 = sort == null ? "" : sort;
			Map<String, Object> map= new HashMap<String, Object>();
			//m1.put("order", order1);
			//m1.put("sort", sort1);
			u.setHid(Integer.parseInt(session.getAttribute("hid").toString()));
			if(null==p.getPage())
				p.setPage(1);
			if(null==p.getRows())
				p.setRows(10);
			List<User> ulist = userSerDao.findcri(u,p.getPage(),p.getRows());
			map.put("total", ulist.size());
			map.put("rows", ulist);
			return map;
	}
	

	/**
	 * 根据城市id号 获取指定城市对象
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public City getCityName(String id) {
//			System.out.println("getCityName");
//			List<City> clist = new ArrayList<City>();
//			clist.add(new City(1, "北京", 0));
//			clist.add(new City(2, "上海", 0));
//			clist.add(new City(3, "深圳", 0));
//			clist.add(new City(4, "长春", 0));
//			System.out.println("getCityName()中ID="+id);
//			int id1=Integer.parseInt(id);
//			for (Iterator iterator = clist.iterator(); iterator.hasNext();) {
//				City city = (City) iterator.next();
//				if (city.getId() == id1) {
//					return city;
//				}
//			}
		return null;
	}

	/**
	 * 修改用户
	 * @param u
	 * @return
	 */
	@RequestMapping("/update.do")
	@ResponseBody
	public String update(User u,String cityname,Integer roleid,HttpSession session) {
		if(roleid!=null){
			UserRole ur=userRoleSerDao.find("from UserRole as ur where ur.user.id="+u.getId()).get(0);
			Role r=new Role();
			r.setRoleid(roleid);
			ur.setRole(r);
			userRoleSerDao.update(ur);
		}
		u.setHid(Integer.parseInt(session.getAttribute("hid").toString()));
		City c=new City();
		c.setId(1);
		u.setCity(c);
		userSerDao.update(u);
		return  "{\"status\":\"提示\" , \"message\":\"操作成功!\"}";
	}

	/**
	 * 删除用户
	 * @param ids：用户id数组
	 * @return
	 */
	@RequestMapping("/delete.do")
	@ResponseBody
	public String delete(String[] ids) {
		System.out.println("user delete.do ....");
			for (int i = 0; i < ids.length; i++) {
				User u=new User(Integer.parseInt(ids[i]));
				userSerDao.delete(u);
			}
		return null;
	}

	/**
	 * 用户名搜索
	 * @return
	 */
	public Object searchName() {
		System.out.println("user searchName ....");
//		try {
//			HttpServletRequest request = ServletActionContext.getRequest();
//			String q = request.getParameter("q") == null ? "" : request
//					.getParameter("q");
//			List<User> ulist = this.udao.searchByName(q.trim());
//			json = JSONArray.fromObject(ulist).toString();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return null;
	}
	@RequestMapping("/checkname.do")
	@ResponseBody
	public Map<String, String> checkname(String username){
		System.out.println("username="+username);
		Map<String, String> map=new HashMap<String, String>();
		int num= userSerDao.find("from User as u where u.username ="+"'"+username+"'").size();
		System.out.println("num="+num);
		if(num==0)
			map.put("msg", "ok");
		else 
			map.put("msg", "no");
		return map;
	}
	
	/**
	 * 
	 *<p>Description: 获得所有角色</p>
	 * @param session
	 * @return
	 */
	@RequestMapping("/getRole.do")
	@ResponseBody
	public List<Map<String,Object>> getrole(HttpSession session){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		List<Role> rlist=roleSerDao.find("from Role as r where r.hid ="+Integer.parseInt(session.getAttribute("hid").toString()));
		for (int i = 0; i < rlist.size(); i++) {
			Map<String, Object> map=new HashMap<String, Object>();
				Role role =rlist.get(i);
				map.put("roleid", role.getRoleid());
				map.put("rolename", role.getRolename());
				list.add(map);
				System.out.println(list.get(i));
			}
		return list;
		}
	
}
