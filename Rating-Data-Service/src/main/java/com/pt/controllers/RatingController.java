package com.pt.controllers;

import com.pt.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsData")

public class RatingController {
	
	@RequestMapping("/{movieId}")
	
	public Rating getRatingInfo(@PathVariable("ratingId") String ratingId) {
		return new Rating(ratingId, 2);
	}
}
