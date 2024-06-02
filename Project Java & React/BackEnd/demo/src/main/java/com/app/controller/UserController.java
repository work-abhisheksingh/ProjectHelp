package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Entities.Cart;
import com.app.Entities.User;
import com.app.dto.LoginDto;
import com.app.dto.UserDto;
import com.app.services.UserService;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping("/api/user")
@Validated
public class UserController {

	@Autowired
	private UserService userservice;
	
	public UserController() {
		
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<UserDto> registeruser(@RequestBody @Valid UserDto newuser) {
		System.out.println("in user registration");
		
		//Cart cart=new Cart();	//creating instance of cart while registering new user but this is working only in database -
								//Jackson.databind error
		UserDto userdto = this.userservice.addUser(newuser);
		
		return new ResponseEntity<UserDto>(userdto , HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/getbyid/{userid}")
	public ResponseEntity<UserDto> getbyid(@PathVariable int userid){
		UserDto user =this.userservice.getbyuserid(userid);
		
		return new ResponseEntity<UserDto>(user , HttpStatus.FOUND);
	}
	
	
	@DeleteMapping("/deleteuser/{userid}")
	public ResponseEntity<String> deleteuser(@PathVariable int userid){
		
		userservice.deleteuser(userid);
		
		return new ResponseEntity<String> ("User deleted" , HttpStatus.OK);
	}
	
	
	
	@GetMapping
	public ResponseEntity<List<UserDto>> getallusers(){
		
		List<UserDto> users = this.userservice.getallusers();
		
		return new ResponseEntity<List<UserDto>>(users , HttpStatus.OK);
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> validateuser(@RequestBody @Valid LoginDto dto){
		
		System.out.println("in sign in");
		
		return ResponseEntity.ok(userservice.authenticateuser(dto));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
}
