package com.payhub.ws.model;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import org.omg.CORBA.portable.OutputStream;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payhub.ws.api.SaleResponseInformation;
import com.payhub.ws.api.TransactionManager;
import com.payhub.ws.util.WsConnections;
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Sale extends WsConnections{
	
	private static final long serialVersionUID = 2178857785393382979L;

    public static final String SALE_ID_LINK = "sale/";
	
    public static final String CARD_DATA_FIELD = "card_data";

	public static final String MERCHANT_FIELD = "merchant";

	public static final String CUSTOMER_FIELD = "customer";

	public static final String BILL_FIELD = "bill";

	public static final String SALE_RESPONSE_FIELD = "saleResponse";

	public static final String NOT_SETTLED_STATE = "Not settled";

	public static final String SETTLED_STATE = "Settled";

	private String settlementStatus = NOT_SETTLED_STATE;
	@JsonIgnore
    private String url_basePath;
    @JsonIgnore
    private String url;
   /* public String _url {
        get { return this._url_basePath + this._url_operation; }
        set { if (value != null)this._url_basePath = value; }
    }
    */
    private Merchant merchant;
    private Customer customer;
    private Bill bill;
    private CardData card_data;
    
	private String getUrl_basePath() {
		return url_basePath;
	}
    
	private void setUrl_basePath(String _url_basePath) {
		this.url_basePath = _url_basePath;
	}

	public String getUrl() {
		return this.url_basePath+SALE_ID_LINK;
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

	public Sale(Merchant merchant, Bill bill, CardData card_data, Customer customer)
    {
        // TODO: Complete member initialization
        this.merchant = merchant;
        this.bill = bill;
        this.card_data = card_data;
        this.customer = customer;
    }

    public SaleResponseInformation doSale(String json, HttpURLConnection request) throws JsonParseException, JsonMappingException
    {
    	DataOutputStream wr;
    	SaleResponseInformation responseObject = new SaleResponseInformation(); 
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
	    		responseObject = mapper.readValue(result, SaleResponseInformation.class);
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
				    		responseObject = mapper.readValue(response.toString(), SaleResponseInformation.class);
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
