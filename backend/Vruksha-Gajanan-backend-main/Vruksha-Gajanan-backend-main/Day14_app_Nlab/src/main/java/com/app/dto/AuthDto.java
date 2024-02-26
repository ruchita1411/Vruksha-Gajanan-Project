package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthDto {
	
	
	
		@Email(message = "Invalid email address")
		private String email;
		@NotBlank
		private String password;
	

}
