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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.payhub.ws.model.Bill;
import com.payhub.ws.model.Metadata;

/**
 * @author agustin
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractInfo {
	protected String version;
	protected String createdAt;
	protected String lastModified;
	protected String createdBy;
	protected String lastModifiedBy;
	protected Object metaData;
	@JsonIgnore
	protected TransactionManager transactionManager;
	@JsonIgnore
	protected TransactionType transactionType;
	
	public AbstractInfo(){}
	public AbstractInfo(TransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
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
	
	
	public void getDataByID(String id) throws JsonParseException, JsonMappingException, IOException{
		String url = this.transactionManager.getUrl()+getUrlForTransactionType(this.transactionType)+id;
		HttpURLConnection request = this.transactionManager.setHeadersGet(url, this.transactionManager.getToken());
		String json=this.transactionManager.doGet(request);
		convertData(json);
		convertAbstractData(json);
	}
	public void getDataByTransaction(TransactionType type,String transactionId)throws JsonParseException, JsonMappingException, IOException{
		String url=null;
		if(TransactionType.CardData.equals(this.transactionType)){
			url = this.transactionManager.getUrl()+getUrlForTransactionType(type)+transactionId+"/card_data";
		}else{
			url = this.transactionManager.getUrl()+getUrlForTransactionType(type)+transactionId+"/"+getUrlForTransactionType(this.transactionType);
		}
		HttpURLConnection request = (HttpURLConnection) this.transactionManager.setHeadersGet(url, this.transactionManager.getToken());
		String json=this.transactionManager.doGet(request);
		convertData(json);
		convertAbstractData(json);
	}
	public abstract void convertData(String json) throws JsonParseException, JsonMappingException, IOException;
	
	public  void convertAbstractData(String json) throws JsonParseException, JsonMappingException, IOException{
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
	public abstract String getUrlForTransactionType(TransactionType type);
	
	
}
