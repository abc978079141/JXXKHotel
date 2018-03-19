package com.gsh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * Reserve entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "reserve", catalog = "jxxkhotel")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Reserve implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer hid;//酒店ID
	private String resnumber;//订单号
	private String memnum;//会员卡号
	private String roomnum;//房间号
	private String resname;//预订人姓名
	private String comname;//协议单位名称
	private String restel;//预订号码
	private String starttime;//预住日期
	private String endtime;//预留日期
	private String restime;//预订时间
	private String resstate;//订单状态
	private Integer ressource;//订单来源
	private String remark;//备注

	// Constructors

	/** default constructor */
	public Reserve() {
	}

	

	/** full constructor */
	public Reserve(String memnum, String roomnum, String resname, String comname,
			String restel, String starttime, String endtime, String restime,
			String resstate, Integer ressource, String remark,String resnumber) {
		this.memnum = memnum;
		this.roomnum = roomnum;
		this.resname = resname;
		this.comname = comname;
		this.restel = restel;
		this.starttime = starttime;
		this.endtime = endtime;
		this.restime = restime;
		this.resstate = resstate;
		this.ressource = ressource;
		this.remark = remark;
		this.resnumber = resnumber;
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

	@Column(name = "memnum")
	public String getMemnum() {
		return this.memnum;
	}

	public void setMemnum(String memnum) {
		this.memnum = memnum;
	}
	@Column(name = "roomnum")
	public String getRoomnum() {
		return this.roomnum;
	}

	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}


	@Column(name = "resname")
	public String getResname() {
		return this.resname;
	}

	public void setResname(String resname) {
		this.resname = resname;
	}

	@Column(name = "comname")
	public String getComname() {
		return this.comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}

	@Column(name = "restel")
	public String getRestel() {
		return this.restel;
	}

	public void setRestel(String restel) {
		this.restel = restel;
	}

	@Column(name = "starttime")
	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	@Column(name = "endtime")
	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	@Column(name = "restime")
	public String getRestime() {
		return this.restime;
	}

	public void setRestime(String restime) {
		this.restime = restime;
	}

	@Column(name = "resstate")
	public String getResstate() {
		return this.resstate;
	}

	public void setResstate(String resstate) {
		this.resstate = resstate;
	}

	@Column(name = "ressource")
	public Integer getRessource() {
		return this.ressource;
	}

	public void setRessource(Integer ressource) {
		this.ressource = ressource;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name = "resnumber")
	public String getResnumber() {
		return resnumber;
	}

	public void setResnumber(String resnumber) {
		this.resnumber = resnumber;
	}


	@Column(name = "hid")
	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}
	
	
	

}