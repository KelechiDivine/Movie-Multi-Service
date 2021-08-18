package com.pt.ratingdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RatingDataServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RatingDataServiceApplication.class, args);
		System.out.println("Rating application finished loading...");
	}
	
}
