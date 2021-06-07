package com.example.demo.entity;

import java.util.Objects;



import org.springframework.security.core.GrantedAuthority;


public final class RoleImpl implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	Long id;
	
	private  String name;

	
	
	public RoleImpl(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	public RoleImpl() {
		super();
		this.name = "";
	}
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	@Override
	public String getAuthority() {
		return name;
	}

	@Override
	public int hashCode() {
        return Objects.hash(this.id);
    }
	
	
	@Override
	public boolean equals(Object obj) {

		RoleImpl obj_BaseDTO = (RoleImpl) obj;
		
		if (this.getId() ==null || obj_BaseDTO.getId()==null) {
			return false;
		}
		
		
		if (Long.compare(this.getId(), obj_BaseDTO.getId()) == 0) {
			return true;
		} else {
			return false;
		}
		

	}



	@Override
	public String toString() {
		return "RoleImpl [id=" + id + ", name=" + name + "]";
	}
	
	
}