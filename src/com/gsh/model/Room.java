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
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Room entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "room", catalog = "jxxkhotel")
@DynamicInsert(true)
@DynamicUpdate(true)
@JsonIgnoreProperties(value={"reserves","hibernateLazyInitializer","handler","fieldHandler"})
public class Room implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private Integer id;
	private Integer hid;//酒店ID
	private RoomType roomType;//房间类别
	private String roomnum;//房间号
	private String roompwd;//房间密码
	private Integer roomstate;//房间状态
	private String tel;//房间电话
	private Integer floor;//楼层
	private Integer window;//是否有窗
	private Integer hourday;//是否为钟点房
	private Double relprice;//特价
	private String starttime;//开始使用时间
	private String endtime;//使用结束时间
	private String remark;//备注
	private Integer state;//房间状态1正常0停用

	// Constructors

	/** default constructor */
	public Room() {
	}

	/** minimal constructor */
	public Room(String roomnum) {
		this.roomnum = roomnum;
	}

	/** full constructor */
	public Room(RoomType roomType, String roomnum, String roompwd,
			Integer roomstate, String tel, Integer floor, Integer window,
			Integer hourday, Double relprice, String starttime,
			String endtime, String remark) {
		this.roomType = roomType;
		this.roomnum = roomnum;
		this.roompwd = roompwd;
		this.roomstate = roomstate;
		this.tel = tel;
		this.floor = floor;
		this.window = window;
		this.hourday = hourday;
		this.relprice = relprice;
		this.starttime = starttime;
		this.endtime = endtime;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roomtype")
	public RoomType getRoomType() {
		return this.roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	@Column(name = "roomnum", nullable = false)
	public String getRoomnum() {
		return this.roomnum;
	}

	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}

	@Column(name = "roompwd")
	public String getRoompwd() {
		return this.roompwd;
	}

	public void setRoompwd(String roompwd) {
		this.roompwd = roompwd;
	}

	@Column(name = "roomstate")
	public Integer getRoomstate() {
		return this.roomstate;
	}

	public void setRoomstate(Integer roomstate) {
		this.roomstate = roomstate;
	}

	@Column(name = "tel")
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "floor")
	public Integer getFloor() {
		return this.floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	@Column(name = "window")
	public Integer getWindow() {
		return this.window;
	}

	public void setWindow(Integer window) {
		this.window = window;
	}

	@Column(name = "hourday")
	public Integer gethourday() {
		return this.hourday;
	}

	public void sethourday(Integer hourday) {
		this.hourday = hourday;
	}

	@Column(name = "relprice", precision = 22, scale = 0)
	public Double getRelprice() {
		return this.relprice;
	}

	public void setRelprice(Double relprice) {
		this.relprice = relprice;
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
			this.hid=hid;
	}
	
	@Column(name = "state")
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	
	
	

}