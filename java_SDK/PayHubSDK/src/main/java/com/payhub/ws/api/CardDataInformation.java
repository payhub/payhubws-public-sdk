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
import com.payhub.ws.model.Bill;
import com.payhub.ws.model.CardData;
import com.payhub.ws.model.Metadata;

/**
 * @author agustin
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardDataInformation extends AbstractInfo{	
	@JsonIgnore
	CardData cardData;
	
	public CardDataInformation() {
		super();
		this.transactionType=TransactionType.CardData;
	}

	public CardDataInformation(TransactionManager transactionManager) {
		super(transactionManager);
		this.transactionType=TransactionType.CardData;
	}

	public CardData getCardData() {
		return cardData;
	}

	public void setCardData(CardData cardData) {
		this.cardData = cardData;
	}

	@Override
	public void convertData(String json) throws JsonParseException,
			JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    	try {	    
    		// read from file, convert it to user class
    		setCardData(mapper.readValue(json, CardData.class));    		
     
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
