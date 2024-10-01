package com.rentmyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentmyhouse.dto.LoginRequest;
import com.rentmyhouse.dto.LoginResponse;
import com.rentmyhouse.dto.RegisterRequest;
import com.rentmyhouse.model.User;
import com.rentmyhouse.service.AuthenticationService;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

	@Autowired
	AuthenticationService authService;
	
	@PostMapping("/register")
	ResponseEntity<User> register(@RequestBody RegisterRequest reqData) {
		User user =  authService.register(reqData);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	@PostMapping("/sign-in")
	ResponseEntity<LoginResponse> signIn(@RequestBody LoginRequest reqData) {
		LoginResponse res = authService.signIn(reqData);
		
		return ResponseEntity.ok(res);
	}
}
