/**
 * 
 */
package com.payhub.ws.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author agustin
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)  
public class MontlySchedule {
	  private String monthly_type;
	  private List<Integer> monthly_each_days;
	public String getMonthly_type() {
		return monthly_type;
	}
	public void setMonthly_type(String monthly_type) {
		this.monthly_type = monthly_type;
	}
	public List<Integer> getMonthly_each_days() {
		return monthly_each_days;
	}
	public void setMonthly_each_days(List<Integer> monthly_each_days) {
		this.monthly_each_days = monthly_each_days;
	}
	  
}
