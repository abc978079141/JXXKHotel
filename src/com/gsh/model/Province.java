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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Province entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "province", catalog = "jxxkhotel")
@JsonIgnoreProperties(value={"cities","hibernateLazyInitializer","handler","fieldHandler"})
public class Province implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private Integer id;
	private String name;//省
	private Set<City> cities = new HashSet<City>(0);//市

	// Constructors

	/** default constructor */
	public Province() {
	}

	/** full constructor */
	public Province(String name, Set<City> cities) {
		this.name = name;
		this.cities = cities;
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

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "province")
	public Set<City> getCities() {
		return this.cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

}