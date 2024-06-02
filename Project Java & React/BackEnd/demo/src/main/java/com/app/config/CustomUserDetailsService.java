package com.app.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.Entities.User;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.repository.UserRepository;

@Service

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository usereepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = this.usereepo.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException(" User not found"));
		
		return user;
	}

}
