package com.payhub.ws.api;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.payhub.ws.model.CaptureResponse;



@JsonInclude(JsonInclude.Include.NON_NULL)  
public class CaptureResponseInformation {
	
    private CaptureResponse lastCaptureResponse;
    public Object _links;
    private List<Errors> errors;
    public String rowData;
    private Object metaData;
    private TransactionManager transactionManager;
    private BillInformation billInformation;
    private MerchantInformation merchantInformation; 
    
	public String getMetaData() {
		return (String) metaData;
	}
	public void setMetaData(Object metadata) {
		this.metaData = metadata;
	}
	public CaptureResponse getLastCaptureResponse() {
		return lastCaptureResponse;
	}
	public void setLastCaptureResponse(CaptureResponse lastCaptureResponse) {
		this.lastCaptureResponse = lastCaptureResponse;
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
			b.setUrl(this.transactionManager.getUrl()+"capture/");
			b.getBillForRecurringBillInformationById(lastCaptureResponse.getTransactionId());
			billInformation=b;
		}
		return billInformation;
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
				m.getDataByTransaction(TransactionType.Capture, lastCaptureResponse.getTransactionId());
				merchantInformation=m;				
			}
		return merchantInformation;
	}
}
