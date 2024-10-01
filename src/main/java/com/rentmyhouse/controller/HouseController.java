package com.rentmyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		House house = houseService.createHouse(reqData, user);

		return ResponseEntity.status(HttpStatus.CREATED).body(house);
	}

	@GetMapping
	ResponseEntity<PagedModel<House>> getAllHouses(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int pageSize) {
		PagedModel<House> data = houseService.getAllHouses(page, pageSize);
		return ResponseEntity.ok(data);
	}

}
