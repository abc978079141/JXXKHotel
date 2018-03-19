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
 * Idtype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "idtype", catalog = "jxxkhotel")
@JsonIgnoreProperties(value={"memberses","guests","hibernateLazyInitializer","handler","fieldHandler"})
public class Idtype implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String idname;
	private Set<Members> memberses = new HashSet<Members>(0);
	private Set<Guest> guests = new HashSet<Guest>(0);

	// Constructors

	/** default constructor */
	public Idtype() {
	}

	/** full constructor */
	public Idtype(String idname, Set<Members> memberses, Set<Guest> guests) {
		this.idname = idname;
		this.memberses = memberses;
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

	@Column(name = "idname")
	public String getIdname() {
		return this.idname;
	}

	public void setIdname(String idname) {
		this.idname = idname;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "idtype")
	public Set<Members> getMemberses() {
		return this.memberses;
	}

	public void setMemberses(Set<Members> memberses) {
		this.memberses = memberses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "idtype")
	public Set<Guest> getGuests() {
		return this.guests;
	}

	public void setGuests(Set<Guest> guests) {
		this.guests = guests;
	}

}