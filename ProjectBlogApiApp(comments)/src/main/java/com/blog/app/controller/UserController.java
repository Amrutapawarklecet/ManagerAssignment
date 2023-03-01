package com.blog.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blog.app.playloads.CategoryDTO;
import com.blog.app.playloads.ApiResponse;
import com.blog.app.playloads.UserDTO;
import com.blog.app.sevices.UserService;

@RestController
@RequestMapping("/api/users/")
public class UserController {

	@Autowired
	private UserService userService;

	// POST- crate new user
	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userdto) {

		UserDTO createUser = userService.createUser(userdto);

		return new ResponseEntity<UserDTO>(createUser, HttpStatus.CREATED);

	}

	// PUT- update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDto, @PathVariable Integer userId) {

		UserDTO updateUser = userService.updateUser(userDto, userId);
		return new ResponseEntity<UserDTO>(updateUser, HttpStatus.OK);
	}

	// GET- get by id
	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userId) {

		UserDTO getUser = userService.getUserById(userId);
		return new ResponseEntity<UserDTO>(getUser, HttpStatus.OK);

	}

	// GET- get all users
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> getAllUser() {

		List<UserDTO> getAllusers = userService.getAllUser();
//		return new ResponseEntity<List<UserDTO>>(getAllusers,HttpStatus.OK);
		return ResponseEntity.ok(getAllusers);
	}

	// DELETE- delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId) {

		userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
	}

}
