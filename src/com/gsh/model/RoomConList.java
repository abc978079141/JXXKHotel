package com.gsh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * RoomConList entity. @author MyEclipse Persistence Tools
 * 房间消费列表
 */
@Entity
@Table(name = "room_con_list", catalog = "jxxkhotel")
@DynamicInsert(true)
@DynamicUpdate(true)
public class RoomConList implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Paymethod paymethod;//支付方式
	private Consumption consumption;//消费订单号
	private String itemname;//项目名称
	private Double itemprice;//项目价格
	private Integer amount;//数量
	private Double totalprice;//总价
	private Double payprice;//支付价格
	private Integer waiter;//服务员
	private String bookkeeper;//操作员
	private String bookitime;//操作时间
	private String remark;//备注

	// Constructors

	/** default constructor */
	public RoomConList() {
	}

	/** minimal constructor */
	public RoomConList(Consumption consumption) {
		this.consumption = consumption;
	}

	/** full constructor */
	public RoomConList(Paymethod paymethod, Consumption consumption,
			String itemname, Double itemprice, Integer amount,
			Double totalprice, Double payprice, Integer waiter,
			String bookkeeper, String bookitime, String remark) {
		this.paymethod = paymethod;
		this.consumption = consumption;
		this.itemname = itemname;
		this.itemprice = itemprice;
		this.amount = amount;
		this.totalprice = totalprice;
		this.payprice = payprice;
		this.waiter = waiter;
		this.bookkeeper = bookkeeper;
		this.bookitime = bookitime;
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
	@JoinColumn(name = "paymethod")
	public Paymethod getPaymethod() {
		return this.paymethod;
	}

	public void setPaymethod(Paymethod paymethod) {
		this.paymethod = paymethod;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "consumid", nullable = false)
	public Consumption getConsumption() {
		return this.consumption;
	}

	public void setConsumption(Consumption consumption) {
		this.consumption = consumption;
	}

	@Column(name = "itemname")
	public String getItemname() {
		return this.itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	@Column(name = "itemprice", precision = 22, scale = 0)
	public Double getItemprice() {
		return this.itemprice;
	}

	public void setItemprice(Double itemprice) {
		this.itemprice = itemprice;
	}

	@Column(name = "amount")
	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Column(name = "totalprice", precision = 22, scale = 0)
	public Double getTotalprice() {
		return this.totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	@Column(name = "payprice", precision = 22, scale = 0)
	public Double getPayprice() {
		return this.payprice;
	}

	public void setPayprice(Double payprice) {
		this.payprice = payprice;
	}

	@Column(name = "waiter")
	public Integer getWaiter() {
		return this.waiter;
	}

	public void setWaiter(Integer waiter) {
		this.waiter = waiter;
	}

	@Column(name = "bookkeeper")
	public String getBookkeeper() {
		return this.bookkeeper;
	}

	public void setBookkeeper(String bookkeeper) {
		this.bookkeeper = bookkeeper;
	}

	@Column(name = "bookitime")
	public String getBookitime() {
		return this.bookitime;
	}

	public void setBookitime(String bookitime) {
		this.bookitime = bookitime;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}