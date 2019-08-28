package com.fluke.security;

import org.springframework.security.core.GrantedAuthority;

public class Authorities implements GrantedAuthority {

	private static final long serialVersionUID = 8102703918319424350L;
	
	private String authority;
	
	public Authorities(String authority) {
		this.authority = authority;
	} 
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authority;
	}

}
