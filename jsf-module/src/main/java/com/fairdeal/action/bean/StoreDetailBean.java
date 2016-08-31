package com.fairdeal.action.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fairdeal.utility.Constants;
import com.fairdeal.utility.GsonHelper;
import com.fairdeal.utility.Util;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Component(value = "storedetail")
@Scope(value = "request")
public class StoreDetailBean {

	private Gson gson = GsonHelper.getBaseGsonBuilder().create();
	private String storeId;
	private StoreBean storebean;

	public void fetchstore(String storeId){
		JsonObject jsonResponse = Util.httpGetRequest(Constants.SERVICE_URL + "/v1/store/storedetail?id="+storeId);
		
		StoreBean storeObject = gson.fromJson(jsonResponse, StoreBean.class); 
		this.storebean= storeObject;
	
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
