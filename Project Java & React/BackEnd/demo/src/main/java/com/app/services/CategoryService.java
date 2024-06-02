package com.app.services;

import java.util.List;

import com.app.dto.CategoryDto;

public interface CategoryService {
	
	CategoryDto create(CategoryDto dto);
	
	CategoryDto update(CategoryDto dto, int catid);
	
	void delete(int categoryId);
	
	CategoryDto get(int categoryId);
	
	List<CategoryDto> getall();
}
