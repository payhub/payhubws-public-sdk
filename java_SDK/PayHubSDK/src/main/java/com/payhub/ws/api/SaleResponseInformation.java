package com.payhub.ws.api;

import java.io.IOException;
import java.util.List;



import com.payhub.ws.model.SaleResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class SaleResponseInformation {
	
    private SaleResponse saleResponse;
    public Object _links;
    private List<Errors> errors;
    public String rowData;
    private Object metaData;
    private TransactionManager transactionManager;
    private BillInformation billInformation;
    private CardDataInformation cardDataInformation;
    private CustomerInformation customerInformation;
    private MerchantInformation merchantInformation; 
	public String getMetaData() {
		return (String) metaData;
	}
	public void setMetaData(Object metadata) {
		this.metaData = metadata;
	}
	public SaleResponse getSaleResponse() {
		return saleResponse;
	}
	public void setSaleResponse(SaleResponse saleResponse) {
		this.saleResponse = saleResponse;
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
	 * @return the billInformation
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public BillInformation getBillInformation() throws JsonParseException, JsonMappingException, IOException {
		if(billInformation==null){
			BillInformation b = new BillInformation(this.transactionManager);
			b.setUrl(this.transactionManager.getUrl()+"sale/");
			b.getBillForSaleInformationByTransactionId(saleResponse.getSaleId());
			billInformation=b;
		}
		return billInformation;
	}
	/**
	 * @return the cardDataInformation
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public CardDataInformation getCardDataInformation() throws JsonParseException, JsonMappingException, IOException {
		if(cardDataInformation==null){
			CardDataInformation c = new CardDataInformation(this.transactionManager);
			c.getDataByTransaction(TransactionType.Sale, saleResponse.getSaleId());
			cardDataInformation=c;			
			}
		return cardDataInformation;
	}

	/**
	 * @return the customerInformation
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public CustomerInformation getCustomerInformation() throws JsonParseException, JsonMappingException, IOException {
		if(customerInformation==null){
				CustomerInformation c = new CustomerInformation(this.transactionManager);
				c.setUrl(this.transactionManager.getUrl()+"sale/");
				c.getCustomerForSaleInformationByTransactionId(saleResponse.getSaleId());
				customerInformation=c;				
			}
		return customerInformation; 
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
				m.getDataByTransaction(TransactionType.Sale, saleResponse.getSaleId());
				merchantInformation=m;				
			}
		return merchantInformation;
	}

	
     
}
