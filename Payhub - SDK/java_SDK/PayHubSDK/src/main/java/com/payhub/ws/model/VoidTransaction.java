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
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payhub.ws.api.VoidResponseInformation;
import com.payhub.ws.util.WsConnections;

/**
 * @author agustin
 *
 */
public class VoidTransaction extends WsConnections{
	 @JsonIgnore
    private String url_basePath;
	 @JsonIgnore
    private String url;
    private Merchant merchant;
    private String transaction_id;
    public static String VOID_ID_LINK = "void/";
    
    private String getUrl_basePath() {
		return url_basePath;
	}
    
	private void setUrl_basePath(String _url_basePath) {
		this.url_basePath = _url_basePath;
	}

	public String getUrl() {
		return this.url_basePath+VOID_ID_LINK;
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

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public VoidTransaction(Merchant merchant, String saleId)
    {
        // TODO: Complete member initialization
        this.merchant = merchant;
        this.transaction_id = saleId;
    }

    public VoidResponseInformation performVoidTransaction(String json, HttpURLConnection request)
    {
    	DataOutputStream wr;
    	VoidResponseInformation responseObject = new VoidResponseInformation(); 
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
	    		responseObject = mapper.readValue(result, VoidResponseInformation.class);
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
			        responseObject = mapper.readValue(response1.toString(), VoidResponseInformation.class);
					responseObject.setRowData(response1.toString());
				 	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}                    
        return responseObject;
    }
}
