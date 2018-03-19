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
 * GuestSource entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "guest_source", catalog = "jxxkhotel")
@JsonIgnoreProperties(value={"guests","hibernateLazyInitializer","handler","fieldHandler"})
public class GuestSource implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String gsourcename;
	private Set<Guest> guests = new HashSet<Guest>(0);

	// Constructors

	/** default constructor */
	public GuestSource() {
	}

	/** full constructor */
	public GuestSource(String gsourcename, Set<Guest> guests) {
		this.gsourcename = gsourcename;
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

	@Column(name = "gsourcename")
	public String getGsourcename() {
		return this.gsourcename;
	}

	public void setGsourcename(String gsourcename) {
		this.gsourcename = gsourcename;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "guestSource")
	public Set<Guest> getGuests() {
		return this.guests;
	}

	public void setGuests(Set<Guest> guests) {
		this.guests = guests;
	}

}