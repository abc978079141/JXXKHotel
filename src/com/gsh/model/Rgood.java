package com.gsh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Rgood entity. @author MyEclipse Persistence Tools
 * 客房服务商品
 */
@Entity
@Table(name = "rgood", catalog = "jxxkhotel")
public class Rgood implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String spjm;//商品简码
	private String spname;//商品名称
	private Double spprice;//商品价格
	private Integer amount;//数量
	private String sptype;//商品类别
	private String remark;//备注

	// Constructors

	/** default constructor */
	public Rgood() {
	}

	/** minimal constructor */
	public Rgood(String spjm) {
		this.spjm = spjm;
	}

	/** full constructor */
	public Rgood(String spjm, String spname, Double spprice, Integer amount,
			String sptype, String remark) {
		this.spjm = spjm;
		this.spname = spname;
		this.spprice = spprice;
		this.amount = amount;
		this.sptype = sptype;
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

	@Column(name = "spjm", nullable = false)
	public String getSpjm() {
		return this.spjm;
	}

	public void setSpjm(String spjm) {
		this.spjm = spjm;
	}

	@Column(name = "spname")
	public String getSpname() {
		return this.spname;
	}

	public void setSpname(String spname) {
		this.spname = spname;
	}

	@Column(name = "spprice", precision = 255, scale = 0)
	public Double getSpprice() {
		return this.spprice;
	}

	public void setSpprice(Double spprice) {
		this.spprice = spprice;
	}

	@Column(name = "amount")
	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Column(name = "sptype")
	public String getSptype() {
		return this.sptype;
	}

	public void setSptype(String sptype) {
		this.sptype = sptype;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}