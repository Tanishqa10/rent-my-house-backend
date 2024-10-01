package com.rentmyhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rentmyhouse.dto.LoginRequest;
import com.rentmyhouse.dto.LoginResponse;
import com.rentmyhouse.dto.RegisterRequest;
import com.rentmyhouse.model.User;
import com.rentmyhouse.repository.UserRepository;

@Service
public class AuthenticationService {
	
	@Autowired
	JwtService jwtService;

	@Autowired
	AuthenticationManager authManager;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepo;

	public User register(RegisterRequest req) {
		User user = new User();
		user.setFullName(req.getFullName());
		user.setEmail(req.getEmail());

		String password = passwordEncoder.encode(req.getPassword());

		user.setRole(req.getRole());
		user.setPassword(password);

		userRepo.save(user);

		return user;
	}

	public LoginResponse signIn(LoginRequest req) throws UsernameNotFoundException {
		authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));

		User user = userRepo.findByEmail(req.getEmail())
				.orElseThrow(() -> new UsernameNotFoundException("user not found!"));

		LoginResponse res = new LoginResponse();
		res.setRole(user.getRole());
		
		res.setToken(jwtService.createToken(user.getId()));
		
		return res;
	}

}
