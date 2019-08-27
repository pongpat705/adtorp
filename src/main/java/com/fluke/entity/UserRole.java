package com.fluke.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "USER_ROLE")
@Entity
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userRoleId;
	
	private String userCode;
	private String roleName;
	private String objectName;
	
	public Long getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserRole [");
		if (userRoleId != null)
			builder.append("userRoleId=").append(userRoleId).append(", ");
		if (userCode != null)
			builder.append("userCode=").append(userCode).append(", ");
		if (roleName != null)
			builder.append("roleName=").append(roleName).append(", ");
		if (objectName != null)
			builder.append("objectName=").append(objectName);
		builder.append("]");
		return builder.toString();
	}
	
	
}
