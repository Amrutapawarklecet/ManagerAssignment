package com.blog.app.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.blog.app.entities.Category;
import com.blog.app.entities.Post;
import com.blog.app.entities.User;
import com.blog.app.exceptions.ResourceNotFoundExpection;
import com.blog.app.playloads.PostDTO;
import com.blog.app.playloads.PostResponse;
import com.blog.app.repositories.CategoryRepo;
import com.blog.app.repositories.PostRepo;
import com.blog.app.repositories.UserRepo;
import com.blog.app.sevices.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private UserRepo userRepo;

	// create Post
	@Override
	public PostDTO createPost(PostDTO postDto, Integer userId, Integer categoryId) {

		// get category
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundExpection("Category", "CategoryId", categoryId));

		// get user
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundExpection("User", "UserId", userId));

		Post createPost = modelMapper.map(postDto, Post.class);

		createPost.setTitle(postDto.getTitle());
		createPost.setContent(postDto.getContent());
		createPost.setImageName("Default.png");
		createPost.setAddedDate(new Date());
		createPost.setCategory(category);
		createPost.setUser(user);

		Post newPost = postRepo.save(createPost);

		return modelMapper.map(newPost, PostDTO.class);
	}

	// update Post
	@Override
	public PostDTO updatePost(PostDTO postDto, Integer postId) {

		// get post Id
		Post post = postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundExpection("Post", "PostId", postId));

		// set the data
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());

		Post updatePost = postRepo.save(post);

		return modelMapper.map(updatePost, PostDTO.class);
	}

	// delete post
	@Override
	public void deletePost(Integer postId) {
		Post post = postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundExpection("Post", "PostId", postId));
		postRepo.delete(post);
	}

	// get
	@Override
	public PostDTO getPost(Integer postId) {
		Post post = postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundExpection("Post", "PostId", postId));
		return modelMapper.map(post, PostDTO.class);
	}

	/*
	 * //get all
	 * 
	 * @Override public List<PostDTO> getAllPosts(Integer pageNumber,Integer
	 * pageSize) {
	 * 
	 * //create pagable Object Pageable p=PageRequest.of(pageNumber, pageSize);
	 * 
	 * Page<Post> pagePosts = postRepo.findAll(p);
	 * 
	 * //get page in slice List<Post> posts=pagePosts.getContent();
	 * 
	 * List<PostDTO> postDtos = posts.stream().map(post -> modelMapper.map(post,
	 * PostDTO.class)) .collect(Collectors.toList()); return postDtos; }
	 */

	/*// get all using post Response like get content,pageSize,
	// pageNumber,totalElements, total pages, lastPage
	@Override
	public PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy) {

		// create pagable Object
//			Pageable p=PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
		
		//want is descending order then
		Pageable p=PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending());

		Page<Post> pagePosts = postRepo.findAll(p);

		// get page in slice
		List<Post> posts = pagePosts.getContent();

		List<PostDTO> postDtos = posts.stream().map(post -> modelMapper.map(post, PostDTO.class))
				.collect(Collectors.toList());

		// create and set the all values
		PostResponse postResponse = new PostResponse();
		postResponse.setContent(postDtos);
		postResponse.setPageNumber(pagePosts.getNumber());
		postResponse.setPageSize(pagePosts.getSize());
		postResponse.setTotalElements(pagePosts.getTotalElements());
		postResponse.setTotalPages(pagePosts.getTotalPages());
		postResponse.setLastPage(pagePosts.isLast());

		return postResponse;

	}*/
	
	@Override
	public PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy,String sortDirc) {

		// create pagable Object
		// Pageable p=PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
		
		//want is descending order then
		//	Pageable p=PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending());
		
		/*if(sortDirc.equalsIgnoreCase("asc")) {
			sort=sort.by(sortBy).ascending();
		}
		
		else{
			sort=sort.by(sortBy).descending();
		}
		*/
		
		//using ternary operator
		Sort sort=sortDirc.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
		
		Pageable p = PageRequest.of(pageNumber, pageSize, sort);

		Page<Post> pagePosts = postRepo.findAll(p);

		// get page in slice
		List<Post> posts = pagePosts.getContent();

		List<PostDTO> postDtos = posts.stream().map(post -> modelMapper.map(post, PostDTO.class))
				.collect(Collectors.toList());

		// create and set the all values
		PostResponse postResponse = new PostResponse();
		postResponse.setContent(postDtos);
		postResponse.setPageNumber(pagePosts.getNumber());
		postResponse.setPageSize(pagePosts.getSize());
		postResponse.setTotalElements(pagePosts.getTotalElements());
		postResponse.setTotalPages(pagePosts.getTotalPages());
		postResponse.setLastPage(pagePosts.isLast());

		return postResponse;

	}


	// get posts by category
	@Override
	public List<PostDTO> getPostsByCategory(Integer categoryId) {

		// get category id
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundExpection("Category", "CategoryId", categoryId));

		// get all post by category
		List<Post> posts = postRepo.findAllByCategory(category);

		List<PostDTO> postDtos = posts.stream().map(post -> modelMapper.map(post, PostDTO.class))
				.collect(Collectors.toList());

		return postDtos;
	}

	// get posts by user
	@Override
	public List<PostDTO> getPostsByUser(Integer userId) {

		// get user id
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundExpection("User", "UserId", userId));

		// get all posts by user
		List<Post> posts = postRepo.findAllByUser(user);

		List<PostDTO> postDtos = posts.stream().map(post -> modelMapper.map(post, PostDTO.class))
				.collect(Collectors.toList());

		return postDtos;
	}

	// search posts
	/*@Override
	public List<PostDTO> searchPosts(String keyword) {

		List<Post> posts = postRepo.searchByTitle(keyword);

		List<PostDTO> postDtos = posts.stream().map(post -> modelMapper.map(post, PostDTO.class))
				.collect(Collectors.toList());

		return postDtos;
	}*/

}
