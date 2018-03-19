package com.gsh.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsh.dto.TreeDTO;
import com.gsh.model.Resource;
import com.gsh.model.Role;
import com.gsh.model.RoleResource;
import com.gsh.service.ResourceSerDao;
import com.gsh.service.RoleResSerDao;
import com.gsh.service.RoleSerDao;
import com.gsh.service.UserRoleSerDao;
import com.gsh.service.UserSerDao;

/**
 * 
 *<p>Title:ResourceControl</p>
 *<p>Description:菜单操作控制层</p>
 *<p>Company:GSH</p>
 * @author gdd
 * @date:2017-3-22 下午8:06:41
 */
@Controller
@RequestMapping("resource")
public class ResourceControl {
	private ResourceSerDao resourceSerDao;
	private UserSerDao userSerDao;
	private RoleSerDao roleSerDao;
	private RoleResSerDao roleResSerDao;
	private UserRoleSerDao userRoleSerDao;

	@javax.annotation.Resource
	public void setResourceSerDao(ResourceSerDao resourceSerDao) {
		this.resourceSerDao = resourceSerDao;
	}
	
	@javax.annotation.Resource
	public void setUserSerDao(UserSerDao userSerDao) {
		this.userSerDao = userSerDao;
	}
	
	@javax.annotation.Resource
	public void setRoleSerDao(RoleSerDao roleSerDao) {
		this.roleSerDao = roleSerDao;
	}
	
	@javax.annotation.Resource
	public void setRoleResSerDao(RoleResSerDao roleResSerDao) {
		this.roleResSerDao = roleResSerDao;
	}
	
	@javax.annotation.Resource
	public void setUserRoleSerDao(UserRoleSerDao userRoleSerDao) {
		this.userRoleSerDao = userRoleSerDao;
	}

	/**
	 * 根据每个人的权限生成动态菜单
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMenu.do")
	@ResponseBody
	public List<TreeDTO> getMenu(HttpSession session) throws Exception{
		List<TreeDTO> treeList=getMenu(getResByUid(Integer.parseInt(session.getAttribute("uid").toString()),session),null);
		return treeList;
	}
	

	/**
	 * 用户授权
	 * @param uid 用户id
	 * @return 树形菜单list
	 * @throws Exception 
	 */
	@RequestMapping("/ushouquan.do")
	@ResponseBody
	public List<TreeDTO> ushouquan(HttpSession session,String act,int roleid) throws Exception{
		//int uid =Integer.parseInt(session.getAttribute("uid").toString());
		//声明树菜单格式list
		List<TreeDTO> treelist=new ArrayList<TreeDTO>();
		//获得所有系统权限
		List<Resource> reslist=resourceSerDao.find("from Resource ");
		//根据role的权限
		List<Resource> ureslist=getResByRoleid(roleid);
		//得到所拥有的权限id的数组
		int ids[]=new int[ureslist.size()];
		if(act.equals("")){
			for(int i=0;i<ureslist.size();i++){
				ids[i]=((Resource)ureslist.get(i)).getId();
			}
		}
			treelist=getMenu(reslist,ids);
		
		return treelist;
	}
	/**
	 * 保存权限
	 * @param arry 前台权限id数组
	 * @param roleid 角色ID
	 * @return json提示信息
	 * @throws Exception 
	 */
	@RequestMapping("/saveupdate.do")
	@ResponseBody
	public Map<String, Object> saveupdate(int roleid,int arry[],HttpSession session) throws Exception{
		Map<String, Object> map=new HashMap<String, Object>();
		int hid=Integer.parseInt(session.getAttribute("hid").toString());
		RoleResource roleres=new RoleResource();
		Role role=new Role();
		role.setRoleid(roleid);
		roleres.setRole(role);
		List<RoleResource> rolereslist=roleResSerDao.find("from RoleResource as rr where rr.role.roleid="+roleid);
		roleResSerDao.deleteall(rolereslist);
		for(int resid:arry){
			RoleResource roleres2=new RoleResource();
			Role role2=new Role();
			Resource res=new Resource();
			//根据角色roleid改变
			role2.setRoleid(roleid);
			res.setId(resid);
			roleres2.setRole(role2);
			roleres2.setResource(res);
			roleres2.setHid(hid);
			roleResSerDao.save(roleres2);
		}
		map.put("msg", "yes");
		return map;
	}

	/**
	 * 根据用户id查询所有权限
	 * @param uid 用户id
	 * @return 拥有的权限list
	 */
	public List<Resource> getResByUid(int uid,HttpSession session){
		//获得角色id
		int roleid=Integer.parseInt(session.getAttribute("roleid").toString());
		return getResByRoleid(roleid);
	}
	/**
	 * 根据角色roleid查询所有权限
	 * @param roleid
	 * @return
	 */
	public List<Resource> getResByRoleid(int roleid){
		List<Resource>	reslist=new ArrayList<Resource>();
		//获得角色
		Role role=roleSerDao.get(Role.class, roleid);
		//声明角色权限set
		Set<RoleResource> resset=role.getRoleResources();
		//遍历角色权限set
		for (Iterator iterator = resset.iterator(); iterator.hasNext();) {
			//声明单个角色权限实体
			RoleResource resource = (RoleResource)iterator.next();
			//讲角色权限里的权限添加进权限list
			reslist.add(resource.getResource());
		}
		return reslist;
	}
	

