package com.rentmyhouse.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
	
	@Email(message = "Invalid email format")
	String email;
	
	@NotBlank
	String password;
}
