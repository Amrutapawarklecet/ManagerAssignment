package com.blog.app.services.impl;

import com.blog.app.entities.Category;
import com.blog.app.exceptions.ResourceNotFoundExpection;
import com.blog.app.playloads.CategoryDTO;
import com.blog.app.repositories.CategoryRepo;
import com.blog.app.sevices.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	// create
	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDto) {
		Category cat = modelMapper.map(categoryDto, Category.class);
		Category createCategory = categoryRepo.save(cat);
		return modelMapper.map(createCategory, CategoryDTO.class);
	}

	// update
	@Override
	public CategoryDTO updateCategory(CategoryDTO categoryDto, Integer categoryId) {
		Category cat = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundExpection("Category", "CategoryId", categoryId));

		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());

		Category updateCategory = categoryRepo.save(cat);

		return modelMapper.map(updateCategory, CategoryDTO.class);
	}

	// get
	@Override
	public CategoryDTO getCategory(Integer categoryId) {
		Category cat = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundExpection("Category", "CategoryId", categoryId));

		return modelMapper.map(cat, CategoryDTO.class);
	}

	// get All
	@Override
	public List<CategoryDTO> getAllCategories() {
		List<Category> categories = categoryRepo.findAll();
		List<CategoryDTO> allCategories = categories.stream().map(cat -> modelMapper.map(cat, CategoryDTO.class))
				.collect(Collectors.toList());
		return allCategories;
	}

	// delete
	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundExpection("Category", "CategoryId", categoryId));
		categoryRepo.delete(cat);
	}

}
