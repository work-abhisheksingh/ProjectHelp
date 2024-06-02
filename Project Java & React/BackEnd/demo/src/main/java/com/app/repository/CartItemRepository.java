package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.CartItems;

public interface CartItemRepository extends JpaRepository<CartItems, Integer>{

}
