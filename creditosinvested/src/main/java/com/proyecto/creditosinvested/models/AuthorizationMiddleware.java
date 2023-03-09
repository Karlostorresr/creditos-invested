package com.proyecto.creditosinvested.models;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthorizationMiddleware implements HandlerInterceptor {
	@Override
	public boolean preHandle (HttpServletRequest request,HttpServletResponse response, Object handler ) throws IOException {
		System.out.println("Proccesing method HTTP");
		String authToken = request.getHeader("application_token");
		
		if(authToken != null && authToken.equals("mypassword")) {
			System.out.println("Authorized");
			return true;
		} else {		
			System.out.println("Unauthorized");
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			return false;
		}
	}
	
	
	
	
}