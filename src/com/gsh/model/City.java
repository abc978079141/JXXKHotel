package com.gsh.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * City entity. @author MyEclipse Persistence Tools
 */
/**
 * 
*<p>Title:City </p>
*<p style="color:red;">Description: </p>
*<p>Company: jxxkhotel </p> 
*@author gdd
*@date 2016-12-30 下午4:29:27
 */
@Entity
@Table(name = "city", catalog = "jxxkhotel")
@JsonIgnoreProperties(value={"users","hibernateLazyInitializer","handler","fieldHandler"})
public class City implements java.io.Serializable {

	/**
	 * 
	 */
	// Fields
	private Integer id;
	private Province province;
	private String name;
	private Set<User> users = new HashSet<User>(0);

	// Constructors

	/** default constructor */
	public City() {
	}
	
	
	
	/** full constructor */
	public City(Province province, String name, Set<User> users) {
		this.province = province;
		this.name = name;
		this.users = users;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pro_id")
	public Province getProvince() {
		return this.province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "city")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}