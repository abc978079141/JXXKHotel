package com.gsh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Log entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "log", catalog = "jxxkhotel")
public class Log implements java.io.Serializable {

	// Fields

	private Integer logId;
	private Integer hid;
	private String userName;
	private String createTime;
	private String content;
	private String operation;
	private String ip;
	private String module;

	// Constructors

	/** default constructor */
	public Log() {
	}

	/** full constructor */
	public Log(Integer hid,String userName, String createTime, String content,
			String operation, String ip, String module) {
		this.hid=hid;
		this.userName = userName;
		this.createTime = createTime;
		this.content = content;
		this.operation = operation;
		this.ip = ip;
		this.module = module;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "logId", unique = true, nullable = false)
	public Integer getLogId() {
		return this.logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	@Column(name = "userName", length = 30)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "createTime", length = 30)
	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "operation", length = 300)
	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Column(name = "ip", length = 60)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "module", length = 40)
	public String getModule() {
		return this.module;
	}

	public void setModule(String module) {
		this.module = module;
	}
	
	@Column(name = "hid", length = 11)
	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}
	
	

}