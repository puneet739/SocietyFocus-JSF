package com.fairdeal.action.bean;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

import com.fairdeal.utility.Constants;
import com.fairdeal.utility.LoggerUtil;
import com.fairdeal.utility.Util;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Component(value = "forgotpassword")
@ViewScoped
public class forgotPasswordBean {

	private String emailAddress;
	private List<Society> societyList = new LinkedList<>();
	private String selectedSociety;
	private String secretKey;

	public void init() {
		JsonArray jsonResponse = Util.httpGetArrayRequest(Constants.SERVICE_URL + "/society/");
		LoggerUtil.debug(jsonResponse);
		societyList=new LinkedList<>();
		for (int i=0; i<jsonResponse.size(); i++){
			JsonElement societyObject = jsonResponse.get(i);
			String societyId = societyObject.getAsJsonObject().get("societyId").getAsString();
			String name = societyObject.getAsJsonObject().get("name").getAsString();
			societyList.add(new Society(societyId, name));
		}
	}

	public void generateRequest() throws IOException {
		LoggerUtil.debug("Request raised for forgot Password" + emailAddress + " and society:" + selectedSociety);
		JsonObject jsonObject = Util.httpGetRequest(Constants.SERVICE_URL + "/user/forgotPassword?email="+emailAddress+"&societyid="+selectedSociety);
		if (jsonObject!=null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Email has been sent to registered Email address for reset password",null));
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"User does not exist in this society, kindly check the email/society",null));
		}
	}

	public void completeRequest(){
		
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getSelectedSociety() {
		return selectedSociety;
	}

	public void setSelectedSociety(String selectedSociety) {
		this.selectedSociety = selectedSociety;
	}

	public List<Society> getSocietyList() {
		return societyList;
	}

	public void setSocietyList(List<Society> societyList) {
		this.societyList = societyList;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

}

