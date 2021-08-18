package com.pt.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class CatalogItem {
	
	private String titleOfMovie;
	private String description;
	private int rating;
	
}
