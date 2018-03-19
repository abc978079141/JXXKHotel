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
 * HotelMem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "hotel_mem", catalog = "jxxkhotel")
public class HotelMem implements java.io.Serializable {

	// Fields

	private Integer id;
	private Members members;
	private Hotel hotel;

	// Constructors

	/** default constructor */
	public HotelMem() {
	}

	/** full constructor */
	public HotelMem(Members members, Hotel hotel) {
		this.members = members;
		this.hotel = hotel;
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
	@JoinColumn(name = "memid", nullable = false)
	public Members getMembers() {
		return this.members;
	}

	public void setMembers(Members members) {
		this.members = members;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hid", nullable = false)
	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}