package org.ljaeh.boook.backend.service;

import io.jsonwebtoken.Claims;

public interface JwtService {
	String getToken(String key , Object value);
	
	Claims getClaims(String token);
}
