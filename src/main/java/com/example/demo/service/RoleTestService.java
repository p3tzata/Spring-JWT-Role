package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RoleImpl;

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
