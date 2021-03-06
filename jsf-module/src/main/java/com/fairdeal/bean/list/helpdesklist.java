package com.fairdeal.bean.list;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fairdeal.action.bean.HelpdeskQuery;
import com.fairdeal.utility.Constants;
import com.fairdeal.utility.GsonHelper;
import com.fairdeal.utility.LoggerUtil;
import com.fairdeal.utility.Util;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Component(value = "helpdesklist")
@Scope(value = "session")
public class helpdesklist {

	RestTemplate restTemplate = new RestTemplate();
	Gson gson = GsonHelper.getBaseGsonBuilder().create();
	
	public List<HelpdeskQuery> heldeskquery;
	public HelpdeskQuery singleQuery;
	public String queryid;
	
	
	public String getQueryid() {
		return queryid;
	}

	public void setQueryid(String queryid) {
		this.queryid = queryid;
	}

	public List<HelpdeskQuery> getHeldeskquery() {
		return heldeskquery;
	}

	public void setHeldeskquery(List<HelpdeskQuery> heldeskquery) {
		this.heldeskquery = heldeskquery;
	}

	public HelpdeskQuery getSingleQuery() {
		return singleQuery;
	}

	public void setSingleQuery(HelpdeskQuery singleQuery) {
		this.singleQuery = singleQuery;
	}

	public void init() {
		
		JsonObject jsonResponse = Util.httpGetRequest(Constants.SERVICE_URL + "/helpdesk/get?page=0&size=50");
		JsonArray objects  = jsonResponse.getAsJsonArray("queries");
		
		List<HelpdeskQuery> query = new LinkedList<>();
		for(int i = 0; i < objects.size(); i++){
				JsonElement jsnObj = objects.get(i);               
				HelpdeskQuery obj = gson.fromJson(jsnObj, HelpdeskQuery.class);      
				query.add(obj);
	    }
		
		LoggerUtil.debug(query);
		heldeskquery=query;
		LoggerUtil.debug("Calling init here");
	}
	
	public void getQuery() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");

		HttpEntity entity = new HttpEntity(headers);
		HttpEntity<JsonObject> response = restTemplate.exchange(Constants.SERVICE_URL + "/helpdesk/getbyid/"+queryid, HttpMethod.GET,
				entity, JsonObject.class);
		JsonObject jsonResponse = response.getBody();
		
		JsonObject object = jsonResponse.getAsJsonObject("body");
		HelpdeskQuery obj = gson.fromJson(object, HelpdeskQuery.class); 
		singleQuery=obj;
		LoggerUtil.debug("Response received is "+object);
		LoggerUtil.debug("Trying to fetch the query details with query id as "+queryid);
	}

}
