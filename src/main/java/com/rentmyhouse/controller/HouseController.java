package com.rentmyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentmyhouse.dto.HouseRequest;
import com.rentmyhouse.model.House;
import com.rentmyhouse.model.User;
import com.rentmyhouse.service.HouseService;

@RestController
@RequestMapping("/api/v1/houses")
public class HouseController {

	@Autowired
	HouseService houseService;

	@PostMapping
	ResponseEntity<House> createHouse(@RequestBody HouseRequest reqData) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		House house = houseService.createHouse(reqData, user);

		return ResponseEntity.status(HttpStatus.CREATED).body(house);
	}

}
