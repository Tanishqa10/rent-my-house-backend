package com.rentmyhouse.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder(alphabetic = true)
public class ErrorResponse {

	int status;
	String message;
	
}
