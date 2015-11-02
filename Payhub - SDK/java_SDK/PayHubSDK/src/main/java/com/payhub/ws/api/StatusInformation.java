package com.payhub.ws.api;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payhub.ws.model.Status;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusInformation extends AbstractInfo{	
	@JsonIgnore
	Status status;
	
	public StatusInformation() {
		super();
		this.transactionType=TransactionType.Status;
	}

	public StatusInformation(TransactionManager transactionManager) {
		super(transactionManager);
		this.transactionType=TransactionType.Status;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public TransactionManager getTransactionManager() {
		return transactionManager;
	}
	public void setTransactionManager(TransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Override
	public void convertData(String json) throws JsonParseException,
			JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    	try {	    
    		// read from file, convert it to user class
    		setStatus(mapper.readValue(json, Status.class));    		
     
    	} catch (JsonGenerationException e) {     
    		e.printStackTrace();     
    	}
	}
	@Override
	public String getUrlForTransactionType(TransactionType type) {
		String url=null;
		if(TransactionType.Sale.equals(type)){
        	url =  "sale/";
        }
		if(TransactionType.AuthOnly.equals(type)){
        	url =  "authonly/";
        }
        if(TransactionType.Capture.equals(type)){
        	url =  "capture/";
        }if(TransactionType.Bill.equals(type)){
        	url =  "bill";
        }if(TransactionType.CardData.equals(type)){
        	url =  "carddata/";
        }if(TransactionType.Customer.equals(type)){
        	url =  "customer/";
        }if(TransactionType.Merchant.equals(type)){
        	url =  "merchant/";
        }if(TransactionType.RecurringBill.equals(type)){
        	url =  "recurring-bill/";
        }if(TransactionType.Schedule.equals(type)){
        	url =  "schedule/";
        }if(TransactionType.Refund.equals(type)){
        	url =  "refund/";
        }if(TransactionType.VoidTransaction.equals(type)){
        	url =  "void/";
        }
        if(TransactionType.Verify.equals(type)){
        	url =  "verify/";
        }
        if(TransactionType.Status.equals(type)){
        	url =  "status/";
        }
        return url;
	}
}
