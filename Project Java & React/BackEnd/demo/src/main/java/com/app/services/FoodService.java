package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.app.Entities.Food;
import com.app.dto.FoodDto;

public interface FoodService {

	FoodDto addFood(FoodDto food/*, int catid*/);

	List<FoodDto> getAllFoods();

	String deleteFood(Integer food_id);

	Food addToCart(Integer food_id);

	FoodDto getbyId(int foodId);

	FoodDto updateFood(int foodId, FoodDto newfood);
	
//	List<FoodDto> getProductByCategory(int catid);



}
