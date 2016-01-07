package com.payhub.ws.vt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WebhookConfiguration{
	public static final String WEBHOOK_LINK = "adminSettings/webhookConfiguration";

    private String endPoint;

    private Boolean mobileHub;

    private Boolean recurringBill;

    private Boolean virtualHub;

    private Boolean webhookActive;

    private Boolean api;

    private Boolean batchIsActive;

	/**
	 * @return the endPoint
	 */
	public String getEndPoint() {
		return endPoint;
	}

	/**
	 * @param endPoint the endPoint to set
	 */
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	/**
	 * @return the mobileHub
	 */ 
	public Boolean getMobileHub() {
		return mobileHub;
	}

	/**
	 * @param mobileHub the mobileHub to set
	 */
	public void setMobileHub(Boolean mobileHub) {
		this.mobileHub = mobileHub;
	}

	/**
	 * @return the recurringBill
	 */ 
	public Boolean getRecurringBill() {
		return recurringBill;
	}

	/**
	 * @param recurringBill the recurringBill to set
	 */
	public void setRecurringBill(Boolean recurringBill) {
		this.recurringBill = recurringBill;
	}
	
	/**
	 * @return the virtualHub
	 */
	public Boolean getVirtualHub() {
		return virtualHub;
	}

	/**
	 * @param virtualHub the virtualHub to set
	 */
	public void setVirtualHub(Boolean virtualHub) {
		this.virtualHub = virtualHub;
	}

	/**
	 * @return the webhookActive
	 */  
	public Boolean getWebhookActive() {
		return webhookActive;
	}

	/**
	 * @param webhookActive the webhookActive to set
	 */
	public void setWebhookActive(Boolean webhookActive) {
		this.webhookActive = webhookActive;
	}

	/**
	 * @return the api
	 */  
	public Boolean getApi() {
		return api;
	}

	/**
	 * @param api the api to set
	 */
	public void setApi(Boolean api) {
		this.api = api;
	}

	/**
	 * @return the batchIsActive
	 */
	public Boolean getBatchIsActive() {
		return batchIsActive;
	}

	/**
	 * @param batchIsActive the batchIsActive to set
	 */
	public void setBatchIsActive(Boolean batchIsActive) {
		this.batchIsActive = batchIsActive;
	}
    
	public String toString(){
		ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        String jsonInString;
		try {
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
			return jsonInString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return null;
		}
        
	}
    
}
