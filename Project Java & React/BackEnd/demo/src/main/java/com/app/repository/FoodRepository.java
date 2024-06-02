package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.Category;
import com.app.Entities.Food;
import com.app.dto.FoodDto;

public interface FoodRepository extends JpaRepository<Food, Integer>{

	//List<Food> findByCategory(Category foundcat);

//	List<Food> findByCategory (Category cat); 

	//Food findById(int foodid);
}

