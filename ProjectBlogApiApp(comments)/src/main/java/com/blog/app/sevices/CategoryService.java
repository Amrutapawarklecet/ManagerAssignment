package com.blog.app.sevices;



import java.util.List;

import com.blog.app.playloads.CategoryDTO;


public interface CategoryService {
	
	//create
	CategoryDTO createCategory(CategoryDTO categoryDto);
	
	//update
	CategoryDTO updateCategory(CategoryDTO categoryDto, Integer categoryId);

	//get
	CategoryDTO getCategory(Integer categoryId);
	
	//get all
	List<CategoryDTO> getAllCategories();
	
	//delete
	void deleteCategory(Integer categoryId);


}
