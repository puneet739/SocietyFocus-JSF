package com.fairdeal.portal.bean.filter;

import java.util.List;

public class Filter {
	private String name;
	private List<DisplayOption> displayOptions;

	public List<DisplayOption> getDisplayOptions() {
		return displayOptions;
	}

	public void setDisplayOptions(List<DisplayOption> displayOptions) {
		this.displayOptions = displayOptions;
	}

	public Filter(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
