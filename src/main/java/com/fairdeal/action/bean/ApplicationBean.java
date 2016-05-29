package com.fairdeal.action.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "applicationbean")
@Scope(value = "singleton")
public class ApplicationBean {

	public final String applicationurl="http://societyfocus.com/helpdesk";

	public String getApplicationurl() {
		return applicationurl;
	}
	
}
