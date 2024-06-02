package com.app.dto;

import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;

import com.app.Entities.Cart;
import com.app.Entities.Roles;
import com.app.Entities.Roles;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class UserDto {

private Integer userId;
	
	private String name;

	private String email;

	private String password;

	private Roles role;

	private LocalDate regdate;

	private byte[] img;
	
	//private CartDto cart;

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public UserDto(Integer userId, String name, String email, String password, LocalDate regdate,
			byte[] img) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.regdate = regdate;
		this.img = img;
	}



	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public LocalDate getRegdate() {
		return regdate;
	}

	public void setRegdate(LocalDate regdate) {
		this.regdate = regdate;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", role=" +   ", regdate=" + regdate + ", img=" + Arrays.toString(img) + "]";
	}

	

//	public CartDto getCart() {
//		return cart;
//	}
//
//	public void setCart(CartDto cart) {
//		this.cart = cart;
//	}

	
	
	
}
