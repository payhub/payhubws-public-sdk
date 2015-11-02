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
public class RecurringBillResponse {
	 private String recurringBillId;

	 private CustomerReference customerReference;

	 private BillingReferences billingReferences;

	public String getRecurringBillId() {
		return recurringBillId;
	}

	public void setRecurringBillId(String recurringBillId) {
		this.recurringBillId = recurringBillId;
	}

	public CustomerReference getCustomerReference() {
		return customerReference;
	}

	public void setCustomerReference(CustomerReference customerReference) {
		this.customerReference = customerReference;
	}

	public BillingReferences getBillingReferences() {
		return billingReferences;
	}

	public void setBillingReferences(BillingReferences billingReferences) {
		this.billingReferences = billingReferences;
	}
	 
	        
}
