package com.blog.app.sevices;

import java.util.List;

import com.blog.app.entities.User;
import com.blog.app.playloads.UserDTO;

public interface UserService {

	// post
	UserDTO createUser(UserDTO userDto);

	// update
	UserDTO updateUser(UserDTO userDto, Integer userId);

	// get using id
	UserDTO getUserById(Integer userId);

	// get all data
	List<UserDTO> getAllUser();

	// delete
	void deleteUser(Integer userId);

}
