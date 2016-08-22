package com.property.player.model.generic;

public enum CusineEnum {
	NORTH_INDIAN("North Indian"),
	MUGHLAI("Mughlai"),
	SOUTH_INDIA("South Indian"),
	FAST_FOOD("Fast Food"),
	STREET_FOOD("Street Food"),
	SWEETS("Sweets"),
	DESERTS("Deserts"),
	MITHAT("Mithai"),
	CONTINENTAL("Continental"),
	ITALIAN("Italian"),
	HEALTHY_FOOD("Healthy Food")
	;
	
	private String displayName;  
	
	private CusineEnum(String title){
		this.displayName=title;
	}
}
