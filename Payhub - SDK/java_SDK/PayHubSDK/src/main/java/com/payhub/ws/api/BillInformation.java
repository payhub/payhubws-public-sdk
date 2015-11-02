/**
 * 
 */
package com.payhub.ws.api;

import java.io.IOException;
import java.net.HttpURLConnection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.Module.SetupContext;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payhub.ws.model.Bill;
import com.payhub.ws.model.BillingReferences;
import com.payhub.ws.model.Metadata;
import com.payhub.ws.model.TransactionAmount;

/**
 * @author agustin
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillInformation{
	private String version;
	private String createdAt;
	private String lastModified;
	private String createdBy;
	private String lastModifiedBy;
	private Object metaData;
	@JsonIgnore
	private TransactionManager transactionManager;
	@JsonIgnore
	private TransactionType transactionType;
	@JsonIgnore
	private String url;
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public String getMetaData() {
		return metaData.toString();
	}
	public void setMetaData(String metaData) {
		this.metaData = metaData;
	}
	public TransactionManager getTransactionManager() {
		return transactionManager;
	}
	public void setTransactionManager(TransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	@JsonIgnore
	private Bill bill;
	
	
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @param metaData the metaData to set
	 */
	public BillInformation() {		
		this.transactionType=TransactionType.Bill;
		// TODO Auto-generated constructor stub
	}

	public BillInformation(TransactionManager transactionManager) {
		this.transactionManager=transactionManager;
		this.transactionType=TransactionType.Bill;
		// TODO Auto-generated constructor stub
	}
	
	private void convertData(String json) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    	try {	    
    		// read from file, convert it to user class
    		ObjectNode node = mapper.readValue(json, ObjectNode.class);
    		
    		if (node.has("version")) {
    			this.setVersion(node.get("version").toString());
    		    System.out.println("version: " + node.get("version"));
    		}
    		if (node.has("createdAt")) {
    			this.setCreatedBy(node.get("createdAt").toString());
    		    System.out.println("createdAt: " + node.get("createdAt"));
    		}
    		if (node.has("lastModified")) {
    			this.setLastModified(node.get("lastModified").toString());
    		    System.out.println("lastModified: " + node.get("lastModified"));
    		}
    		if (node.has("createdBy")) {
    			this.setCreatedBy(node.get("createdBy").toString());
    		    System.out.println("createdBy: " + node.get("createdBy"));
    		}
    		if (node.has("lastModifiedBy")) {
    			this.setLastModifiedBy(node.get("lastModifiedBy").toString());
    		    System.out.println("lastModifiedBy: " + node.get("lastModifiedBy"));
    		}
    		if (node.has("metaData")) {
    			this.setMetaData(node.get("metaData").toString());
    		    System.out.println("metaData: " + node.get("metaData"));
    		}
     
    	} catch (JsonGenerationException e) {
     
    		e.printStackTrace();
     
    	}
	}

	private void convertDataToBill(String json) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    	try {	    
    		// read from file, convert it to user class
    		setBill(mapper.readValue(json, Bill.class));    		
     
    	} catch (JsonGenerationException e) {
     
    		e.printStackTrace();
     
    	}
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public void getBillForSaleInformationByTransactionId(String id) throws JsonParseException, JsonMappingException, IOException{
		String url = this.getUrl()+id+"/bill";
		HttpURLConnection request = this.transactionManager.setHeadersGet(url, this.transactionManager.getToken());
		String json=this.transactionManager.doGet(request);
		convertData(json);
		convertDataToBill(json);
	}
	public void getBillForSaleInformationById(String id) throws JsonParseException, JsonMappingException, IOException{
		String url = this.transactionManager.getUrl()+"bill-for-sale/"+id;
		HttpURLConnection request = this.transactionManager.setHeadersGet(url, this.transactionManager.getToken());
		String json=this.transactionManager.doGet(request);
		convertData(json);
		convertDataToBill(json);
	}
	public void getBillForRecurringBillInformationByTransactionId(String id) throws JsonParseException, JsonMappingException, IOException{
		String url = this.getUrl()+id+"/bill";
		HttpURLConnection request = this.transactionManager.setHeadersGet(url, this.transactionManager.getToken());
		String json=this.transactionManager.doGet(request);
		convertData(json);
		convertDataToBill(json);
	}
	public void getBillForRecurringBillInformationById(String id) throws JsonParseException, JsonMappingException, IOException{
		String url = this.transactionManager.getUrl()+"bill-for-recurring-bill/"+id;
		HttpURLConnection request = this.transactionManager.setHeadersGet(url, this.transactionManager.getToken());
		String json=this.transactionManager.doGet(request);
		convertData(json);
		convertDataToBill(json);
	}
	
}
