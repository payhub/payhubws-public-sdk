package com.payhub.ws.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class VoidResponse {
	
	  private String saleTransactionId;
	  private String voidTransactionId;
	  private String token;
	public String getSaleTransactionId() {
		return saleTransactionId;
	}
	public void setSaleTransactionId(String saleTransactionId) {
		this.saleTransactionId = saleTransactionId;
	}
	public String getVoidTransactionId() {
		return voidTransactionId;
	}
	public void setVoidTransactionId(String voidTransactionId) {
		this.voidTransactionId = voidTransactionId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	  
}
