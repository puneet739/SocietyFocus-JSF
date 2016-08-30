package com.fairdeal.action.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fairdeal.utility.Constants;
import com.fairdeal.utility.Util;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Component(value = "storedetail")
@Scope(value = "request")
public class StoreDetailBean {

	private String storeId;
	private StoreBean storebean;

	public void fetchstore(String storeId){
//		JsonObject jsonResponse = Util.httpGetRequest(Constants.SERVICE_URL + "/v1/stores/storedetail?id="+storeId);
//		JsonArray objects  = jsonResponse.getAsJsonArray("stores");
	}
	
	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public StoreBean getStorebean() {
		return storebean;
	}

	public void setStorebean(StoreBean storebean) {
		this.storebean = storebean;
	}
}
