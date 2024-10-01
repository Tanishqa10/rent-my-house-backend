package com.rentmyhouse.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.rentmyhouse.enumerate.RoleEnum;

import lombok.Data;

@Data
@JsonPropertyOrder(alphabetic = true)
public class LoginResponse {

	String token;
	RoleEnum role;

}
