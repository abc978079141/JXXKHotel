package com.gsh.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.servlet.http.HttpSession;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "role", catalog = "jxxkhotel")
@JsonIgnoreProperties(value={"roleResources","userRoles","hibernateLazyInitializer","handler","fieldHandler"})
public class Role implements java.io.Serializable {

	/**
	 * 
	 */
	// Fields
	private HttpSession session;
	private Integer roleid;
	private String rolename;//角色名称
	private Integer rolestate;
	private String rolecode;//角色名称
	private Integer hid;//酒店id
	private String roledesc;//角色描述
	private Set<RoleResource> roleResources = new HashSet<RoleResource>(0);//角色资源

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** full constructor */
	public Role(String rolename, String roledesc,
			Set<RoleResource> roleResources) {
		this.rolename = rolename;
		this.roledesc = roledesc;
		this.roleResources = roleResources;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "roleid", unique = true, nullable = false)
	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	@Column(name = "rolename")
	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@Column(name = "roledesc")
	public String getRoledesc() {
		return this.roledesc;
	}

	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}

	@SuppressWarnings("deprecation")
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "role")
	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)   
	public Set<RoleResource> getRoleResources() {
		return this.roleResources;
	}

	public void setRoleResources(Set<RoleResource> roleResources) {
		this.roleResources = roleResources;
	}
	
	@Column(name = "rolestate")
	public Integer getRolestate() {
		return rolestate;
	}

	public void setRolestate(Integer rolestate) {
		this.rolestate = rolestate;
	}
	@Column(name = "rolecode")
	public String getRolecode() {
		return rolecode;
	}

	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}
	
	@Column(name = "hid")
	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
			this.hid=hid;
	}
	
	



}