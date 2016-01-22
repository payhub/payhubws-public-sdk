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
import com.payhub.ws.api.RefundInformation;
import com.payhub.ws.util.WsConnections;

/**
 * @author agustin
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)  
public class Refund extends WsConnections{
	public static String REFUND_ID_LINK = "refund/";
	@JsonIgnore
    private String url_basePath;
	@JsonIgnore
    public String url;
    private String transaction_id;
    private Merchant merchant;
    private String record_format;
    private Bill bill;
    private Customer customer;
    private CardData card_data;
    
    private String getUrl_basePath() {
		return url_basePath;
	}
    
	private void setUrl_basePath(String _url_basePath) {
		this.url_basePath = _url_basePath;
	}

	public String getUrl() {
		return this.url_basePath+REFUND_ID_LINK;
	}

	public void setUrl(String _url) {
		this.url_basePath = _url;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	public String getRecord_format() {
		return record_format;
	}
	public void setRecord_format(String record_format) {
		this.record_format = record_format;
	}
	
	
	
	/**
	 * @return the bill
	 */
	public Bill getBill() {
		return bill;
	}

	/**
	 * @param bill the bill to set
	 */
	public void setBill(Bill bill) {
		this.bill = bill;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the card_data
	 */
	public CardData getCard_data() {
		return card_data;
	}

	/**
	 * @param card_data the card_data to set
	 */
	public void setCard_data(CardData card_data) {
		this.card_data = card_data;
	}

	public Refund(Merchant merchant, String transaction_id, String record_format)
    {
        // TODO: Complete member initialization
        this.merchant = merchant;
        this.transaction_id = transaction_id;
        this.record_format = record_format;
    }
	public Refund(Merchant merchant, String transaction_id, String record_format,Bill bill)
    {
        // TODO: Complete member initialization
        this.merchant = merchant;
        this.transaction_id = transaction_id;
        this.record_format = record_format;
        this.bill=bill;
    }
	public Refund(Merchant merchant, String record_format,Bill bill,Customer customer,CardData card)
    {
        // TODO: Complete member initialization
        this.merchant = merchant;
        this.record_format = record_format;
        this.bill = bill;
        this.customer = customer;
        this.card_data = card;
    }
    public RefundInformation PerformRefund(String json, HttpURLConnection request)
    {
    	DataOutputStream wr;
    	RefundInformation responseObject = new RefundInformation(); 
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
	    		responseObject = mapper.readValue(result, RefundInformation.class);
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
				    		responseObject = mapper.readValue(response.toString(), RefundInformation.class);
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
