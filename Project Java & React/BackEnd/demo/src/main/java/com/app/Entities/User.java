package com.app.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.relation.Role;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "User")
public class User  implements UserDetails { // beacuse in customuserdetails returning type is userdetails and we r returning user

	// private static int cartId =0;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name = "Name")
	private String name;

	@Column(name = "Email", unique = true) // unique email
	private String email;

	@Column(name = "Password", nullable = false) // Not null
	private String password;

	@ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	List<Roles> roles = new ArrayList<Roles>();

	@Column(name = "Reg_Date")
	private LocalDate regdate;

	@Lob // Long blob as by default it is tinyblob
	private byte[] img;
	
	// 1 user --- 1 cart
	//@JsonBackReference
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	// making lazy because while fetching user data we dont want data of cart to be
	 //fetched simultaneously
	private Cart cart;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(Integer userId, String name, String email, String password, List<Roles> roles, LocalDate regdate,
			byte[] img, Cart cart) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.regdate = regdate;
		this.img = img;
		this.cart = cart;
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

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public Integer getUserId() {
		return userId;
	}

	public LocalDate getRegdate() {
		return regdate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + ", roles="
				+ roles + ", regdate=" + regdate + ", img=" + Arrays.toString(img) + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<SimpleGrantedAuthority> collect = this.roles.stream().map((eachrole) -> new SimpleGrantedAuthority(eachrole.getRoleName())).collect(Collectors.toList());
		
		
		
		return collect;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;  			 //by default it is false
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;  //by default it is false
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;   //by default it is true
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;		//by default it is false
	}



	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	
}