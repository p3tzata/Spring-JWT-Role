package com.example.demo.repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.demo.entity.RoleImpl;
import com.example.demo.entity.UserImpl;

@Component
public class UserRepository {
	
	
	Map<String, UserDetails> usersDb = new HashMap<>();
	Map<String, GrantedAuthority> rolesDb = new HashMap<>();
	
	UserRepository() {

		rolesDb.put("ROLE_USER", new RoleImpl(1L,"ROLE_USER"));
		rolesDb.put("ROLE_MODERATOR", new RoleImpl(2L,"ROLE_MODERATOR"));
		rolesDb.put("ROLE_ADMIN", new RoleImpl(3L,"ROLE_ADMIN"));
		
		
		Set<GrantedAuthority> userRoles = new HashSet<>();
		userRoles.add(rolesDb.get("ROLE_USER"));
		
		
		
		Set<GrantedAuthority> adminRoles = new HashSet<>();
		adminRoles.add(rolesDb.get("ROLE_USER"));
		adminRoles.add(rolesDb.get("ROLE_MODERATOR"));
		adminRoles.add(rolesDb.get("ROLE_ADMIN"));
		
		Set<GrantedAuthority> vikiRoles = adminRoles;
		
		
		usersDb.put("user", new UserImpl(1L,"user", "$2y$12$Fi6hgSmTNA9nD1ZlwEyV0.khzAAadsx6boDZ6lXXfQln2FT5TCV3q", true, true, true, true, userRoles)) ;
		usersDb.put("admin", new UserImpl(1L,"admin", "$2y$12$Fi6hgSmTNA9nD1ZlwEyV0.khzAAadsx6boDZ6lXXfQln2FT5TCV3q", true, true, true, true, adminRoles)) ;
		usersDb.put("viki", new UserImpl(3L,"viki", "123456", true, true, true, true, vikiRoles)) ;
	}
	
	public UserDetails loadUserByUsername(String username) {
		
		if(usersDb.containsKey(username)) {
			return usersDb.get(username);
		}
		return null;
		
	}
	
	
	public boolean customAuth(String username, String password) {
		
		if(usersDb.containsKey(username)) {
			if( usersDb.get(username).getPassword().equals(password)) {
				return true;
			}
		}
		return false;
		
	}

}
