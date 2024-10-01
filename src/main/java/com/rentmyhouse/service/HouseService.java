package com.rentmyhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
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

	public PagedModel<House> getAllHouses(int page, int pageSize) {
		Pageable pageable = PageRequest.of(page, pageSize);

		Page<House> data = houseRepo.findAll(pageable);
		
		return new PagedModel<House>(data);
	}

}
