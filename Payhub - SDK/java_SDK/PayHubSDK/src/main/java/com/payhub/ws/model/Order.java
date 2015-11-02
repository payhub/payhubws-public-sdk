package com.payhub.ws.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)  
public class Order {
	 private long id;
     private String invoice;
     private List<Object> lines;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public List<Object> getLines() {
		return lines;
	}
	public void setLines(List<Object> lines) {
		this.lines = lines;
	}
     
     
}
