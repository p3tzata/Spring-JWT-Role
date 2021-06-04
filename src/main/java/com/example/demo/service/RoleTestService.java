package com.example.demo.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class RoleTestService {

	
	@PreAuthorize("hasAnyRole('USER')")
	public String getUserHello() {
		return "Hellow User";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String getAdminHello() {
		return "Hellow Admin";
	}
	
}
