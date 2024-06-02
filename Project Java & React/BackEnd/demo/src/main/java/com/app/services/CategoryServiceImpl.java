package com.app.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entities.Category;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.CategoryDto;
import com.app.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryrepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public CategoryDto create(CategoryDto dto) {

		Category cat = this.mapper.map(dto, Category.class); // catdto to category
		Category saved = this.categoryrepo.save(cat);
		return this.mapper.map(saved, CategoryDto.class);
	}

	@Override
	public CategoryDto update(CategoryDto newcat , int catid) {
		
		Category oldcat = this.categoryrepo.findById(catid).orElseThrow(() -> new ResourceNotFoundException("category not found"));
		
		oldcat.setCategoryName(newcat.getCategoryName());
		
		Category updated = this.categoryrepo.save(oldcat);
		
		return this.mapper.map(updated, CategoryDto.class);
	}

	@Override
	public void delete(int categoryId) {
		Category cat = this.categoryrepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category not found"));
		this.categoryrepo.deleteById(categoryId);

	}

	@Override
	public CategoryDto get(int categoryId) {
		Category cat = this.categoryrepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category not found"));
		
		return this.mapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getall() {
		List<Category>  getall = this.categoryrepo.findAll();
		List<CategoryDto> allDto = getall.stream().map(cat -> this.mapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return allDto;
	}

}
