package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.util.JWTTokenUtil;
import com.example.demo.dto.AuthRequestBody;
import com.example.demo.dto.AuthResponseBody;
import com.example.demo.service.UserDetailsServiceImpl;

@RestController
@CrossOrigin
public class JWTAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequestBody authRequestBody, HttpSession httpSession) throws Exception {

		/**/
		authenticate(authRequestBody.getUsername(), authRequestBody.getPassword());

		
		
		
		final UserDetails userDetails = userDetailsService
		.loadUserByUsername(authRequestBody.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		httpSession.setAttribute("userDetails", userDetails); //Decided by myself
		
		
		
		return ResponseEntity.ok(new AuthResponseBody(token));
		
		
		
	    }

		private void authenticate(String username, String password) throws Exception {
		try {
		    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
		throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
		throw new Exception("INVALID_CREDENTIALS", e);
		}
		}
	
	
	

	
}
