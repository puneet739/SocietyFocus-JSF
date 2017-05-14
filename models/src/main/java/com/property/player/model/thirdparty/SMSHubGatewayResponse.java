package com.property.player.model.thirdparty;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SMSHubGatewayResponse {

	@SerializedName("ErrorCode")
	@Expose
	private String errorCode;
	@SerializedName("ErrorMessage")
	@Expose
	private String errorMessage;
	@SerializedName("JobId")
	@Expose
	private Object jobId;
	@SerializedName("MessageData")
	@Expose
	private Object messageData;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getJobId() {
		return jobId;
	}

	public void setJobId(Object jobId) {
		this.jobId = jobId;
	}

	public Object getMessageData() {
		return messageData;
	}

	public void setMessageData(Object messageData) {
		this.messageData = messageData;
	}
}
