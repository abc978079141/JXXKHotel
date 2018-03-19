package com.gsh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Badcord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "badcord", catalog = "jxxkhotel")
public class Badcord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer hid;
	private String cordnum;//记录单号
	private String memnum;//会员卡号
	private String cordname;//记录人姓名
	private String cordtype;//记录类型
	private String cordtime;//记录时间
	private String tel;//记录人电话
	private String bookkeeper;//操作员
	private String remark;//详情

	// Constructors

	/** default constructor */
	public Badcord() {
	}

	/** minimal constructor */
	public Badcord(String cordtype) {
		this.cordtype = cordtype;
	}

	/** full constructor */
	public Badcord(Integer hid,String cordnum, String memnum, String cordname,
			String cordtype, String tel, String bookkeeper, String remark,String cordtime) {
		this.hid=hid;
		this.cordnum = cordnum;
		this.memnum = memnum;
		this.cordname = cordname;
		this.cordtype = cordtype;
		this.tel = tel;
		this.bookkeeper = bookkeeper;
		this.remark = remark;
		this.cordtime=cordtime;
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

	@Column(name = "cordnum", length = 50)
	public String getCordnum() {
		return this.cordnum;
	}

	public void setCordnum(String cordnum) {
		this.cordnum = cordnum;
	}

	@Column(name = "memnum", length = 50)
	public String getMemnum() {
		return this.memnum;
	}

	public void setMemnum(String memnum) {
		this.memnum = memnum;
	}

	@Column(name = "cordname", length = 50)
	public String getCordname() {
		return this.cordname;
	}

	public void setCordname(String cordname) {
		this.cordname = cordname;
	}

	@Column(name = "cordtype", length = 11)
	public String getCordtype() {
		return this.cordtype;
	}

	public void setCordtype(String cordtype) {
		this.cordtype = cordtype;
	}

	@Column(name = "tel", length = 20)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "bookkeeper", length = 20)
	public String getBookkeeper() {
		return this.bookkeeper;
	}

	public void setBookkeeper(String bookkeeper) {
		this.bookkeeper = bookkeeper;
	}

	@Column(name = "remark", length = 50)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name = "cordtime", length = 50)
	public String getCordtime() {
		return cordtime;
	}

	public void setCordtime(String cordtime) {
		this.cordtime = cordtime;
	}
	
	@Column(name = "hid", length = 11)
	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}
	
	

}