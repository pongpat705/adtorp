package com.fluke.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "MASTER_USER")
@Entity
public class MasterUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long masterUserId;
	
	private String userName;
	private String password;
	
	public Long getMasterUserId() {
		return masterUserId;
	}
	public void setMasterUserId(Long masterUserId) {
		this.masterUserId = masterUserId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MasterUser [");
		if (masterUserId != null)
			builder.append("masterUserId=").append(masterUserId).append(", ");
		if (userName != null)
			builder.append("userName=").append(userName).append(", ");
		if (password != null)
			builder.append("password=").append(password);
		builder.append("]");
		return builder.toString();
	}
	
}
