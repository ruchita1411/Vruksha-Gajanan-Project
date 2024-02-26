package com.app.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {
	
//	@JsonProperty(access = Access.READ_ONLY) // used during serialization
//	private Long id;
//	
	@NotBlank
	private String name;
	
	@Email
	private String email;
	
	@JsonProperty(access = Access.WRITE_ONLY) //required only in de-ser.
	private String password;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String confirmPassword;
	
	private String address;
	
	private String phone;
	
	
	

}
