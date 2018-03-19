package com.gsh.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * 
*<p>Title:User </p>
*<p>Description: </p>
*<p>Company: </p> 
*@author gdd
*@date 2016-12-30 下午3:52:13
 */
@Entity
@Table(name = "user", catalog = "jxxkhotel")
@JsonIgnoreProperties(value={"hotelUser","hibernateLazyInitializer","handler","fieldHandler"})
public class User implements java.io.Serializable {

	// Fields
	
	/**
	 * 
	 */
	private HttpSession session;
	private Integer id;
	private City city;//城市
	private String usernum;//用户账号
	private String username;//用户姓名
	private String password;//用户密码
	private String tel;//手机号码
	private String email;//电子邮件
	private String sex;//性别
	private Integer age;//年龄
	private String birthday;//生日
	private String salary;//薪水
	private String starttime;//开始时间
	private String endtime;//结束时间
	private String description;//描述
	private HotelUser hotelUser;//所属酒店
	private UserRole userRole;//用户对应角色
	private Integer hid;//酒店ID
	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */

	public User(Integer id) {
		super();
		this.id = id;
	}
	
	/** full constructor */
	public User(City city, String usernum, String username, String password,
			String sex, Integer age, String birthday, String salary,
			String starttime, String endtime, String description) {
		this.city = city;
		this.usernum = usernum;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
		this.salary = salary;
		this.starttime = starttime;
		this.endtime = endtime;
		this.description = description;
	}
	public User( Integer id,String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
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
	@JoinColumn(name = "city", nullable = true)
	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Column(name = "usernum")
	public String getUsernum() {
		return this.usernum;
	}

	public void setUsernum(String usernum) {
		this.usernum = usernum;
	}

	@Column(name = "username", length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "sex", length = 10)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "age", nullable = true)
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "birthday", length = 50)
	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Column(name = "salary", length = 50)
	public String getSalary() {
		return this.salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Column(name = "starttime", length = 100)
	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	@Column(name = "endtime", length = 100)
	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	@Column(name = "description", length = 500)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	@OneToOne(mappedBy ="user")
	public HotelUser getHotelUser() {
		return this.hotelUser;
	}

	public void setHotelUser(HotelUser HotelUser) {
		this.hotelUser = HotelUser;
	}
	
	@OneToOne(mappedBy ="user")
	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	
	@Column(name = "hid", nullable = true)
	public Integer getHid() {
			return hid;
	}

	public void setHid(Integer hid) {
		if(this.getHid()!=null)
			this.hid = Integer.parseInt(session.getAttribute("hid").toString());
		else 
			this.hid=hid;
	}
	
	@Column(name = "tel", nullable = true)
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	@Column(name = "email", nullable = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	


}