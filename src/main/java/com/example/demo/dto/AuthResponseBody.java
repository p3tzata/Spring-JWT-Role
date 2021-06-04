package com.example.demo.dto;

import java.io.Serializable;

public class AuthResponseBody implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String JWTToken;
	public AuthResponseBody(String jWTToken) {
		super();
		JWTToken = jWTToken;
	}
	
	public String getJWTToken() {
		return JWTToken;
	}
	
	
	
}
