package com.payhub.ws.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Customer {
	private static final long serialVersionUID = 7246202263731350762L;
	public static final String CUSTOMER_ID_FIELD = "customerId";
	private String first_name;
	private String last_name;
	private String email_address;
	private String phone_number;
	private String phone_ext=""; // vt requires this set to an empty string if not present

	private String phone_type;
	
	private String company_name;

	private String job_title;
	private String web_address;

	private CustomerReference customerReference;
	
	private Long customerId;
	
	
	// fields that are read only

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getWeb_address() {
		return web_address;
	}

	public void setWeb_address(String web_address) {
		this.web_address = web_address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getPhone_ext() {
		return phone_ext;
	}

	public void setPhone_ext(String phone_ext) {
		this.phone_ext = phone_ext;
	}

	public String getPhone_type() {
		return phone_type;
	}

	public void setPhone_type(String phone_type) {
		this.phone_type = phone_type;
	}


	public CustomerReference getCustomerReference() {
		return customerReference;
	}


	public void setCustomerReference(
			CustomerReference customerReference) {
		this.customerReference = customerReference;
	}
	
	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
}
