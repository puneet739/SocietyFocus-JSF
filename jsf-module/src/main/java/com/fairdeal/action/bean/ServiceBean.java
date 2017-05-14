package com.fairdeal.action.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fairdeal.utility.Constants;
import com.fairdeal.utility.GsonHelper;
import com.fairdeal.utility.Util;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.property.player.model.mongo.ServiceObject;

@Component(value = "servicebean")
@Scope(value = "request")
public class ServiceBean{

	private Gson gson = GsonHelper.getBaseGsonBuilder().create();
	private ServiceObject service;
	private String serviceId;

	
	public void fetchService(String storeId){
		JsonObject jsonResponse = Util.httpGetRequest(Constants.SERVICE_URL + "/v1/openrequest/serviceDetail?id="+storeId);
		
		ServiceObject serviceObject = gson.fromJson(jsonResponse, ServiceObject.class); 
		this.service= serviceObject;
	}


	public ServiceObject getService() {
		return service;
	}


	public void setService(ServiceObject service) {
		this.service = service;
	}


	public String getServiceId() {
		return serviceId;
	}


	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	
}