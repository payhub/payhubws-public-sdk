/**
 * 
 */
package com.payhub.ws.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author agustin
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class SaleResponse {
	private static final long serialVersionUID = 1L;
    
	private String saleId;
    
	private String approvalCode;
    
	private String processedDateTime;
    
	private String avsResultCode;
    
	private String verificationResultCode;
    
	private String batchId;
    
	private String responseCode;
    
	private String responseText;
    
	private String cisNote;
    
	private String riskStatusResponseText;
    
	private String riskStatusRespondeCode;
    
	private String saleDateTime;
    
	private String tokenizedCard;
    
	private BillingReferences billingReferences;
    
	private CustomerReference customerReference;

	public String getSaleId() {
		return saleId;
	}

	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}

	public String getApprovalCode() {
		return approvalCode;
	}

	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}

	public String getProcessedDateTime() {
		return processedDateTime;
	}

	public void setProcessedDateTime(String processedDateTime) {
		this.processedDateTime = processedDateTime;
	}

	public String getAvsResultCode() {
		return avsResultCode;
	}

	public void setAvsResultCode(String avsResultCode) {
		this.avsResultCode = avsResultCode;
	}

	public String getVerificationResultCode() {
		return verificationResultCode;
	}

	public void setVerificationResultCode(String verificationResultCode) {
		this.verificationResultCode = verificationResultCode;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

	public String getCisNote() {
		return cisNote;
	}

	public void setCisNote(String cisNote) {
		this.cisNote = cisNote;
	}

	public String getRiskStatusResponseText() {
		return riskStatusResponseText;
	}

	public void setRiskStatusResponseText(String riskStatusResponseText) {
		this.riskStatusResponseText = riskStatusResponseText;
	}

	public String getRiskStatusRespondeCode() {
		return riskStatusRespondeCode;
	}

	public void setRiskStatusRespondeCode(String riskStatusRespondeCode) {
		this.riskStatusRespondeCode = riskStatusRespondeCode;
	}

	public String getSaleDateTime() {
		return saleDateTime;
	}

	public void setSaleDateTime(String saleDateTime) {
		this.saleDateTime = saleDateTime;
	}

	public String getTokenizedCard() {
		return tokenizedCard;
	}

	public void setTokenizedCard(String tokenizedCard) {
		this.tokenizedCard = tokenizedCard;
	}

	public BillingReferences getBillingReferences() {
		return billingReferences;
	}

	public void setBillingReferences(BillingReferences billingReferences) {
		this.billingReferences = billingReferences;
	}

	public CustomerReference getCustomerReference() {
		return customerReference;
	}

	public void setCustomerReference(CustomerReference customerReference) {
		this.customerReference = customerReference;
	}
	
}
