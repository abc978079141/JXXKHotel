package com.gsh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Balance entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "balance", catalog = "jxxkhotel")
public class Balance implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer hid;
	private String ordernum;//订单号
	private String handnum;//手工单号
	private String billtime;//结算时间
	private Double totalmoney;//总价
	private Double mcash;//现金
	private Double mother;//其他支付
	private String bookkeeper;//操作员
	private String remark;//备注
	

	// Constructors

	/** default constructor */
	public Balance() {
	}

	/** full constructor */
	public Balance(String ordernum, String handnum, String billtime,
			Double totalmoney, Double mcash, Double mother, String bookkeeper,
			String remark) {
		this.ordernum = ordernum;
		this.handnum = handnum;
		this.billtime = billtime;
		this.totalmoney = totalmoney;
		this.mcash = mcash;
		this.mother = mother;
		this.bookkeeper = bookkeeper;
		this.remark = remark;
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
	
	
	@Column(name = "hid")
	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	@Column(name = "ordernum")
	public String getOrdernum() {
		return this.ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	@Column(name = "handnum")
	public String getHandnum() {
		return this.handnum;
	}

	public void setHandnum(String handnum) {
		this.handnum = handnum;
	}

	@Column(name = "billtime")
	public String getBilltime() {
		return this.billtime;
	}

	public void setBilltime(String billtime) {
		this.billtime = billtime;
	}

	@Column(name = "totalmoney", precision = 22, scale = 0)
	public Double getTotalmoney() {
		return this.totalmoney;
	}

	public void setTotalmoney(Double totalmoney) {
		this.totalmoney = totalmoney;
	}

	@Column(name = "mcash", precision = 22, scale = 0)
	public Double getMcash() {
		return this.mcash;
	}

	public void setMcash(Double mcash) {
		this.mcash = mcash;
	}

	@Column(name = "mother", precision = 22, scale = 0)
	public Double getMother() {
		return this.mother;
	}

	public void setMother(Double mother) {
		this.mother = mother;
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

}