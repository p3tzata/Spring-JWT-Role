package com.example.demo.controller;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.RoleImpl;
import com.example.demo.service.RoleTestService;

@RestController
@RequestMapping(value = "/home",produces = "application/json")
public class HomeController {

	@Autowired
	private RoleTestService roleTestService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping({ "/hello" })
	public String hello(HttpSession httpSession) {
		HashSet<RoleImpl> roles = (HashSet<RoleImpl>) httpSession.getAttribute("roles");
		return roleTestService.getUserHello( );
	}
	
	@RequestMapping({ "/helloAdmin" })
	@SuppressWarnings("unchecked")
	public String helloAdmin(HttpSession httpSession) {
		
		HashSet<RoleImpl> roles = (HashSet<RoleImpl>) httpSession.getAttribute("roles");
		return roleTestService.getAdminHello();
	}
	
}
