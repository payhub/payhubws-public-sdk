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
public class RefundResponse {
	
	 
		public String saleTransactionId;
        
        public String refundTransactionId;
      
        public String token;
        
        public String approvalCode;
        
        public String processedDateTime;
        
        public String avsResultCode;
        
        public String verificationResultCode;
        
        public String batchId;
        
        public String responseCode;
        
        public String responseText;
        
        public String cisNote;
        
        public String riskStatusResponseText;
        
        public String riskStatusRespondeCode;
        
        public String refundDateTime;
        
        public String tokenizedCard;
        
        public BillingReferences billingReferences;

        public CustomerReference customerReference;

		/**
		 * @return the saleTransactionId
		 */
		public String getSaleTransactionId() {
			return saleTransactionId;
		}

		/**
		 * @param saleTransactionId the saleTransactionId to set
		 */
		public void setSaleTransactionId(String saleTransactionId) {
			this.saleTransactionId = saleTransactionId;
		}

		/**
		 * @return the refundTransactionId
		 */
		public String getRefundTransactionId() {
			return refundTransactionId;
		}

		/**
		 * @param refundTransactionId the refundTransactionId to set
		 */
		public void setRefundTransactionId(String refundTransactionId) {
			this.refundTransactionId = refundTransactionId;
		}

		/**
		 * @return the token
		 */
		public String getToken() {
			return token;
		}

		/**
		 * @param token the token to set
		 */
		public void setToken(String token) {
			this.token = token;
		}

		/**
		 * @return the approvalCode
		 */
		public String getApprovalCode() {
			return approvalCode;
		}

		/**
		 * @param approvalCode the approvalCode to set
		 */
		public void setApprovalCode(String approvalCode) {
			this.approvalCode = approvalCode;
		}

		/**
		 * @return the processedDateTime
		 */
		public String getProcessedDateTime() {
			return processedDateTime;
		}

		/**
		 * @param processedDateTime the processedDateTime to set
		 */
		public void setProcessedDateTime(String processedDateTime) {
			this.processedDateTime = processedDateTime;
		}

		/**
		 * @return the avsResultCode
		 */
		public String getAvsResultCode() {
			return avsResultCode;
		}

		/**
		 * @param avsResultCode the avsResultCode to set
		 */
		public void setAvsResultCode(String avsResultCode) {
			this.avsResultCode = avsResultCode;
		}

		/**
		 * @return the verificationResultCode
		 */
		public String getVerificationResultCode() {
			return verificationResultCode;
		}

		/**
		 * @param verificationResultCode the verificationResultCode to set
		 */
		public void setVerificationResultCode(String verificationResultCode) {
			this.verificationResultCode = verificationResultCode;
		}

		/**
		 * @return the batchId
		 */
		public String getBatchId() {
			return batchId;
		}

		/**
		 * @param batchId the batchId to set
		 */
		public void setBatchId(String batchId) {
			this.batchId = batchId;
		}

		/**
		 * @return the responseCode
		 */
		public String getResponseCode() {
			return responseCode;
		}

		/**
		 * @param responseCode the responseCode to set
		 */
		public void setResponseCode(String responseCode) {
			this.responseCode = responseCode;
		}

		/**
		 * @return the responseText
		 */
		public String getResponseText() {
			return responseText;
		}

		/**
		 * @param responseText the responseText to set
		 */
		public void setResponseText(String responseText) {
			this.responseText = responseText;
		}

		/**
		 * @return the cisNote
		 */
		public String getCisNote() {
			return cisNote;
		}

		/**
		 * @param cisNote the cisNote to set
		 */
		public void setCisNote(String cisNote) {
			this.cisNote = cisNote;
		}

		/**
		 * @return the riskStatusResponseText
		 */
		public String getRiskStatusResponseText() {
			return riskStatusResponseText;
		}

		/**
		 * @param riskStatusResponseText the riskStatusResponseText to set
		 */
		public void setRiskStatusResponseText(String riskStatusResponseText) {
			this.riskStatusResponseText = riskStatusResponseText;
		}

		/**
		 * @return the riskStatusRespondeCode
		 */
		public String getRiskStatusRespondeCode() {
			return riskStatusRespondeCode;
		}

		/**
		 * @param riskStatusRespondeCode the riskStatusRespondeCode to set
		 */
		public void setRiskStatusRespondeCode(String riskStatusRespondeCode) {
			this.riskStatusRespondeCode = riskStatusRespondeCode;
		}

		/**
		 * @return the refundDateTime
		 */
		public String getRefundDateTime() {
			return refundDateTime;
		}

		/**
		 * @param refundDateTime the refundDateTime to set
		 */
		public void setRefundDateTime(String refundDateTime) {
			this.refundDateTime = refundDateTime;
		}

		/**
		 * @return the tokenizedCard
		 */
		public String getTokenizedCard() {
			return tokenizedCard;
		}

		/**
		 * @param tokenizedCard the tokenizedCard to set
		 */
		public void setTokenizedCard(String tokenizedCard) {
			this.tokenizedCard = tokenizedCard;
		}

		/**
		 * @return the billingReferences
		 */
		public BillingReferences getBillingReferences() {
			return billingReferences;
		}

		/**
		 * @param billingReferences the billingReferences to set
		 */
		public void setBillingReferences(BillingReferences billingReferences) {
			this.billingReferences = billingReferences;
		}

		/**
		 * @return the customerReference
		 */
		public CustomerReference getCustomerReference() {
			return customerReference;
		}

		/**
		 * @param customerReference the customerReference to set
		 */
		public void setCustomerReference(CustomerReference customerReference) {
			this.customerReference = customerReference;
		}
        
        

}
