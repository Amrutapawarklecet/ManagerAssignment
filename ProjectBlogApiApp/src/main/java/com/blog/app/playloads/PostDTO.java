package com.blog.app.playloads;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {

	private Integer postId;

	@NotEmpty
	@Size(min = 4, message = "Title must be min of 4 charters!!")
	private String title;

	@NotEmpty
	@Size(min = 10, message = "Content must be min of 10 charters!!")
	private String content;

	private String imageName;

	private Date addedDate;

	private CategoryDTO category;

	private UserDTO user;

}
