package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UserImpl implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Long id;
	
	String username;

	
	String password;
	
	
	private  Set<GrantedAuthority> roles;
	private  boolean accountNonExpired;
	private  boolean accountNonLocked;
	private  boolean credentialsNonExpired;
	private  boolean enabled;
	
	


	public UserImpl(Long id, String username, String password, boolean accountNonExpired,
			boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled,Set<GrantedAuthority> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}




	public UserImpl() {
		super();
		roles=new HashSet<>();
	}


	
	
	public void setRoles(Set<GrantedAuthority> roles) {
		this.roles = roles;
	}




	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}




	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}




	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}




	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}




	public Set<GrantedAuthority> getAuthorities() {
		return roles;
	}


	public boolean getAccountNonExpired() {
		return accountNonExpired;
	}


	public boolean getAccountNonLocked() {
		return accountNonLocked;
	}


	public boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}


	public boolean getEnabled() {
		return enabled;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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


	public Set<GrantedAuthority> getRoles() {
		return roles;
	}




	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}




	@Override
	public boolean isAccountNonLocked() {
		
		return this.accountNonLocked;
	}




	@Override
	public boolean isCredentialsNonExpired() {
		
		return this.credentialsNonExpired;
	}




	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	public void addRole(RoleImpl role) {
		roles.add(role);
	}
}
