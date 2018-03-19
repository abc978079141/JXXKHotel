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

/**
 * Consumption entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "consumption", catalog = "jxxkhotel")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Consumption implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer hid;
	private String ordernum;//入账单号
	private String guestname;//宾客姓名
	private String starttime;//开始时间
	private String roomnum;//房间号
	private String remark;//备注
	private int checked;//是否结算
	private List<RoomConList> roomConLists = new ArrayList<RoomConList>();

	// Constructors

	/** default constructor */
	public Consumption() {
	}

	/** minimal constructor */
	public Consumption(String ordernum, String guestname, String starttime,
			String roomnum, String remark) {
		this.ordernum = ordernum;
		this.guestname = guestname;
		this.starttime = starttime;
		this.roomnum = roomnum;
		this.remark = remark;
	}

	/** full constructor */
	public Consumption(String ordernum, String guestname, String starttime,
			String roomnum, String remark, int checked,List<RoomConList> roomConLists) {
		this.ordernum = ordernum;
		this.guestname = guestname;
		this.starttime = starttime;
		this.roomnum = roomnum;
		this.remark = remark;
		this.roomConLists = roomConLists;
		this.checked=checked;
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

	@Column(name = "ordernum", nullable = false)
	public String getOrdernum() {
		return this.ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	@Column(name = "guestname", nullable = false)
	public String getGuestname() {
		return this.guestname;
	}

	public void setGuestname(String guestname) {
		this.guestname = guestname;
	}

	@Column(name = "starttime", nullable = false)
	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	@Column(name = "roomnum", nullable = false)
	public String getRoomnum() {
		return this.roomnum;
	}

	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}

	@Column(name = "remark", nullable = false)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "consumption")
	public List<RoomConList> getRoomConLists() {
		return this.roomConLists;
	}

	public void setRoomConLists(List<RoomConList> roomConLists) {
		this.roomConLists = roomConLists;
	}
	
	@Column(name = "checked", nullable = false)
	public int getChecked() {
		return checked;
	}

	public void setChecked(int checked) {
		this.checked = checked;
	}
	@Column(name = "hid", nullable = false)
	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}
	
	
}