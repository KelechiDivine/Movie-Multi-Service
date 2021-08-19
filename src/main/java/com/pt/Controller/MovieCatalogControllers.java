package com.pt.Controller;

import com.pt.model.Movie;
import com.pt.models.CatalogItem;
import com.pt.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")

public class MovieCatalogControllers {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		WebClient.Builder builder = WebClient.builder();
		
		RestTemplate restTemplate = new RestTemplate();
		List<Rating> ratingList = Arrays.asList(
				new Rating("0123", 4),
				new Rating("4567", 2),
				new Rating("8901", 5)
		);
		
		return ratingList.stream().map(rating -> {
//			Movie movie = restTemplate.getForObject("http://localhost:8081/movieCat/foo" +
//							rating.getMovieId(),
//					Movie.class);
			
			Movie movie = webClientBuilder.build()
					.get()
					.uri("http://localhost:8081/movieCat/foo" +
							rating.getMovieId())
					.retrieve()
					.bodyToMono(Movie.class)
					.block();
			
			assert movie != null;
			return new CatalogItem(movie.getName(), "A educated movie for " +
					"upcoming engineers",
					rating.getRating());
		})
				.collect(Collectors.toList());
	}
}
