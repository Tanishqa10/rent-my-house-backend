package com.rentmyhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentmyhouse.dto.HouseRequest;
import com.rentmyhouse.model.House;
import com.rentmyhouse.model.User;
import com.rentmyhouse.repository.HouseRepository;

@Service
public class HouseService {

	@Autowired
	HouseRepository houseRepo;
	
	public House createHouse(HouseRequest req, User user) {
		House house = new House();
		house.setAddress1(req.getAddress1());
		house.setAddress2(req.getAddress2());
		house.setPostCode(req.getPostCode());
		house.setExtras(req.getExtra());
		
		house.setCreator(user);
		
		houseRepo.save(house);
		
		return house;
	}
	
}
