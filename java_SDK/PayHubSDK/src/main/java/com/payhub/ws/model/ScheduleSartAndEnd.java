/**
 * 
 */
package com.payhub.ws.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author agustin
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)  
public class ScheduleSartAndEnd {
			@JsonIgnore
	        private Date startDate;
	        private String start_date;
	        private String end_date_type;
	        @JsonIgnore
	        private Date endDate;
	        private String end_date;
	        
			public Date getStartDate() {				
				return startDate;
			}
			public void setStartDate(String startDate) throws ParseException {
				DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");								
				this.startDate = inputFormat.parse(startDate);
				this.start_date=inputFormat.format(this.startDate);
			}
			public String getStart_date() {			
				return start_date;
			}
			public void setStart_date(String start_date) {
				this.start_date = start_date;
			}
			public String getEnd_date_type() {
				return end_date_type;
			}
			public void setEnd_date_type(String end_date_type) {
				this.end_date_type = end_date_type;
			}
			public Date getEndDate() {
				return endDate;
			}
			public void setEndDate(String endDate) throws ParseException {
				DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");								
				this.endDate = inputFormat.parse(endDate);
				this.end_date=inputFormat.format(this.endDate);
			}
			public String getEnd_date() {
				return end_date;
			}
			public void setEnd_date(String end_date) {
				this.end_date = end_date;
			}
	        
	        
			

}
