package com.payhub.ws.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Merchant {
	private static final long serialVersionUID = 8527142639482598808L;

	public static final String TERMINAL_ID_FIELD = "terminal_id";

	public static final String ORGANIZATION_ID_FIELD = "organization_id";
	
    public int organization_id;

    public int terminal_id;

    private String api_username;

    private String api_password;

	public int getOrganization_id() {
		return organization_id;
	}

	public void setOrganization_id(int organization_id) {
		this.organization_id = organization_id;
	}

	public int getTerminal_id() {
		return terminal_id;
	}

	public void setTerminal_id(int terminal_id) {
		this.terminal_id = terminal_id;
	}

	public String getApi_username() {
		return api_username;
	}

	public void setApi_username(String api_username) {
		this.api_username = api_username;
	}

	public String getApi_password() {
		return api_password;
	}

	public void setApi_password(String api_password) {
		this.api_password = api_password;
	}
    
}
