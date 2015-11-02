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
import com.payhub.ws.api.CaptureResponseInformation;
import com.payhub.ws.api.CaptureResponseInformation;
import com.payhub.ws.util.WsConnections;

/**
 * @author agustin
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)  
public class Capture extends WsConnections{
	@JsonIgnore
    private String url_basePath;
	@JsonIgnore
    public String url;
    private Merchant merchant;
    private String transaction_id;
    private Bill bill;
    public static String CAPTURE_ID_LINK = "capture/";
    
    public Capture(){}
    public Capture(Merchant merchant, String transactionId, Bill bill)
    {
        // TODO: Complete member initialization
        this.merchant = merchant;
        this.transaction_id = transactionId;
        this.bill = bill;
    }
    
    
    public String getUrl_basePath() {
		return url_basePath;
	}

	public void setUrl_basePath(String url_basePath) {
		this.url_basePath = url_basePath;
	}

	public String getUrl() {
		return this.url_basePath+CAPTURE_ID_LINK;
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
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public CaptureResponseInformation captureData(String json, HttpURLConnection request)
    {
		DataOutputStream wr;
		CaptureResponseInformation responseObject = new CaptureResponseInformation(); 
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
	    		responseObject = mapper.readValue(result, CaptureResponseInformation.class);
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
			        responseObject = mapper.readValue(response1.toString(), CaptureResponseInformation.class);
					responseObject.setRowData(response1.toString());
				 	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}                    
        return responseObject;       
    }
}
