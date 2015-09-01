package com.payhub.ws.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.JsonNode;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Metadata {
	
	private Object metaData;
	@JsonRawValue
	public String getMetaData() {
		return (String) metaData;
	}

	public void setMetadata(String metadata) {
		this.metaData = metadata;
	}
	
}
