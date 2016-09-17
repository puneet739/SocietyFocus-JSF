package com.fairdeal.bean.list;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fairdeal.action.bean.StoreBean;
import com.fairdeal.action.model.Suggestion;
import com.fairdeal.utility.Constants;
import com.fairdeal.utility.GsonHelper;
import com.fairdeal.utility.LoggerUtil;
import com.fairdeal.utility.Util;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Component(value = "suggestionlist")
@Scope(value = "request")
public class SuggestionList {
	private Gson gson = GsonHelper.getBaseGsonBuilder().create();
	private List<Suggestion> suggestionDetails;
	private String suggestionString;
	
	public List<Suggestion> initalizeSuggestions(String name){
		LoggerUtil.debug("Looking for suggestions "+name);
		suggestionDetails = new LinkedList<>();
		JsonObject jsonResponse = Util.httpGetRequest(Constants.SERVICE_URL + "/v1/storesuggestion?text="+name);
		JsonArray objects  = jsonResponse.getAsJsonArray("suggetions");
		
		
		for(int i = 0; i < objects.size(); i++){
			JsonElement jsnObj = objects.get(i);               
			Suggestion obj = gson.fromJson(jsnObj, Suggestion.class);      
			suggestionDetails.add(obj);
		}
		return suggestionDetails;
	}
	
	public void onItemSelect(SelectEvent event) throws IOException {
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		FacesContext.getCurrentInstance().getExternalContext().redirect((String)event.getObject());
    }

	public List<Suggestion> getSuggestionDetails() {
		return suggestionDetails;
	}

	public void setSuggestionDetails(List<Suggestion> suggestionDetails) {
		this.suggestionDetails = suggestionDetails;
	}



	public String getSuggestionString() {
		return suggestionString;
	}



	public void setSuggestionString(String suggestionString) {
		this.suggestionString = suggestionString;
	}

	
	
}
