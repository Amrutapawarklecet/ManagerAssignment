package com.blog.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blog.app.playloads.PostDTO;
import com.blog.app.playloads.PostResponse;
import com.blog.app.config.AppConstants;
import com.blog.app.playloads.ApiResponse;
import com.blog.app.sevices.FileService;
import com.blog.app.sevices.PostService;

@RestController
@RequestMapping("/api/posts/")
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private FileService fileService;

//	@Value("${project.image}")
//	private String path;

	// create
	@PostMapping("/user/{userId}/category/{categoryId}")
	public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {
		PostDTO createPost = postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDTO>(createPost, HttpStatus.CREATED);

	}

	// update
	@PutMapping("/{postId}")
	public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDto, @PathVariable Integer postId) {
		PostDTO updatePost = postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDTO>(updatePost, HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/{postId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId) {
		postService.deletePost(postId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Post Deleted Successfully!!", true), HttpStatus.OK);

	}

	// get
	@GetMapping("/{postId}")
	public ResponseEntity<PostDTO> getPost(@PathVariable Integer postId) {
		PostDTO getPost = postService.getPost(postId);
		return new ResponseEntity<PostDTO>(getPost, HttpStatus.OK);
	}

	/*
	 * // get All
	 * 
	 * @GetMapping("/") public ResponseEntity<PostResponse> getAllPosts(
	 * 
	 * @RequestParam(value = "pageNumber", defaultValue = "0", required = false)
	 * Integer pageNumber,
	 * 
	 * @RequestParam(value = "pageSize", defaultValue = "5", required = false)
	 * Integer pageSize,
	 * 
	 * @RequestParam(value = "sortBy", defaultValue = "postId", required = false)
	 * String sortBy,
	 * 
	 * @RequestParam(value = "sortDirc", defaultValue = "asc", required = false)
	 * String sortDirc) { PostResponse getAllPosts =
	 * postService.getAllPosts(pageNumber, pageSize, sortBy, sortDirc); return new
	 * ResponseEntity<PostResponse>(getAllPosts, HttpStatus.OK); }
	 */

	// get All
	@GetMapping("/")
	public ResponseEntity<PostResponse> getAllPosts(
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDirc", defaultValue = AppConstants.SORT_DIRC, required = false) String sortDirc) {
		PostResponse getAllPosts = postService.getAllPosts(pageNumber, pageSize, sortBy, sortDirc);
		return new ResponseEntity<PostResponse>(getAllPosts, HttpStatus.OK);
	}

	// get all by category
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<List<PostDTO>> getPostsByCategory(@PathVariable Integer categoryId) {
		List<PostDTO> getPostsBYCategories = postService.getPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDTO>>(getPostsBYCategories, HttpStatus.OK);

	}

	// get all by user
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<PostDTO>> getPostsByUser(@PathVariable Integer userId) {
		List<PostDTO> getPostsByUser = postService.getPostsByUser(userId);
		return new ResponseEntity<List<PostDTO>>(getPostsByUser, HttpStatus.OK);
	}

	// search by title
	/*
	 * @GetMapping("/search/{keyword}") public ResponseEntity<List<PostDTO>>
	 * getSearchPosts(@PathVariable String keyword) { List<PostDTO> searchPosts =
	 * postService.searchPosts(keyword); return new
	 * ResponseEntity<List<PostDTO>>(searchPosts, HttpStatus.OK); }
	 */

	// post upload image
	/*@GetMapping("/upload/image/{postId}")
	public ResponseEntity<PostDTO> uploadImage(@RequestParam("file") MultipartFile file, @PathVariable Integer postId)
			throws IOException {

		// get post with represent to post Id
		PostDTO postDto = postService.getPost(postId);

		// upload the image
		String uploadImage = fileService.uploadImage(file);

		// set the image
		postDto.setImageName(uploadImage);

		// update the upload image in DB
		PostDTO updatePostImage = postService.updatePost(postDto, postId);

		return new ResponseEntity<PostDTO>(updatePostImage, HttpStatus.OK);

	}*/

}
