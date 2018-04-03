package com.example.hero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HeroApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(HeroApplication.class, args);
	}

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/heros/**").allowedOrigins("http://localhost:4200").allowedMethods("PUT", "GET", "DELETE", "POST");
  }
}

