package com.fluke.security;

import java.io.Serializable;

public class AppCredential implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6651257695048018840L;
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
