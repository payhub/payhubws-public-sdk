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
public class YearlySchedule {
	private String year_to_start;
	private Integer yearly_bill_on_month_number;
	private String yearly_bill_on_day_of_month;

	public String getYear_to_start() {
		return year_to_start;
	}

	public void setYear_to_start(String year_to_start) {
		this.year_to_start = year_to_start;
	}

	public Integer getYearly_bill_on_month_number() {
		return yearly_bill_on_month_number;
	}

	public void setYearly_bill_on_month_number(
			Integer yearly_bill_on_month_number) {
		this.yearly_bill_on_month_number = yearly_bill_on_month_number;
	}

	public String getYearly_bill_on_day_of_month() {
		return yearly_bill_on_day_of_month;
	}

	public void setYearly_bill_on_day_of_month(
			String yearly_bill_on_day_of_month) {
		this.yearly_bill_on_day_of_month = yearly_bill_on_day_of_month;
	}

	  
}
