package com.gsh.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * RoomType entity. @author MyEclipse Persistence Tools
 */
/**
 * 
*<p>Title:RoomType </p>
*<p>Description: </p>
*<p>Company: </p> 
*@author gdd
*@date 2016-12-30 下午3:57:39
 */
@Entity
@Table(name = "room_type", catalog = "jxxkhotel")
@DynamicInsert(true)
@DynamicUpdate(true)
@JsonIgnoreProperties(value={"rooms","hibernateLazyInitializer","handler","fieldHandler"})
public class RoomType implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private Integer id;
	private int hid;//酒店id
	private String typename;//房间类别名称
	private String typecode;//房型简码
	private Double roomprice;//房间价格
	private Double deposit;//押金
	private Double hourprice;//钟点房价格
	private Integer sprice;//特价价格
	private Integer state;
	private String remark;//备注
	private List<Room> rooms = new ArrayList<Room>();

	// Constructors

	/** default constructor */
	public RoomType() {
	}

	/** minimal constructor */
	public RoomType(Double hourprice) {
		this.hourprice = hourprice;
	}

	/** full constructor */
	public RoomType(String typename, String typecode, Double roomprice,
			Double deposit, Double hourprice, String remark,int sprice, List<Room> rooms) {
		this.typename = typename;
		this.typecode = typecode;
		this.roomprice = roomprice;
		this.deposit = deposit;
		this.hourprice = hourprice;
		this.remark = remark;
		this.rooms = rooms;
		this.sprice=sprice;
		
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

	@Column(name = "typename")
	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	@Column(name = "typecode")
	public String getTypecode() {
		return this.typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	@Column(name = "roomprice")
	public Double getRoomprice() {
		return this.roomprice;
	}

	public void setRoomprice(Double roomprice) {
		this.roomprice = roomprice;
	}

	@Column(name = "deposit")
	public Double getDeposit() {
		return this.deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}

	@Column(name = "hourprice")
	public Double getHourprice() {
		return this.hourprice;
	}

	public void setHourprice(Double hourprice) {
		this.hourprice = hourprice;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roomType")
	public List<Room> getRooms() {
		return this.rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	@Column(name = "state")
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "sprice")
	public Integer getSprice() {
		return sprice;
	}

	public void setSprice(Integer sprice) {
		this.sprice = sprice;
	}
	
	@Column(name = "hid")
	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}
	
	

}