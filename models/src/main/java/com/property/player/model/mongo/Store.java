package com.property.player.model.mongo;


import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.property.player.model.generic.CategoryEnum;
import com.property.player.model.generic.CusineEnum;
import com.property.player.model.generic.StatusEnum;


@Document
public class Store {
	private String storeid;
	private Location location;
	private String name;
	private String description;
	private String address;
	private List<CusineEnum> cusines;
	private String promotion;
	private double costForTwo;
	private String videoUrl;
	private List<Image> menu_image;
	private List<Image> storeImages;
	private List<Image> user_images;
	private Image backgroundImage;
	private String detail1;
	private String detail2;
	private String detail3;
	private float rating;
	private double views;
	private List<String> phoneNo;
	private double scoring;
	private Date createdDate;
	private Date modifiedDate;
	private StatusEnum status;
	private CategoryEnum category;
	
	
	public String getStoreid() {
		return storeid;
	}

	public void setStoreid(String storeid) {
		this.storeid = storeid;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<CusineEnum> getCusines() {
		return cusines;
	}

	public void setCusines(List<CusineEnum> cusines) {
		this.cusines = cusines;
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public double getCostForTwo() {
		return costForTwo;
	}

	public void setCostForTwo(double costForTwo) {
		this.costForTwo = costForTwo;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public List<Image> getMenu_image() {
		return menu_image;
	}

	public void setMenu_image(List<Image> menu_image) {
		this.menu_image = menu_image;
	}

	public List<Image> getStoreImages() {
		return storeImages;
	}

	public void setStoreImages(List<Image> storeImages) {
		this.storeImages = storeImages;
	}

	public List<Image> getUser_images() {
		return user_images;
	}

	public void setUser_images(List<Image> user_images) {
		this.user_images = user_images;
	}

	public Image getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public String getDetail1() {
		return detail1;
	}

	public void setDetail1(String detail1) {
		this.detail1 = detail1;
	}

	public String getDetail2() {
		return detail2;
	}

	public void setDetail2(String detail2) {
		this.detail2 = detail2;
	}

	public String getDetail3() {
		return detail3;
	}

	public void setDetail3(String detail3) {
		this.detail3 = detail3;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public List<String> getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(List<String> phoneNo) {
		this.phoneNo = phoneNo;
	}

	public double getScoring() {
		return scoring;
	}

	public void setScoring(double scoring) {
		this.scoring = scoring;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public CategoryEnum getCategory() {
		return category;
	}

	public void setCategory(CategoryEnum category) {
		this.category = category;
	}
	
}
