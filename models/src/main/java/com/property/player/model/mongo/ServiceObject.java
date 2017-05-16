package com.property.player.model.mongo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ServiceObject {
	
	@Id
	private Integer id;
	private String requestName;
	private String location;
	private String requestType;
	private String backgroundImage;
	private Facility[] inculdedFacilities;
	private Testimonial[] testimonials;
	private String[] promises;
	private String[] pricing;
	
	//SEO tags
	private Map<String,String> metaTags=new HashMap<String, String>();
	private String title;
	private String description;

	public String getRequestName() {
		return requestName;
	}

	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(String backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public Facility[] getInculdedFacilities() {
		return inculdedFacilities;
	}

	public void setInculdedFacilities(Facility[] inculdedFacilities) {
		this.inculdedFacilities = inculdedFacilities;
	}

	public Testimonial[] getTestimonials() {
		return testimonials;
	}

	public void setTestimonials(Testimonial[] testimonials) {
		this.testimonials = testimonials;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String[] getPromises() {
		return promises;
	}

	public void setPromises(String[] promises) {
		this.promises = promises;
	}

	public String[] getPricing() {
		return pricing;
	}

	public void setPricing(String[] pricing) {
		this.pricing = pricing;
	}

	public Map<String, String> getMetaTags() {
		return metaTags;
	}

	public void setMetaTags(Map<String, String> metaTags) {
		this.metaTags = metaTags;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

class Testimonial {
	private String userName;
	private String location;
	private String message;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

class Facility {
	private String imageUrl;
	private String text;
	private String description;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}