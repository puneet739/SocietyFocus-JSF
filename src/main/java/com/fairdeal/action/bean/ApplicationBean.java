package com.fairdeal.action.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "applicationbean")
@Scope(value = "singleton")
public class ApplicationBean {

	public final String applicationurl="http://societyfocus.com/helpdesk";
//	public final String applicationurl="http://localhost:8080/zircon-portal/views";

	public String getApplicationurl() {
		return applicationurl;
	}
	
}
