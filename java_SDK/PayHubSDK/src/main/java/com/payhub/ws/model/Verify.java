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
import com.payhub.ws.api.VerfyResponseInformation;
import com.payhub.ws.util.WsConnections;

/**
 * @author agustin
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Verify extends WsConnections{
	public static String VERIFY_ID_LINK = "verify/";
	@JsonIgnore
    private String url_basePath;
	@JsonIgnore
    public String url;
    private Merchant merchant;
    private Customer customer;
    private CardData card_data;
    
    private String getUrl_basePath() {
		return url_basePath;
	}
    
	private void setUrl_basePath(String _url_basePath) {
		this.url_basePath = _url_basePath;
	}

	public String getUrl() {
		return this.url_basePath+VERIFY_ID_LINK;
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
	public CardData getCard_data() {
		return card_data;
	}
	public void setCard_data(CardData card_data) {
		this.card_data = card_data;
	}
	public Verify(Merchant merchant, CardData card_data, Customer customer)
    {
        // TODO: Complete member initialization
        this.merchant = merchant;
        this.card_data = card_data;
        this.customer = customer;
    }
    public VerfyResponseInformation performVerifyTransaction(String json, HttpURLConnection request)
    {

    	DataOutputStream wr;
    	VerfyResponseInformation responseObject = new VerfyResponseInformation(); 
		try {
			wr = new DataOutputStream(request.getOutputStream());
			wr.writeBytes(json);
			wr.flush();
			wr.close();						      
	        String result = doPost(request, this.getUrl());   
	        
	    	try {	    
	    		// read from file, convert it to user class
	    		ObjectMapper mapper = new ObjectMapper();
		        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	    		responseObject = mapper.readValue(result, VerfyResponseInformation.class);
	    		responseObject.setRowData(result);
	     
	    	} catch (JsonGenerationException e) {
	     
	    		e.printStackTrace();
	     
	    	}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			StringBuffer response = new StringBuffer();   
			try {
				BufferedReader er = new BufferedReader(new InputStreamReader(request.getErrorStream()));
             	String line;
             		int c = 0;
				     while((c = er.read()) != -1) {					         
				    	 response.append((char)c);
				     }					    
				     	ObjectMapper mapper = new ObjectMapper();
				        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
				    	try {	    
				    		// read from file, convert it to user class
				    		responseObject = mapper.readValue(response.toString(), VerfyResponseInformation.class);
				    		responseObject.setRowData(response.toString());
				     
				    	} catch (JsonGenerationException e) {
				     
				    		e.printStackTrace();
				     
				    	}	 
 				} catch (IOException e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
		}            
        return responseObject;
    
    }
}
