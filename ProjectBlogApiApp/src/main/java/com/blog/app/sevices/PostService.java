package com.blog.app.sevices;

import java.util.List;

import com.blog.app.entities.Post;
import com.blog.app.playloads.PostDTO;
import com.blog.app.playloads.PostResponse;

public interface PostService {

	// create
	PostDTO createPost(PostDTO postDto, Integer userId, Integer categoryId);

	// update
	PostDTO updatePost(PostDTO postDto, Integer postId);

	// delete
	void deletePost(Integer postId);

	// get
	PostDTO getPost(Integer postId);

	// get all posts
//	PostResponse getAllPosts(Integer pageNumber,Integer pageSize);
//	PostResponse getAllPosts(Integer pageNumber,Integer pageSize,String sortBy);
	PostResponse getAllPosts(Integer pageNumber,Integer pageSize,String sortBy,String dirc); //direction also like asc and desc


	// get all posts by category
	List<PostDTO> getPostsByCategory(Integer categoryId);

	// get all posts by user
	List<PostDTO> getPostsByUser(Integer UserId);

	// search the posts
//	List<PostDTO> searchPosts(String keyword);

}
