package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class LoginDto {

	
	// data members MUST MATCH with JSON prop names
	@NotBlank(message = "Email can't be blank!") //javax.validation.constraints.NotBlank;
	@Email(message = "Invalid Email Format")  //javax.validation.constraints.Email;
	@Length(min = 5,max=20,message = "Invalid Email length!!!!!!!")
	@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "Invalid Email")
	private String email;
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message = "Blank or Invalid Password!!!!")  //javax.validation.constraints.Pattern;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
}
