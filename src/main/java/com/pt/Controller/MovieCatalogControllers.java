package com.pt.Controller;

import com.pt.model.Movie;
import com.pt.models.CatalogItem;
import com.pt.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")

public class MovieCatalogControllers {
	
	RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping("/{userId}")
	
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		RestTemplate restTemplate = new RestTemplate();
		List<Rating> ratingList = Arrays.asList(
				new Rating("0123", 4),
				new Rating("4567", 2),
				new Rating("8901", 5)
		);
		
		return ratingList.stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://localhost:8081/movieCat/cat" +
							rating.getMovieId(),
					Movie.class);
			
			assert movie != null;
			return new CatalogItem(movie.getName(), "A educated movie for " +
					"upcoming engineers",
					rating.getRating());
		})
				.collect(Collectors.toList());
	}
}
