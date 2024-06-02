package com.app.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.Entities.User;
import com.app.dto.CartDto;
import com.app.dto.ItemRequest;
import com.app.services.CartService;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	private CartService cartservice;
	
	public CartController() {
		super();		
	}

	@PostMapping("/addtocart/{userId}")
	public ResponseEntity<CartDto> addToCart(@RequestBody ItemRequest itemrequest , @PathVariable int userId){
		
		System.out.println(userId);
		System.out.println(itemrequest.getQuantity());
		CartDto additem =  this.cartservice.addToCart(itemrequest, userId);
		
		return new ResponseEntity<CartDto>(additem , HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/getcart/{userId}")                                        
	public ResponseEntity<CartDto> getbyemail(@PathVariable int userId){
		CartDto cartdto =  this.cartservice.getallcart(userId);
		return new ResponseEntity<CartDto>(cartdto , HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/removecartitems/{email}/{foodid}")
	public ResponseEntity<CartDto> deletecartitems(@PathVariable String email , @PathVariable int foodid){
		CartDto cartDto = this.cartservice.removecartitems(email, foodid);
		return new ResponseEntity<CartDto>(cartDto ,  HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@PostMapping("/addtocart")
//	public ResponseEntity<?> addToCart(@RequestBody CartDto transientitem){
//
//		
////		return ResponseEntity.ok(cartservice.addToCart(dto.getCustomerId(), dto.getFoodId(), dto.getQuantity()));
//		return ResponseEntity.ok(cartservice.addToCart(transientitem));
	
	}
	
//	@PostMapping(value = "/addtocart/{user_id}")
//	public String addToCart(@PathVariable int user_id, @RequestParam int quantity ,@RequestParam int food_id) {
//			
//		return cartservice.addToCart(user_id, food_id, quantity);
//		
//	}


	
	

