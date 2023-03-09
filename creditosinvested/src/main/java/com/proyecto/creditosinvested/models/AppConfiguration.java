package com.proyecto.creditosinvested.models;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class AppConfiguration extends WebMvcConfigurationSupport {
	
	@Override
	
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthorizationMiddleware()).addPathPatterns("/**");
		
	}
	
	

}
