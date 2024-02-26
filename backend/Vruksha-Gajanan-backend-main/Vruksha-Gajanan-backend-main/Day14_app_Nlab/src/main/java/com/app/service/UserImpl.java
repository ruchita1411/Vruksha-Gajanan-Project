package com.app.service;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ApiException;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.UserDao;
import com.app.dto.ApiResponse;
import com.app.dto.AuthDto;
import com.app.dto.ProductDto;
import com.app.dto.UserDto;
import com.app.entities.Product;
import com.app.entities.User;

@Service
@Transactional
public class UserImpl implements UserService {
	
	@Autowired
	private UserDao udao;
	
	@Autowired
	private ModelMapper mm;

	@Override
	public UserDto addNewUser(UserDto udto) {
		
			// validate confirm password
			if (udto.getPassword().equals(udto.getConfirmPassword())) {
				User u1 = mm.map(udto, User.class);
				User saveduser = udao.save(u1);
				System.out.println("user entity id " + u1.getId() + " " + saveduser.getId());
				return mm.map(saveduser, UserDto.class);			
			}
			throw new ApiException("Passwords don't match");

		}

	@Override
	public List<UserDto> getAllUsers() {
		return udao.findAll()
				.stream()
				.map((s)->mm.map(s,UserDto.class))
				.collect(Collectors.toList());

	}

	@Override
	public UserDto getById(Long id) {
		
			User u1 = udao.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Invalid user ID(no such user with given id!!!  with id = " +id));
			
			return mm.map(u1, UserDto.class);
		
		}

	@Override
	public ApiResponse deleteUserDetails(Long id) {
		User u1 = udao.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Invalid id(no user found with given id)"));

		udao.deleteById(id);// yet to be tested
		udao.delete(u1);// yet to be tested
		return new ApiResponse("Product Details of user with ID " + u1.getId() + " deleted....");
	
	}

	@Override
	public UserDto updateUser(Long id, UserDto newdto) {
		User oldu1= udao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid user ID , user not found !!!!"));
		// => user exists
		// validate confirm password
		if (newdto.getPassword().equals(newdto.getConfirmPassword())) {
			
			System.out.println(newdto);
			
			oldu1.setAddress(newdto.getAddress());
			oldu1.setEmail(newdto.getEmail());
			oldu1.setName(newdto.getName());
			oldu1.setPassword(newdto.getPassword());
			oldu1.setPhone(newdto.getPhone());
			
			User save=udao.save(oldu1);
			
			mm.map(newdto, save);
			System.out.println("after mapping " + save);
			System.out.println("");
			return newdto;
			

		}
		throw new ApiException("Passwords don't match");
		
		
		
	}

	@Override
	public UserDto loginUser(AuthDto authDto) {
		User user = udao.findByEmailAndPassword(authDto.getEmail(), authDto.getPassword());

		if (user != null) {			
			UserDto userDto = mm.map(user, UserDto.class);
			
			
			return userDto;
		} 
		else {
			throw new ResourceNotFoundException("No such user exists with that email and password!!");
		}
	}
	}
	


