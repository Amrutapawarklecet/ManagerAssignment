package com.blog.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.app.playloads.ApiResponse;
import com.blog.app.playloads.CommentDTO;
import com.blog.app.sevices.CommentService;

@RestController
@RequestMapping("/api/comments/")
public class CommentController {

	
	@Autowired
	private CommentService commentService;
	
	//create
	@PostMapping("user/{userId}/post/{postId}/comment")
	public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDto,@PathVariable Integer userId,@PathVariable Integer postId){
		
		CommentDTO createComment = commentService.createComment(commentDto,userId, postId);
		return new ResponseEntity<CommentDTO>(createComment,HttpStatus.CREATED);	
	}
	
	//delete
	@DeleteMapping("/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
		commentService.deleteComment(commentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment is deleted successfully!!",true),HttpStatus.OK);
	}
	
}
