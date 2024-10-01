package com.rentmyhouse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HouseRequest {

	@JsonProperty("address_1")
	@NotBlank
	private String address1;
	
	@JsonProperty("address_2")
	private String address2;
	
	@JsonProperty("post_code")
	@NotBlank
	private String postCode;
	
	private String extra;
}
