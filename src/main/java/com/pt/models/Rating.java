package com.pt.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Rating {
	
	private String movieId;
	private int rating;
	
}