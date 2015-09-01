/**
 * 
 */
package com.payhub.ws.api;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.payhub.ws.model.CardData;
import com.payhub.ws.model.Merchant;
import com.payhub.ws.model.Metadata;
import com.payhub.ws.model.Schedule;

/**
 * @author agustin
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScheduleInformation extends AbstractInfo{	
	@JsonIgnore
	Schedule schedule;
	
	public ScheduleInformation() {
		super();
		this.transactionType=TransactionType.Schedule;
	}

	public ScheduleInformation(TransactionManager transactionManager) {
		super(transactionManager);
		this.transactionType=TransactionType.Schedule;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
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
    		setSchedule(mapper.readValue(json, Schedule.class));    		
     
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
        return url;
	}
}
