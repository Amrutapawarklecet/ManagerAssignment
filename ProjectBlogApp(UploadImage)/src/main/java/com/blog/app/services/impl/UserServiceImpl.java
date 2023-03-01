package com.blog.app.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.app.entities.User;
import com.blog.app.exceptions.ResourceNotFoundExpection;
import com.blog.app.playloads.UserDTO;
import com.blog.app.repositories.UserRepo;
import com.blog.app.sevices.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	//Post or create new method
	@Override
	public UserDTO createUser(UserDTO userDto) {
	
		//convert dto to user
		User user=dtoToUser(userDto);
		//save the data
		User savedUser=userRepo.save(user);
		//again convert into user to dto
		return userToDto(savedUser);
	}

	//upadteUser
	@Override
	public UserDTO updateUser(UserDTO userDto, Integer userId) {
		
		//get userId
		User user=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundExpection("User", "id",userId));
		
		//set the values
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		//save the data
		User updateUser=userRepo.save(user);
		
		//again convert user to dto
		return userToDto(updateUser);
	}

	//get by id
	@Override
	public UserDTO getUserById(Integer userId) {
		
		//find by the id
		User user=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundExpection("User", "id",userId));
		//convert user to dto
		return userToDto(user);
	}

	//get all users values
	@Override
	public List<UserDTO> getAllUser() {
		
		//find all 
		List<User> users=userRepo.findAll();
		//convert one by one user list values into users dto list
		List<UserDTO> userDtos=users.stream().map(user->userToDto(user)).collect(Collectors.toList());
		
		return userDtos;
	}

	//delete users
	@Override
	public void deleteUser(Integer userId) {
		
		//find by the id
		User user=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundExpection("User", "id",userId));
		//delete the user
		userRepo.delete(user);
		
	}
	
	//dto to user convert
	public User dtoToUser(UserDTO userDto) {
		
		User user=modelmapper.map(userDto, User.class);
		
		/*User user=new User();
		user.setUserId(userDto.getUserId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());*/
		
		 return user;
		
	}
	
	//user to dto convert
	public UserDTO userToDto(User user) {
		
		UserDTO userdto= modelmapper.map(user, UserDTO.class);
		
		/*UserDTO userdto=new UserDTO();
		userdto.setUserId(user.getUserId());
		userdto.setName(user.getName());
		userdto.setEmail(user.getEmail());
		userdto.setPassword(user.getPassword());
		userdto.setAbout(user.getAbout());*/
		
		 return userdto;
	}

}
