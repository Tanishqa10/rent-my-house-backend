package com.rentmyhouse.service;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	@Value("${security.jwt.secret-key}")
	private String secretKey;
	
	@Value("${security.jwt.expiration-time}")
	private long expirationTime;
	
	public String createToken(Long userId) {
		return Jwts
				.builder()
				.subject(userId.toString())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + expirationTime))
				.signWith(getSignInKey())
				.compact();
	}
	
	public String extractToken(String token) {
		return Jwts
				.parser()
				.verifyWith(getSignInKey())
				.build()
				.parseSignedClaims(token)
				.getPayload().getSubject();
	}
	
	private SecretKey getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
