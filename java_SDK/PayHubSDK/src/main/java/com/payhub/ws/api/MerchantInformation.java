/**
 * 
 */
package com.payhub.ws.api;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.payhub.ws.model.Customer;
import com.payhub.ws.model.Merchant;

/**
 * @author agustin
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MerchantInformation extends AbstractInfo{	
	private Merchant merchant;

	public MerchantInformation() {
		super();
		this.transactionType=TransactionType.Merchant;
	}

	public MerchantInformation(TransactionManager transactionManager) {
		super(transactionManager);
		this.transactionType=TransactionType.Merchant;
	}

	@Override
	public void convertData(String json) throws JsonParseException,
			JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    	try {	    
    		// read from file, convert it to user class
    		setMerchant(mapper.readValue(json, Merchant.class));    		
     
    	} catch (JsonGenerationException e) {     
    		e.printStackTrace();     
    	}
	}

	/**
	 * @return the merchant
	 */
	public Merchant getMerchant() {
		return merchant;
	}

	/**
	 * @param merchant the merchant to set
	 */
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
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
