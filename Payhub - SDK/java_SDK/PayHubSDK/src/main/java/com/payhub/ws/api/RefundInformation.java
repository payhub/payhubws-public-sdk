package com.payhub.ws.api;

import java.io.IOException;
import java.util.List;

import com.payhub.ws.model.Merchant;
import com.payhub.ws.model.RefundResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@JsonInclude(JsonInclude.Include.NON_NULL)  
public class RefundInformation {

    private Merchant merchant;
    private String transaction_id;
    private RefundResponse lastRefundResponse;
    private String merchantOrganizationId;
    public String settlementStatus;
    public Object _links;
    private List<Errors> errors;
    public String rowData;
    private Object metaData;
    private TransactionManager transactionManager;
    private MerchantInformation merchantInformation; 
    
	public String getMetaData() {
		return (String) metaData;
	}
	public void setMetaData(Object metadata) {
		this.metaData = metadata;
	}
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public RefundResponse getLastRefundResponse() {
		return lastRefundResponse;
	}
	public void setLastRefundResponse(RefundResponse lastRefundResponse) {
		this.lastRefundResponse = lastRefundResponse;
	}
	public String getMerchantOrganizationId() {
		return merchantOrganizationId;
	}
	public void setMerchantOrganizationId(String merchantOrganizationId) {
		this.merchantOrganizationId = merchantOrganizationId;
	}
	public Object get_links() {
		return _links;
	}
	public void set_links(Object _links) {
		this._links = _links;
	}
	public List<Errors> getErrors() {
		return errors;
	}
	public void setErrors(List<Errors> errors) {
		this.errors = errors;
	}
	public String getRowData() {
		return rowData;
	}
	public void setRowData(String rowData) {
		this.rowData = rowData;
	}
	/**
	 * @param transactionManager the transactionManager to set
	 */
	public void setTransactionManager(TransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	/**
	 * @return the merchantInformation
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public MerchantInformation getMerchantInformation() throws JsonParseException, JsonMappingException, IOException {
		if(merchantInformation==null){			
				MerchantInformation m = new MerchantInformation(this.transactionManager);
				m.getDataByTransaction(TransactionType.Refund, transaction_id);
				merchantInformation=m;				
			}
		return merchantInformation;
	}
}
