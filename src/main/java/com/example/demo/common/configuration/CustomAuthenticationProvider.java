package com.example.demo.common.configuration;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.example.demo.service.UserDetailsServiceImpl;

@Component
@Profile("enableCustomAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        if (userDetailsService.customAuth(username,password)) {
        	 
            // use the credentials
            // and authenticate against the third-party system
            return new UsernamePasswordAuthenticationToken(
            		username, password, userDetailsService.loadUserByUsername(username).getAuthorities());
        } else {
            return null;
        }
        
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
