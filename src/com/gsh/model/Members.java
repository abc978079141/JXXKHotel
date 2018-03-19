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
 * Members entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "members", catalog = "jxxkhotel")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Members implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private Integer id;
	private Integer hid;//酒店ID
	private Idtype idtype;//证件类别
	private MemType memType;//会员类别
	private String memnum;//会员名
	private String memname;//会员姓名
	private String mempass;//会员密码
	private String sex;//性别
	private Integer age;//年龄
	private String tel;//联系方式
	private String area;//城市
	private String idnum;//证件号码
	private String birthday;//生日
	private String starttime;//注册时间
	private String endtime;//有效时间
	private Double totalmoney;//总储值
	private Double leftmoney;//可用余额
	private Double totalpoints;//总结分
	private Double usedpoints;//兑换积分
	private Double leftpoints;//可用积分
	private Integer state;//会员状态
	private Integer badrecod;//不良记录
	private String remark;//备注

	// Constructors

	/** default constructor */
	public Members() {
	}

	/** minimal constructor */
	public Members(Idtype idtype, MemType memType, String sex, Integer age,
			String area, Integer state) {
		this.idtype = idtype;
		this.memType = memType;
		this.sex = sex;
		this.age = age;
		this.area = area;
		this.state = state;
	}

	/** full constructor */
	public Members(Idtype idtype, MemType memType, String memnum,
			String memname, String mempass, String sex, Integer age,
			String tel, String area, String idnum, String birthday,
			String starttime, String endtime, Double totalmoney,
			Double leftmoney, Double totalpoints, Double usedpoints,
			Double leftpoints, Integer state, String remark) {
		this.idtype = idtype;
		this.memType = memType;
		this.memnum = memnum;
		this.memname = memname;
		this.mempass = mempass;
		this.sex = sex;
		this.age = age;
		this.tel = tel;
		this.area = area;
		this.idnum = idnum;
		this.birthday = birthday;
		this.starttime = starttime;
		this.endtime = endtime;
		this.totalmoney = totalmoney;
		this.leftmoney = leftmoney;
		this.totalpoints = totalpoints;
		this.usedpoints = usedpoints;
		this.leftpoints = leftpoints;
		this.state = state;
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
	@JoinColumn(name = "idtype", nullable = false)
	public Idtype getIdtype() {
		return this.idtype;
	}

	public void setIdtype(Idtype idtype) {
		this.idtype = idtype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "memtype", nullable = false)
	public MemType getMemType() {
		return this.memType;
	}

	public void setMemType(MemType memType) {
		this.memType = memType;
	}

	@Column(name = "memnum")
	public String getMemnum() {
		return this.memnum;
	}

	public void setMemnum(String memnum) {
		this.memnum = memnum;
	}

	@Column(name = "memname")
	public String getMemname() {
		return this.memname;
	}

	public void setMemname(String memname) {
		this.memname = memname;
	}

	@Column(name = "mempass")
	public String getMempass() {
		return this.mempass;
	}

	public void setMempass(String mempass) {
		this.mempass = mempass;
	}

	@Column(name = "sex", nullable = false)
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

	@Column(name = "tel")
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "area", nullable = false, length = 11)
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "idnum")
	public String getIdnum() {
		return this.idnum;
	}

	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}

	@Column(name = "birthday")
	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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

	@Column(name = "totalmoney", precision = 22, scale = 0)
	public Double getTotalmoney() {
		return this.totalmoney;
	}

	public void setTotalmoney(Double totalmoney) {
		this.totalmoney = totalmoney;
	}

	@Column(name = "leftmoney", precision = 22, scale = 0)
	public Double getLeftmoney() {
		return this.leftmoney;
	}

	public void setLeftmoney(Double leftmoney) {
		this.leftmoney = leftmoney;
	}

	@Column(name = "totalpoints", precision = 22, scale = 0)
	public Double getTotalpoints() {
		return this.totalpoints;
	}

	public void setTotalpoints(Double totalpoints) {
		this.totalpoints = totalpoints;
	}

	@Column(name = "usedpoints", precision = 22, scale = 0)
	public Double getUsedpoints() {
		return this.usedpoints;
	}

	public void setUsedpoints(Double usedpoints) {
		this.usedpoints = usedpoints;
	}

	@Column(name = "leftpoints", precision = 22, scale = 0)
	public Double getLeftpoints() {
		return this.leftpoints;
	}

	public void setLeftpoints(Double leftpoints) {
		this.leftpoints = leftpoints;
	}

	@Column(name = "state", nullable = false, columnDefinition = "varchar default 1")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "badrecord")
	public Integer getBadrecod() {
		return badrecod;
	}

	public void setBadrecod(Integer badrecod) {
		this.badrecod = badrecod;
	}
	@Column(name = "hid")
	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}
	
	

}