package com.blog.app.playloads;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

	private Integer categoryId;

	@NotEmpty
	@Size(min = 4, message = "Title must be min of 4 charters!!")
	private String categoryTitle;

	@NotEmpty
	@Size(min = 10, message = "Description must be min of 10 charters!!")
	private String categoryDescription;

}
