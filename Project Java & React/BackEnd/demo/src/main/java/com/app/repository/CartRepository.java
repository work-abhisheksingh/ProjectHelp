package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.Cart;
import com.app.Entities.Food;
import com.app.Entities.User;

public interface CartRepository extends JpaRepository<Cart, Integer>{

	public Optional<Cart> findByUser(User user);


	
	//Optional<Cart> findByCustomer_id(int userId);
	
}
