package com.example.demo.model.menu;

import lombok.Data;

import java.util.List;

@Data
public class MenuVo {
	
	private Integer id;
	
	private String en;
	
	private String zn;
	
	private String index;
	
	private String faIndex;
	
	
	private List<MenuVo> childList;
	
}
