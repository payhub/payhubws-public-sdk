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
public class SpecificDatesChedule {
	private String[] specific_dates;


	public String[] getSpecific_dates() {
		return specific_dates;
	}

	public void setSpecific_dates(String[] specific_dates) {
		this.specific_dates = specific_dates;
	}
	  
}
