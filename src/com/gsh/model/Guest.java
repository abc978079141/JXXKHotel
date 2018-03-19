package com.gsh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Guest entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "guest", catalog = "jxxkhotel")
public class Guest implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private Integer id;
	private GuestSource guestSource;//宾客来源
	private Idtype idtype;//证件类型
	private String idnum;//证件号码
	private GuestType guestType;//宾客类型
	private String guestname;//宾客姓名
	private String tel;//联系电话
	private String sex;//性别
	private String area;//城市
	private String corporatename;//协议单位名称
	private String remark;//备注
	private Integer roomid;//房间号
	// Constructors
	/** default constructor */
	public Guest() {
	}

	/** full constructor */
	public Guest(GuestSource guestSource, Idtype idtype, GuestType guestType,
			String guestname, String tel,String sex,
			String idnum, String area, String corporatename, String remark,Integer roomid) {
		this.guestSource = guestSource;
		this.idtype = idtype;
		this.guestType = guestType;
		this.guestname = guestname;
		this.tel = tel;
		this.sex = sex;
		this.idnum = idnum;
		this.area = area;
		this.corporatename = corporatename;
		this.remark = remark;
		this.roomid = roomid;
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
	@JoinColumn(name = "guestsource")
	public GuestSource getGuestSource() {
		return this.guestSource;
	}

	public void setGuestSource(GuestSource guestSource) {
		this.guestSource = guestSource;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idtype")
	public Idtype getIdtype() {
		return this.idtype;
	}

	public void setIdtype(Idtype idtype) {
		this.idtype = idtype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "guesttype")
	public GuestType getGuestType() {
		return this.guestType;
	}

	public void setGuestType(GuestType guestType) {
		this.guestType = guestType;
	}

	@Column(name = "guestname")
	public String getGuestname() {
		return this.guestname;
	}

	public void setGuestname(String guestname) {
		this.guestname = guestname;
	}

	@Column(name = "tel")
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}


	@Column(name = "sex")
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "idnum")
	public String getIdnum() {
		return this.idnum;
	}

	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}

	@Column(name = "area")
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "corporatename", length = 11)
	public String getCorporatename() {
		return this.corporatename;
	}

	public void setCorporatename(String corporatename) {
		this.corporatename = corporatename;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "roomid")
	public Integer getRoomid() {
		return roomid;
	}

	public void setRoomid(Integer roomid) {
		this.roomid = roomid;
	}
	



}