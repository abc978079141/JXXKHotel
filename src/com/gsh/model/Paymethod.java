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
 * Paymethod entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "paymethod", catalog = "jxxkhotel")
@JsonIgnoreProperties(value={"roomConLists","hibernateLazyInitializer","handler","fieldHandler"})
public class Paymethod implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;//支付方式名称
	private Set<RoomConList> roomConLists = new HashSet<RoomConList>(0);//房间消费清单

	// Constructors

	/** default constructor */
	public Paymethod() {
	}

	/** minimal constructor */
	public Paymethod(String name) {
		this.name = name;
	}

	/** full constructor */
	public Paymethod(String name, Set<RoomConList> roomConLists) {
		this.name = name;
		this.roomConLists = roomConLists;
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

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "paymethod")
	public Set<RoomConList> getRoomConLists() {
		return this.roomConLists;
	}

	public void setRoomConLists(Set<RoomConList> roomConLists) {
		this.roomConLists = roomConLists;
	}

}