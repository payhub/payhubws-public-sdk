package com.payhub.ws.api;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)  
public class Errors {
	private String status;

    private String code;

    private String location;

    private String reason;

    private String severity;
    
    private String error;
    
    private String error_description;
    
    private String cause;
    
    private String message;
    
    
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.location = error;
	}

	/**
	 * @param error_description the error_description to set
	 */
	public void setError_description(String error_description) {
		this.reason = error_description;
	}

	/**
	 * @param cause the cause to set
	 */
	public void setCause(String cause) {
		this.location = cause;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.reason = message;
	}
    
    
}
