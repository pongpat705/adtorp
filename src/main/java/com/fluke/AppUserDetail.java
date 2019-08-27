package com.fluke;

import java.io.Serializable;

public class AppUserDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 363281012731300868L;
	private String companyName;
	private String position;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
}
