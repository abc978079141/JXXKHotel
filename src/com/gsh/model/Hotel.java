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
 * Hotel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "hotel", catalog = "jxxkhotel")
@JsonIgnoreProperties(value={"hotelUsers","hibernateLazyInitializer","handler","fieldHandler"})
public class Hotel implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer hid;
	private String hname;//酒店名称
	private Integer hlevel;//酒店等级
	private String hchargetel;//酒店注册人手机
	private String hadress;//酒店地址
	private Integer haskid;//是否有设置分店权限
	private String hnum;//酒店编号
	private String remark;//备注
	private Set<HotelUser> hotelUsers = new HashSet<HotelUser>(0);
	
	// Constructors

	/** default constructor */
	public Hotel() {
	}

	/** minimal constructor */
	public Hotel(String hname, Integer hlevel, String hchargetel,
			String hadress, String remark) {
		this.hname = hname;
		this.hlevel = hlevel;
		this.hchargetel = hchargetel;
		this.hadress = hadress;
		this.remark = remark;
	}

	/** full constructor */
	public Hotel(String hname, Integer hlevel, String hchargetel,
			String hadress, String remark, Set<HotelUser> hotelUsers) {
		this.hname = hname;
		this.hlevel = hlevel;
		this.hchargetel = hchargetel;
		this.hadress = hadress;
		this.remark = remark;
		this.hotelUsers = hotelUsers;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "hid", unique = true, nullable = false)
	public Integer getHid() {
		return this.hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	@Column(name = "hname", nullable = false)
	public String getHname() {
		return this.hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	@Column(name = "hlevel", nullable = false)
	public Integer getHlevel() {
		return this.hlevel;
	}

	public void setHlevel(Integer hlevel) {
		this.hlevel = hlevel;
	}

	@Column(name = "hchargetel", nullable = false)
	public String getHchargetel() {
		return this.hchargetel;
	}

	public void setHchargetel(String hchargetel) {
		this.hchargetel = hchargetel;
	}

	@Column(name = "hadress", nullable = false)
	public String getHadress() {
		return this.hadress;
	}

	public void setHadress(String hadress) {
		this.hadress = hadress;
	}

	@Column(name = "remark", nullable = false)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "haskid", nullable = false)
	public Integer getHaskid() {
		return haskid;
	}

	public void setHaskid(Integer haskid) {
		this.haskid = haskid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hotel")
	public Set<HotelUser> getHotelUsers() {
		return this.hotelUsers;
	}

	public void setHotelUsers(Set<HotelUser> hotelUsers) {
		this.hotelUsers = hotelUsers;
	}
	
	@Column(name = "hnum", nullable = false)
	public String getHnum() {
		return hnum;
	}
	public void setHnum(String hnum) {
		this.hnum = hnum;
	}
	
	

}