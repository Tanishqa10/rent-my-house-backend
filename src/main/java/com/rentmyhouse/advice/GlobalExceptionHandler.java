package com.rentmyhouse.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rentmyhouse.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = { BadCredentialsException.class, AuthorizationDeniedException.class })
	ResponseEntity<ErrorResponse> forbiddenExceptionHandler(Exception e) {
		ErrorResponse res = new ErrorResponse();

		res.setStatus(403);
		res.setMessage(e.getMessage());

		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(res);
	}

}
