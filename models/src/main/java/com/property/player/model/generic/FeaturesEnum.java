package com.property.player.model.generic;

public enum FeaturesEnum {
	CASH("Cash"),
	LUNCH("Lunch"),
	BREAKFAST("Breakfast"),
	DINNER("Dinner"),
	INDOOR("Indoor"),
	LUXURY_DINNING("Luxury Dinning"),
	TAKE_AWAY("Take Away"),
	NIGHTLIFE("Nightlife"),
	CAFE("Cafe"),
	CREDIT_CARD("Credit Card"),
	MEAL_VOUCHER("Meal Vouchers")
	;
	
	private String displayName;  
	
	private FeaturesEnum(String title){
		this.displayName=title;
	}
}
