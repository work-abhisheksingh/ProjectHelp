package com.app.controller;

import org.apache.catalina.Manager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Security.JwtHelper;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.JwtRequest;
import com.app.dto.JwtResponse;
import com.app.dto.UserDto;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtHelper helper;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
		
		 this.authenticateuser(request.getUsername(), request.getPassword());
		 UserDetails userDetails= this.userDetailsService.loadUserByUsername(request.getUsername());
		String token = this.helper.generateToken(userDetails);
		JwtResponse response = new JwtResponse();
		response.setToken(token);
		response.setUser(this.mapper.map(userDetails, UserDto.class));
		
		return new ResponseEntity<JwtResponse>(response , HttpStatus.ACCEPTED);
	}
	
	
	private void authenticateuser(String username , String password) {
		try {
			System.out.println(username);
		manager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	}catch(BadCredentialsException e){
		throw new ResourceNotFoundException("Invalid Username or Password");
	}catch(DisabledException e) {
		throw new ResourceNotFoundException("User not Active");
	}
	}
		
}
