package com.blog.app.sevices;

import com.blog.app.playloads.CommentDTO;

public interface CommentService {
	
	//create
	CommentDTO createComment(CommentDTO commentDto, Integer userId,Integer postId);
	
	//delete
	void deleteComment(Integer commentId);

}
