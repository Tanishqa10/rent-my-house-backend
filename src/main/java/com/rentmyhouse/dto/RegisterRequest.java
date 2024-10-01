package com.rentmyhouse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rentmyhouse.enumerate.RoleEnum;

import lombok.Data;

@Data
public class RegisterRequest {
	
	@JsonProperty("full_name")
	String fullName;
	
	String email;
	String password;
	
	RoleEnum role;
}
