package com.fairdeal.utility;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;

public class Util {

	private static RestTemplate restTemplate = new RestTemplate();
	
	public static JsonObject httpGetRequest(String url ){
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");

		HttpEntity entity = new HttpEntity(headers);

		HttpEntity<JsonObject> response = restTemplate.exchange(url, HttpMethod.GET,
				entity, JsonObject.class);
		JsonObject jsonResponse = response.getBody();
		JsonObject object  = jsonResponse.getAsJsonObject("body");
		return object;
	}
}
