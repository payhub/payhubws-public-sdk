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
import com.payhub.ws.util.WsConnections;

/**
 * @author agustin
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class AuthOnly extends WsConnections{

	 public static String AUTH_ID_LINK = "authonly/";
	 @JsonIgnore
     private String url_basePath;
	 @JsonIgnore
     public String url;
     private Merchant merchant;
     private Customer customer;     
     private Bill bill;     
     private CardData card_data;
     
     
     public String getUrl_basePath() {
		return url_basePath;
	}

	public void setUrl_basePath(String url_basePath) {
		this.url_basePath = url_basePath;
	}

	public String getUrl() {
		return this.url_basePath+AUTH_ID_LINK;
	}

	public void setUrl(String url) {
		this.url_basePath = url;
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

	public AuthOnly(Merchant merchant, Bill bill, CardData card_data,Customer customer)
     {
         this.merchant = merchant;
         this.bill = bill;
         this.card_data = card_data;
         this.customer = customer;
     }

	public AuthorizationResponseInformation authOnly(String json,HttpURLConnection request) {
		DataOutputStream wr;
		AuthorizationResponseInformation responseObject = new AuthorizationResponseInformation(); 
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
	    		responseObject = mapper.readValue(result, AuthorizationResponseInformation.class);
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
			        responseObject = mapper.readValue(response1.toString(), AuthorizationResponseInformation.class);
					responseObject.setRowData(response1.toString());
				 	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}                    
        return responseObject;
	}

}
