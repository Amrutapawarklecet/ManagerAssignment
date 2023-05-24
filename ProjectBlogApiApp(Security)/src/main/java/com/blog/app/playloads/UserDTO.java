package com.blog.app.playloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
	
	private Integer userId;
	
	@NotEmpty
	@Size(min=4, message="Username must be min of 4 charters!!")
	private String name;
	
	@Email(message="Email address is not valid!!")
	private String email;
	
	@NotEmpty
	@Size(min=3, max=10,message="Password must be min of 3 and max of 10 charters!!")
	private String password;
	
	@NotEmpty
	private String about;
	
	private Set<CommentDTO> comments=new HashSet<>();


}
