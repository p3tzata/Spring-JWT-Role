package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RoleTestService;

@RestController
@RequestMapping(value = "/home",produces = "application/json")
public class HomeController {

	@Autowired
	private RoleTestService roleTestService;
	
	@RequestMapping({ "/hello" })
	public String hello() {
		return roleTestService.getUserHello();
	}
	
	@RequestMapping({ "/helloAdmin" })
	public String helloAdmin() {
		return roleTestService.getAdminHello();
	}
	
}
