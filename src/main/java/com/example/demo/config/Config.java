//package com.example.demo.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class Config implements WebMvcConfigurer {
//
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**")
//						.allowedOrigins("*")
//						.allowedMethods("GET","HEAD","POST","DELETE","OPTIONS","PUT")
//						.allowCredentials(true)
//						.maxAge(3600)
//						.allowedHeaders("*");
//	}
//}
