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
public class Schedule {
	        private String schedule_type;
	        private int bill_generation_interval;
	        private ScheduleSartAndEnd schedule_start_and_end;
	        private MontlySchedule monthly_schedule;
	        private YearlySchedule yearly_schedule;
	        private WeeklySchedule weekly_schedule;
	        private SpecificDatesChedule specific_dates_schedule;
	        
	        public Schedule(){}
	        
	        public Schedule(String schedule_type) { 
	        	this.schedule_type=schedule_type;
	        }
			public String getSchedule_type() {
				return schedule_type;
			}
			public void setSchedule_type(String schedule_type) {
				this.schedule_type = schedule_type;
			}
			public int getBill_generation_interval() {
				return bill_generation_interval;
			}
			public void setBill_generation_interval(int bill_generation_interval) {
				this.bill_generation_interval = bill_generation_interval;
			}
			public ScheduleSartAndEnd getSchedule_start_and_end() {
				return schedule_start_and_end;
			}
			public void setSchedule_start_and_end(ScheduleSartAndEnd schedule_start_and_end) {
				this.schedule_start_and_end = schedule_start_and_end;
			}
			public MontlySchedule getMonthly_schedule() {
				return monthly_schedule;
			}
			public void setMonthly_schedule(MontlySchedule monthly_schedule) {
				this.monthly_schedule = monthly_schedule;
			}
	        
}
