package com.gsh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RfGuest entity. @author MyEclipse Persistence Tools
 * 宾客报表
 */
@Entity
@Table(name = "rf_guest", catalog = "jxxkhotel")
public class RfGuest implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String guestsource;//宾客来源
	private Integer sourcenum;//来源名称
	private String guesttype;//宾客类别
	private Integer typenum;//类别

	// Constructors

	/** default constructor */
	public RfGuest() {
	}

	/** full constructor */
	public RfGuest(String guestsource, Integer sourcenum, String guesttype,
			Integer typenum) {
		this.guestsource = guestsource;
		this.sourcenum = sourcenum;
		this.guesttype = guesttype;
		this.typenum = typenum;
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

	@Column(name = "guestsource")
	public String getGuestsource() {
		return this.guestsource;
	}

	public void setGuestsource(String guestsource) {
		this.guestsource = guestsource;
	}

	@Column(name = "sourcenum")
	public Integer getSourcenum() {
		return this.sourcenum;
	}

	public void setSourcenum(Integer sourcenum) {
		this.sourcenum = sourcenum;
	}

	@Column(name = "guesttype")
	public String getGuesttype() {
		return this.guesttype;
	}

	public void setGuesttype(String guesttype) {
		this.guesttype = guesttype;
	}

	@Column(name = "typenum")
	public Integer getTypenum() {
		return this.typenum;
	}

	public void setTypenum(Integer typenum) {
		this.typenum = typenum;
	}

}