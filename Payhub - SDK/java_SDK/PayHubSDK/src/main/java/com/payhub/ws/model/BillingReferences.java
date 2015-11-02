package com.payhub.ws.model;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)  
public class BillingReferences {
	
	private static final long serialVersionUID = -9171573799378897702L;
    private String cardObscured;
    private String tokenizedCard;
    private long customerId;
    private String customerCardId;    
    private long customerBillId;
	public long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getCardObscured() {
		return cardObscured;
	}
	public void setCardObscured(String cardObscured) {
		this.cardObscured = cardObscured;
	}
	public String getTokenizedCard() {
		return tokenizedCard;
	}
	public void setTokenizedCard(String tokenizedCard) {
		this.tokenizedCard = tokenizedCard;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerCardId() {
		return customerCardId;
	}
	public void setCustomerCardId(String customerCardId) {
		this.customerCardId = customerCardId;
	}
	public long getCustomerBillId() {
		return customerBillId;
	}
	public void setCustomerBillId(long customerBillId) {
		this.customerBillId = customerBillId;
	}
    
    

}
