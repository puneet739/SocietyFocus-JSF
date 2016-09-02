package com.fairdeal.portal.bean.filter;

public class DisplayOption {
	private String name;
	private String displayresult;
	private String url;

	
	public DisplayOption(String name, String count, String url) {
		super();
		this.name = name;
		this.displayresult = count;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDisplayresult() {
		return displayresult;
	}

	public void setDisplayresult(String displayresult) {
		this.displayresult = displayresult;
	}

}
