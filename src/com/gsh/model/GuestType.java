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
 * GuestType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "guest_type", catalog = "jxxkhotel")
@JsonIgnoreProperties(value={"guests","hibernateLazyInitializer","handler","fieldHandler"})
public class GuestType implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String gtypename;
	private Set<Guest> guests = new HashSet<Guest>(0);

	// Constructors

	/** default constructor */
	public GuestType() {
	}

	/** full constructor */
	public GuestType(String gtypename, Set<Guest> guests) {
		this.gtypename = gtypename;
		this.guests = guests;
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

	@Column(name = "gtypename")
	public String getGtypename() {
		return this.gtypename;
	}

	public void setGtypename(String gtypename) {
		this.gtypename = gtypename;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "guestType")
	public Set<Guest> getGuests() {
		return this.guests;
	}

	public void setGuests(Set<Guest> guests) {
		this.guests = guests;
	}

}