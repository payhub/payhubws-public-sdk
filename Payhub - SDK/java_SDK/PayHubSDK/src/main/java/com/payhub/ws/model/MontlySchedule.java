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
	  private int monthly_on_the_day_of_week_in_month;
	  private int monthly_day_of_week;
	  
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
		/**
		 * @return the monthly_on_the_day_of_week_in_month
		 */
		public int getMonthly_on_the_day_of_week_in_month() {
			return monthly_on_the_day_of_week_in_month;
		}
		/**
		 * @param monthly_on_the_day_of_week_in_month the monthly_on_the_day_of_week_in_month to set
		 */
		public void setMonthly_on_the_day_of_week_in_month(int monthly_on_the_day_of_week_in_month) {
			this.monthly_on_the_day_of_week_in_month = monthly_on_the_day_of_week_in_month;
		}
		/**
		 * @return the monthly_day_of_week
		 */
		public int getMonthly_day_of_week() {
			return monthly_day_of_week;
		}
		/**
		 * @param monthly_day_of_week the monthly_day_of_week to set
		 */
		public void setMonthly_day_of_week(int monthly_day_of_week) {
			this.monthly_day_of_week = monthly_day_of_week;
		}
		
	  
}
