package com.blog.app.playloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CommentDTO {

	private Integer commentId;
	
	private  String content;
	
//	private  PostDTO postDto; //not required because we are accessing the comments in post table

}
