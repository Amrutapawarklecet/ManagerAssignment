package com.blog.app.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.app.entities.Comment;
import com.blog.app.entities.Post;
import com.blog.app.entities.User;
import com.blog.app.exceptions.ResourceNotFoundExpection;
import com.blog.app.playloads.CommentDTO;
import com.blog.app.repositories.CommentRepo;
import com.blog.app.repositories.PostRepo;
import com.blog.app.repositories.UserRepo;
import com.blog.app.sevices.CommentService;

@Service
public class CommentServiceImpl  implements CommentService{

	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public CommentDTO createComment(CommentDTO commentDto,Integer userId, Integer postId) {
		
		//userId
		User user =  userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundExpection("User", "UserId", userId));

		//postId
		Post post =  postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundExpection("Post", "PostId", postId));
		
		Comment comment=modelMapper.map(commentDto, Comment.class);
		
		comment.setUser(user);
		comment.setPost(post);

		Comment saveComment = commentRepo.save(comment);
		
		return modelMapper.map(saveComment, CommentDTO.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment = commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundExpection("Comment", "CommentId", commentId));
		commentRepo.delete(comment);
	}

}
