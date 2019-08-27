package com.fluke;

import java.util.List;

import org.springframework.security.core.Authentication;

public class AppAuthenticateUser implements Authentication {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private AppCredential credentials;
	private List<Authorities> authorities;
	private boolean authenticated;
	private AppUserDetail details;
	private String principal;
	

	public AppAuthenticateUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppAuthenticateUser(String name, AppCredential credentials, List<Authorities> authorities,
			boolean authenticated, AppUserDetail details, String principal) {
		super();
		this.name = name;
		this.credentials = credentials;
		this.authorities = authorities;
		this.authenticated = authenticated;
		this.details = details;
		this.principal = principal;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public List<Authorities> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}

	@Override
	public AppCredential getCredentials() {
		// TODO Auto-generated method stub
		return this.credentials;
	}

	@Override
	public AppUserDetail getDetails() {
		// TODO Auto-generated method stub
		return this.details;
	}

	@Override
	public String getPrincipal() {
		// TODO Auto-generated method stub
		return this.principal;
	}

	@Override
	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return this.authenticated;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		this.authenticated = isAuthenticated;
	}

}
