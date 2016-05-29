package com.fairdeal.bean.list;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fairdeal.action.bean.HelpdeskQuery;
import com.fairdeal.utility.GsonHelper;
import com.fairdeal.utility.LoggerUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Component(value = "helpdesklist")
@Scope(value = "session")
public class helpdesklist {

	RestTemplate restTemplate = new RestTemplate();
	private final String url = "http://zircon.com/zservice";
	Gson gson = GsonHelper.getBaseGsonBuilder().create();
	
	public List<HelpdeskQuery> heldeskquery;

	public List<HelpdeskQuery> getHeldeskquery() {
		return heldeskquery;
	}

	public void setHeldeskquery(List<HelpdeskQuery> heldeskquery) {
		this.heldeskquery = heldeskquery;
	}

	public void init() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");

		HttpEntity entity = new HttpEntity(headers);

		HttpEntity<JsonObject> response = restTemplate.exchange(url + "/helpdesk/get?page=0&size=10", HttpMethod.GET,
				entity, JsonObject.class);
		JsonObject jsonResponse = response.getBody();
		JsonArray objects  = jsonResponse.getAsJsonObject("body").getAsJsonArray("queries");
		
		List<HelpdeskQuery> query = new LinkedList<>();
		for(int i = 0; i < objects.size(); i++){
				JsonElement jsnObj = objects.get(i);               
				HelpdeskQuery obj = gson.fromJson(jsnObj, HelpdeskQuery.class);      
				query.add(obj);
	    }
		
		LoggerUtil.debug(query);
		heldeskquery=query;
		System.out.println("Calling init here");
	}
}