	/**
	 * 菜单实体赋值给treeDTO
	 * @param resource 菜单实体类
	 * @param resids 是否为授权操作，是则不为null，否则为null
	 * @return
	 */
	public TreeDTO setTree(Resource resource,int resids[]){
		Map<String, Object> attrs=new HashMap<String, Object>();
		TreeDTO treeDTO=new TreeDTO();
		//树菜单id
		treeDTO.setId(resource.getId());
		treeDTO.setParent_id(1);
		//树菜单文字
		treeDTO.setText(resource.getName());
		//状态（是否为父节点）
		if(resource.getParentId()==1)
			treeDTO.setState("closed");
		
		//url设置
		if(!("").equals(resource.getUrl())&&null!=resource.getUrl()){
			Object o=resource.getUrl();
			attrs.put("url", o);
			treeDTO.setAttributes(attrs);
		}
		//图标设置
		if(!"".equals(resource.getIcon())&&null!=resource.getIcon()){
			treeDTO.setIconCls(resource.getIcon());
			}
		//checkbox是否选中
		if(null!=resids&&!"".equals(resids)){
			treeDTO.setState("open");
			for(int resid:resids){
				if(resid==resource.getId()){
					if(resource.getParentId()!=1){
						treeDTO.setChecked(1);
					}
					else continue;
				}
			}
		}
		return treeDTO;
	}
	
	/**
	 * 拼接菜单
	 * @param resources 数据库查询的菜单集合 list
	 * @return 拼接好的前台树形菜单集合 treelist
	 * @throws Exception 
	 */
	public List<TreeDTO> getMenu(List<Resource> resources,int resids[]) throws Exception{
		List<TreeDTO> treelist=new ArrayList<TreeDTO>();
		//循环resources集合
		for(int i=0;i<resources.size();i++){
			//声明TreeDTO类型变量treeDTO
			TreeDTO treeDTO=new TreeDTO();
			//获得当期循环的菜单实体resource
			Resource resource=resources.get(i);
			//判断是否为一级菜单
			if(resource.getParentId()==1){
				//是，则直接将相应的值赋值给treeDTO
				treeDTO=setTree(resource,resids);
				//查询获得子菜单集合
				List<Resource>	creslist=resourceSerDao.getChildren(resource.getId());
				//声明树形菜单子菜单集合
				List<TreeDTO> kidreslist=new ArrayList<TreeDTO>();
				//声明树形菜单（子菜单）
				TreeDTO children=new TreeDTO();
				//循环查询数据库的子菜单集合
				for(Resource creres:creslist){
					//如果全部菜单中包含子菜单
					if(resources.contains(creres)){
						//子菜单添加进父菜单
						children=setTree(creres,resids);
						kidreslist.add(children);
						treeDTO.setChildren(kidreslist);
					}
				}
			}
			else{
				continue;
			}
			treelist.add(treeDTO);
		}	
		return treelist;
	}
	
	
	/**
	 * 
	 *<p>Description:获得职务列表 </p>
	 * @param r 前台查询条件 
	 * @return json 提示信息
	 * @throws Exception 
	 */
	@RequestMapping("/getRoles.do")
	@ResponseBody
	public Map<String , Object> getRoles(Role r,HttpSession session) throws Exception{
		Map<String , Object> map=new HashMap<String , Object>();
		List<Role> rolelist=new ArrayList<Role>();
		if("".equals(r.getRolename()))
			r.setRolename(null);
		if("".equals(r.getRolecode()))
			r.setRolecode(null);
		r.setHid(Integer.parseInt(session.getAttribute("hid").toString()));
		rolelist=roleSerDao.findcri(r,1,10);
		map.put("total", rolelist.size());
		map.put("rows", rolelist);
		return  map;
	}
	
	
	/**
	 * 
	 *<p>Description: 职务修改 </p>
	 * @param r 角色实例对象
	 * @return 
	 */
	@RequestMapping("/updateRole.do")
	@ResponseBody
	public Map<String, String> updateRole(Role r,HttpSession session){
		Map<String, String> map=new HashMap<String, String>();
		r.setHid(Integer.parseInt(session.getAttribute("hid").toString()));
			
		if(null==r.getRoleid())
			roleSerDao.save(r);
		else
			roleSerDao.update(r);
		map.put("status", "成功");
		map.put("msg", "修改成功");
		return  map;
	}
	
	/**
	 * 
	 *<p>Description:删除职务</p>
	 * @param r 
	 * @param session
	 * @return
	 */
	@RequestMapping("/deleteRole.do")
	@ResponseBody
	public Map<String, String> deleteRole(int roleid,HttpSession session){
		Map<String, String> map=new HashMap<String, String>();
		Role r=roleSerDao.get(Role.class, roleid);
		roleSerDao.delete(r);
		map.put("status", "成功");
		map.put("msg", "修改成功");
		return  map;
	}
	
}
