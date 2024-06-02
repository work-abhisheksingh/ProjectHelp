package com.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.Entities.User;
import com.app.dto.LoginDto;
import com.app.dto.SigninResponse;
import com.app.dto.UserDto;

public interface UserService {

	UserDto addUser(UserDto newuser);
	
	
	UserDto getbyuserid(int userid);
	
	String deleteuser(int userid);
	
	List<UserDto> getallusers();
	
	SigninResponse authenticateuser(LoginDto dto);
}
