package com.example.demo.model;

import lombok.Data;

@Data
public class Good {
	private Integer id;
	
	private String name;
	
	private String type;
	
	private Integer price;
	
	private Integer size;
	
	private String status;

	private String description;
}
