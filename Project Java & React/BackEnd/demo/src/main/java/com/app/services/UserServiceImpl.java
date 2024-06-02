package com.app.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.Entities.Cart;
import com.app.Entities.User;
import com.app.dto.LoginDto;
import com.app.dto.SigninResponse;
import com.app.dto.UserDto;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.repository.CartRepository;
import com.app.repository.FoodRepository;
import com.app.repository.UserRepository;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CartRepository cartrepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDto addUser(UserDto newuser) {
		
		
		
		User user = this.mapper.map(newuser, User.class);
		
		//System.out.println(newuser.getPassword());
		//String pwd = user.getPassword();  					
		//String encodepwd= this.passwordEncoder.encode(pwd);		//setting encoded password
		
		//user.setPassword(encodepwd);
		
		//System.out.println(encodepwd);
		
		Cart cart = new Cart();
		
		//user.setCart(cart);
		cart.addUser(user);
		
		
		User saveduser = userrepo.save(user);
		
		System.out.println(saveduser
				.getCart().getCustomer());
		
		return this.mapper.map(saveduser, UserDto.class);
		
	}


	
	

	@Override
	public SigninResponse authenticateuser(LoginDto dto) {

		User user = userrepo.findByEmailAndPassword(dto.getEmail() , dto.getPassword()).
				orElseThrow(()-> new ResourceNotFoundException("Invalid Login Details"));
		
		return mapper.map(user , SigninResponse.class);
	}

	@Override
	public UserDto getbyuserid(int userid) {
		
		User founduser =this.userrepo.findByuserId(userid).orElseThrow(() -> new ResourceNotFoundException("User not found"));
				
		return this.mapper.map(founduser, UserDto.class);
		
	}

	@Override
	public String deleteuser(int userid) {
		this.userrepo.deleteById(userid);
		return "User deleted";
	}
	
	@Override
	public List<UserDto> getallusers() {
		
		List<User> users =  this.userrepo.findAll();
		
		System.out.println(users);
		
		List<UserDto> usersdto = users.stream().map(each -> this.mapper.map(each, UserDto.class)).collect(Collectors.toList());
		
		return usersdto;
		
		
	}

}
