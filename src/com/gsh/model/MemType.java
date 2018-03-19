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
 * MemType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "mem_type", catalog = "jxxkhotel")
@JsonIgnoreProperties(value={"memberses","hibernateLazyInitializer","handler","fieldHandler"})
public class MemType implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private Integer id;
	private String typename;//会员类型名称
	private Double cardfee;//卡费
	private Double uppoints;//升级所需积分
	private Double roomrate;//房价折扣率
	private Double goodrate;//商品折扣率
	private Integer pointsrule;//积分规则
	private Integer state;//状态
	private String remark;//备注
	private Integer sprice;//特价房是否享受会员优惠
	private Integer overdue;//可逾期记录次数
	private Integer hid;//酒店ID
	private Set<Members> memberses = new HashSet<Members>(0);

	// Constructors

	/** default constructor */
	public MemType() {
	}

	/** minimal constructor */
	public MemType(String typename, Double cardfee) {
		this.typename = typename;
		this.cardfee = cardfee;
	}

	/** full constructor */
	public MemType(String typename, Double cardfee, Double uppoints,
			Double roomrate, Double goodrate, Integer pointsrule, Integer state,
			String remark,int sprice, Set<Members> memberses) {
		this.typename = typename;
		this.cardfee = cardfee;
		this.uppoints = uppoints;
		this.roomrate = roomrate;
		this.goodrate = goodrate;
		this.pointsrule = pointsrule;
		this.state = state;
		this.remark = remark;
		this.memberses = memberses;
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

	@Column(name = "cardfee" , precision = 22, scale = 0)
	public Double getCardfee() {
		return this.cardfee;
	}

	public void setCardfee(Double cardfee) {
		this.cardfee = cardfee;
	}

	@Column(name = "uppoints", precision = 22, scale = 0)
	public Double getUppoints() {
		return this.uppoints;
	}

	public void setUppoints(Double uppoints) {
		this.uppoints = uppoints;
	}

	@Column(name = "roomrate", precision = 22, scale = 0)
	public Double getRoomrate() {
		return this.roomrate;
	}

	public void setRoomrate(Double roomrate) {
		this.roomrate = roomrate;
	}

	@Column(name = "goodrate", precision = 22, scale = 0)
	public Double getGoodrate() {
		return this.goodrate;
	}

	public void setGoodrate(Double goodrate) {
		this.goodrate = goodrate;
	}

	@Column(name = "pointsrule", precision = 22, scale = 0)
	public Integer getPointsrule() {
		return this.pointsrule;
	}

	public void setPointsrule(Integer pointsrule) {
		this.pointsrule = pointsrule;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "remark")
	public String getremark() {
		return this.remark;
	}

	public void setremark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "memType")
	public Set<Members> getMemberses() {
		return this.memberses;
	}

	public void setMemberses(Set<Members> memberses) {
		this.memberses = memberses;
	}
	
	@Column(name = "sprice")
	public Integer getSprice() {
		return sprice;
	}

	public void setSprice(Integer sprice) {
		this.sprice = sprice;
	}
	
	@Column(name = "hid")
	public Integer getHid() {
		return hid;
	}
	public void setHid(Integer hid) {
		this.hid = hid;
	}
	@Column(name = "overdue")
	public Integer getOverdue() {
		return overdue;
	}

	public void setOverdue(Integer overdue) {
		this.overdue = overdue;
	}
	
	
	
	

}