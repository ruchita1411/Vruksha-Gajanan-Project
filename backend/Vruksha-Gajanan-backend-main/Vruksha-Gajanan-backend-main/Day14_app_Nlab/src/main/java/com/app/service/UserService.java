package com.app.service;

import java.util.List;
import com.app.dto.ApiResponse;
import com.app.dto.AuthDto;
import com.app.dto.ProductDto;
import com.app.dto.UserDto;

public interface UserService  {
	
	//create
	UserDto addNewUser(UserDto udto);

	//getall
	List<UserDto> getAllUsers();


	//getby id
		UserDto getById(Long id);
		
	//del users
		ApiResponse deleteUserDetails(Long id);

	//update
		UserDto updateUser(Long id, UserDto dto);

	//sign in
		UserDto loginUser(AuthDto authDto);
}
