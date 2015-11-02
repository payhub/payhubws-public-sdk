package com.payhub.ws.model;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)  
public class CaptureResponse {
	        private String batchId;
	        private String transactionId;
	        private BillingReferences billingReferences;
			public String getBatchId() {
				return batchId;
			}

			public void setBatchId(String batchId) {
				this.batchId = batchId;
			}

			public String getTransactionId() {
				return transactionId;
			}

			public void setTransactionId(String transactionId) {
				this.transactionId = transactionId;
			}

			public BillingReferences getBillingReferences() {
				return billingReferences;
			}

			public void setBillingReferences(BillingReferences billingReferences) {
				this.billingReferences = billingReferences;
			}  
	        
	        
}
