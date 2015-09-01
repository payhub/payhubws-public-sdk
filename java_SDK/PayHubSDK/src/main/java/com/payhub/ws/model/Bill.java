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
public class Bill {
	protected static final long serialVersionUID = 2865435483666149222L;
    
    public String note;
    
    public String po_number;
    
    public String invoice_number;
    
    public long customerId;
    
    public long customerCardId;
    
    private TransactionAmount tax_amount;
    
    private TransactionAmount base_amount;
    
	private BillingReferences billingReferences;
    
    private TransactionAmount totalAmount;

    private TransactionAmount shipping_amount;

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPo_number() {
		return po_number;
	}

	public void setPo_number(String po_number) {
		this.po_number = po_number;
	}

	public String getInvoice_number() {
		return invoice_number;
	}

	public void setInvoice_number(String invoice_number) {
		this.invoice_number = invoice_number;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getCustomerCardId() {
		return customerCardId;
	}

	public void setCustomerCardId(long customerCardId) {
		this.customerCardId = customerCardId;
	}

	public TransactionAmount getTax_amount() {
		return tax_amount;
	}

	public void setTax_amount(TransactionAmount tax_amount) {
		this.tax_amount = tax_amount;
	}

	public TransactionAmount getBase_amount() {
		return base_amount;
	}

	public void setBase_amount(TransactionAmount base_amount) {
		this.base_amount = base_amount;
	}

	public BillingReferences getBillingReferences() {
		return billingReferences;
	}

	public void setBillingReferences(BillingReferences billingReferences) {
		this.billingReferences = billingReferences;
	}

	public TransactionAmount getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(TransactionAmount totalAmount) {
		this.totalAmount = totalAmount;
	}

	public TransactionAmount getShipping_amount() {
		return shipping_amount;
	}

	public void setShipping_amount(TransactionAmount shipping_amount) {
		this.shipping_amount = shipping_amount;
	}
    
}
