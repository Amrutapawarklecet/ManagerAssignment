package com.blog.app.controller;

import static org.mockito.Mockito.when;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.blog.app.playloads.CategoryDTO;
import com.blog.app.sevices.CategoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class CategoryControllerTest {
	
	@MockBean
	private CategoryService categorySerive;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void CreateCategoryTest() throws JsonProcessingException, Exception {
		CategoryDTO cat = new CategoryDTO(1, "python", "This is related to python");

		when(categorySerive.createCategory(cat)).thenReturn(cat);
		String url="/api/categories/";
		mockMvc.perform(post(url)
				.contentType("application/json")
				.content(objectMapper.writeValueAsBytes(cat))
				.with(csrf()))
				.andExpect(status().isOk())
				.andDo(print());

	}

	@Test
	void UpdateCategoryTest() throws JsonProcessingException, Exception {
		CategoryDTO cat = new CategoryDTO(1, "python", "This is related to python");
		
		when(categorySerive.updateCategory(cat, cat.getCategoryId())).thenReturn(cat);
		String url="/api/categories/1";
		mockMvc.perform(put(url)
				.contentType("application/json")
				.content(objectMapper.writeValueAsBytes(cat))
				.with(csrf()))
				.andExpect(status().isOk())
				.andDo(print());

	}

	@Test
	void DeleteCategoryTest() throws JsonProcessingException, Exception {
		CategoryDTO cat = new CategoryDTO(1, "python", "This is related to python");

		categorySerive.deleteCategory(1);
		String url="/api/categories/{1}";
		mockMvc.perform(delete(url)
				.contentType("application/json")
				.content(objectMapper.writeValueAsBytes(cat))
				.with(csrf()))
				.andExpect(status().isOk())
				.andDo(print());	
	}

	@Test
	void GetCategoryTest() throws JsonProcessingException, Exception {
		CategoryDTO cat = new CategoryDTO(1, "python", "This is related to python");

		when(categorySerive.createCategory(cat)).thenReturn(cat);
		String url="/api/categories/{1}";
		mockMvc.perform(get(url)
				.contentType("application/json")
				.content(objectMapper.writeValueAsBytes(cat))
				.with(csrf()))
				.andExpect(status().isOk())
				.andDo(print());	
		}

	@Test
	void GetAllCategoriesTest() throws JsonProcessingException, Exception {
		List<CategoryDTO> cat = new ArrayList<>();
		cat.add(new CategoryDTO(1, "python", "This is related to python"));
		cat.add(new CategoryDTO(2, "python", "This is related to python"));

		when(categorySerive.getAllCategories()).thenReturn(cat);
		String url="/api/categories";
		mockMvc.perform(get(url)
				.contentType("application/json")
				.content(objectMapper.writeValueAsBytes(cat))
				.with(csrf()))
				.andExpect(status().isOk())
				.andDo(print());
	}

}
