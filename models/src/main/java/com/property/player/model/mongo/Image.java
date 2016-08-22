package com.property.player.model.mongo;

public class Image {
	private String imagetitle;
	private String imagedescription;
	private String imageUrl;

	public Image(String imageUrl){
		this.imageUrl=imageUrl;
	}
	
	public String getImagetitle() {
		return imagetitle;
	}

	public void setImagetitle(String imagetitle) {
		this.imagetitle = imagetitle;
	}

	public String getImagedescription() {
		return imagedescription;
	}

	public void setImagedescription(String imagedescription) {
		this.imagedescription = imagedescription;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
