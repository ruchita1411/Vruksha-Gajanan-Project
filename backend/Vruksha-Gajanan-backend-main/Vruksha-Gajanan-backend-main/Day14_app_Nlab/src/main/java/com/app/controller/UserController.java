package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthDto;
import com.app.dto.ProductDto;
import com.app.dto.UserDto;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {
	
	@Autowired
	private UserService uService;


	@PostMapping("/create")
	public ResponseEntity<?> addNewUser(@RequestBody @Valid UserDto dto) {
		System.out.println("in add user " + dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(uService.addNewUser(dto));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?>  getList(){
		return ResponseEntity.ok(uService.getAllUsers());
	}
	
	
	//getby id
	
		@GetMapping("/getById/{id}")
		public ResponseEntity<?> getEntity(@PathVariable Long id){
			System.out.println("in get by id"+id);
			return ResponseEntity.ok(uService.getById(id));
		}
		
		
	//delete
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<?> deleteUser(@PathVariable Long id) {
			System.out.println("in delete user " + id);
			return ResponseEntity.ok(uService.deleteUserDetails(id));
		}
		
		//update
		
		@PutMapping("/update/{Id}")
		public ResponseEntity<?> updateProduct(@PathVariable Long Id, @RequestBody @Valid UserDto dto) {
			System.out.println("in update user " + Id + " " + dto);
			return ResponseEntity.ok(uService.updateUser(Id, dto));
		}
		
		
		//sign in
		@PostMapping("/sign-in")
		public ResponseEntity<?> loginUser(@RequestBody @Valid AuthDto authDto) {
			System.out.println(authDto);
			UserDto userDto = uService.loginUser(authDto);
			return ResponseEntity.status(HttpStatus.OK).body(userDto);
		}

}
