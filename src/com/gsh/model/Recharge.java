package com.gsh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

/**
 * Recharge entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "recharge", catalog = "jxxkhotel")
public class Recharge implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private Integer id;
	private String recnum;//充值单号
	private String memnum;//会员卡号
	private Paymethod paymethod;//支付方式
	private Double recmoney;//充值金额
	private String rectime;//充值日期
	private String bookkeeper;//操作员
	private String remark;//备注
	private Integer hid;//酒店ID
	
	// Constructors

	/** default constructor */
	public Recharge() {
	}

	/** full constructor */
	public Recharge(Paymethod paymethod, String memnum, Double recmoney,
			String rectime, String bookkeeper, String remark,Integer hid) {
		this.paymethod = paymethod;
		this.memnum = memnum;
		this.recmoney = recmoney;
		this.rectime = rectime;
		this.bookkeeper = bookkeeper;
		this.remark = remark;
		this.hid=hid;
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
	@JoinColumn(name = "paymethod")
	public Paymethod getPaymethod() {
		return this.paymethod;
	}

	public void setPaymethod(Paymethod paymethod) {
		this.paymethod = paymethod;
	}

	@Column(name = "memnum")
	public String getMemnum() {
		return this.memnum;
	}

	public void setMemnum(String memnum) {
		this.memnum = memnum;
	}

	@Column(name = "recmoney", precision = 22, scale = 0)
	public Double getRecmoney() {
		return this.recmoney;
	}

	public void setRecmoney(Double recmoney) {
		this.recmoney = recmoney;
	}

	@Column(name = "rectime")
	public String getRectime() {
		return this.rectime;
	}

	public void setRectime(String rectime) {
		this.rectime = rectime;
	}

	@Column(name = "bookkeeper")
	public String getBookkeeper() {
		return this.bookkeeper;
	}

	public void setBookkeeper(String bookkeeper) {
		this.bookkeeper = bookkeeper;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "hid")
	public Integer getHid() {
		return hid;
	}
	
	public void setHid(Integer hid) {
		this.hid =hid ;
	}

	@Column(name = "recnum")
	public String getRecnum() {
		return recnum;
	}

	public void setRecnum(String recnum) {
		this.recnum = recnum;
	}
	
	
	
	

}