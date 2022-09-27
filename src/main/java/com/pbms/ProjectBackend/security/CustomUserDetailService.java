package com.pbms.ProjectBackend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pbms.ProjectBackend.entities.User;
import com.pbms.ProjectBackend.repository.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//loading user from DB by username
		User user = userRepo.findByUsername(username);
		
		return user;
	}

}
