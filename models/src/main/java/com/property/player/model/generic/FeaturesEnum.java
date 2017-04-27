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
	MEAL_VOUCHER("Meal Vouchers"),
	HOME_DELIVERY("Home Delivery"),
	SERVES_NON_VEG("Serves Non Veg"),
	FULL_BAR("Full Bar Available"),
	SMOKING("Smoking Area"),
	OUTDOOR_SEATING("Outdoor Seating"),
	WIFI("Wifi"),
	ALL_DAY_BREAKFAST("All Day Breakfast"),
	LIVE_SCREENING("Live Sports Screening"),
	LIVE_MUSIC("Live Music"),
	VALLET("Valet Parking Available"),
	GROUP_MEAIL("Group Meal"),
	BUFFET("Buffet"),
	Live("Live Entertainment"),
	PAID_PARKING("Paid Parking"),
	FREE_PARKING("Free Parking"),
	WHEELCHAIR("Wheelchair Accessible"),
	WALLET("Wallet Accepted"),
	WINE_BEER("Wine and Beer"),
	KID("Kid Friendly"),
	VEG_FOOD("Vegetarian Only"),
	JAIN_FOOD("Serves Jain Food"),
	ROOFTOP("Rooftop"),
	KAROKE("Karaoke"),
	
	
	;
	
	private String displayName;  
	
	public static FeaturesEnum fromString(String text) {
		for (FeaturesEnum b : FeaturesEnum.values()) {
			if (b.displayName.equalsIgnoreCase(text)) {
				return b;
			}
		}
		System.out.println("NOT ABLE TO FIND THE VALUE FOR ::: "+text);
		return null;
	}
	  
	private FeaturesEnum(String title){
		this.displayName=title;
	}
}
