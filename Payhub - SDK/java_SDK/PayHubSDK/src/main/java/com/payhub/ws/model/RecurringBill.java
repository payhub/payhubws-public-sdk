/**
 * 
 */
package com.payhub.ws.model;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payhub.ws.api.AuthorizationResponseInformation;
import com.payhub.ws.api.RecurringBillResponseInformation;
import com.payhub.ws.util.WsConnections;

/**
 * @author agustin
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class RecurringBill extends WsConnections{
	 @JsonIgnore
    private String url_basePath;
	 @JsonIgnore
    public String url;
    private Merchant merchant;
    private Customer customer;
    private Bill bill;
    private CardData card_data;
    private Schedule schedule;
    public static String RECURRENT_BILL_ID_LINK = "recurring-bill/";
    private String getUrl_basePath() {
		return url_basePath;
	}
    
	private void setUrl_basePath(String _url_basePath) {
		this.url_basePath = _url_basePath;
	}

	public String getUrl() {
		return this.url_basePath+RECURRENT_BILL_ID_LINK;
	}

	public void setUrl(String _url) {
		this.url_basePath = _url;
	}
	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public CardData getCard_data() {
		return card_data;
	}

	public void setCard_data(CardData card_data) {
		this.card_data = card_data;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public RecurringBill(Merchant merchant, CardData card_data, Customer customer, Schedule schedule, Bill bill)
    {
        // TODO: Complete member initialization
        this.merchant = merchant;
        this.card_data = card_data;
        this.customer = customer;
        this.schedule = schedule;
        this.bill = bill;
    }

    public RecurringBillResponseInformation PerformRecurringBill(String json, HttpURLConnection request)
    {
    	RecurringBillResponseInformation responseObject = new RecurringBillResponseInformation();
    	DataOutputStream wr;
		
		try {
			wr = new DataOutputStream(request.getOutputStream());
			wr.writeBytes(json);
			wr.flush();
			wr.close();						      
	        String result = doPost(request, this.getUrl());   
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	    	try {	    
	    		// read from file, convert it to user class
	    		responseObject = mapper.readValue(result, RecurringBillResponseInformation.class);
	    		responseObject.setRowData(result);
	     
	    	} catch (JsonGenerationException e) {
	     
	    		e.printStackTrace();
	     
	    	}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			try {
				BufferedReader in1 = new BufferedReader(new InputStreamReader(request.getErrorStream()));
				String inputLine1;
				StringBuffer response1 = new StringBuffer();
				while ((inputLine1 = in1.readLine()) != null) {
					response1.append(inputLine1);
				}
					in1.close();
					ObjectMapper mapper = new ObjectMapper();
			        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			        responseObject = mapper.readValue(response1.toString(), RecurringBillResponseInformation.class);
					responseObject.setRowData(response1.toString());
				 	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}                    
        return responseObject;

    }
}
