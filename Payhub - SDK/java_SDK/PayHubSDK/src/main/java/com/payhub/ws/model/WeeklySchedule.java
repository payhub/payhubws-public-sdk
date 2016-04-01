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
public class WeeklySchedule {
	private String[] weekly_bill_days;

	/**
	 * @return the weekly_bill_days
	 */
	public String[] getWeekly_bill_days() {
		return weekly_bill_days;
	}

	/**
	 * @param weekly_bill_days the weekly_bill_days to set
	 */
	public void setWeekly_bill_days(String[] weekly_bill_days) {
		this.weekly_bill_days = weekly_bill_days;
	}
	
	  
}
