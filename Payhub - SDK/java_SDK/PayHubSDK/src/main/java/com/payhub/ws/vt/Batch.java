package com.payhub.ws.vt;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.payhub.ws.api.Errors;

@JsonInclude(JsonInclude.Include.NON_NULL)  
public class Batch{
	public static final String BATCH_LINK = "batch/";

	
	
	
	private String terminalId;
	@JsonProperty("MSG")
	private String msg;
	private String orgnazationId;
	private String batchId;
	@JsonProperty("TRN_RESPONSE")
	private TransactionResponse trnResponse;
	private List<Errors> errors;
	
	
	public static class TransactionResponse{
		@JsonProperty("RESPONSE_TEXT")		
		private String responseText;
		@JsonProperty("RESPONSE_CODE")
		private String responseCode;
		@JsonProperty("TRN_DATE_TIME")
		private String trnDateTime;
		/**
		 * @return the responseText
		 */
		public String getResponseText() {
			return responseText;
		}
		/**
		 * @param responseText the responseText to set
		 */
		
		public void setResponseText(String responseText) {
			this.responseText = responseText;
		}
		/**
		 * @return the responseCode
		 */
		public String getResponseCode() {
			return responseCode;
		}
		/**
		 * @param responseCode the responseCode to set
		 */
		
		public void setResponseCode(String responseCode) {
			this.responseCode = responseCode;
		}
		/**
		 * @return the trnDateTime
		 */
		public String getTrnDateTime() {
			return trnDateTime;
		}
		/**
		 * @param trnDateTime the trnDateTime to set
		 */
		
		public void setTrnDateTime(String trnDateTime) {
			this.trnDateTime = trnDateTime;
		}
		
	}


	/**
	 * @return the terminalId
	 */
	public String getTerminalId() {
		return terminalId;
	}


	/**
	 * @param terminalId the terminalId to set
	 */
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}


	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}


	/**
	 * @param msg the msg to set
	 */	
	public void setMsg(String msg) {
		this.msg = msg;
	}


	/**
	 * @return the orgnazationId
	 */
	public String getOrgnazationId() {
		return orgnazationId;
	}


	/**
	 * @param orgnazationId the orgnazationId to set
	 */
	public void setOrgnazationId(String orgnazationId) {
		this.orgnazationId = orgnazationId;
	}


	/**
	 * @return the batchId
	 */
	public String getBatchId() {
		return batchId;
	}


	/**
	 * @param batchId the batchId to set
	 */
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}


	/**
	 * @return the trnResponse
	 */
	public TransactionResponse getTrnResponse() {
		return trnResponse;
	}


	/**
	 * @param trnResponse the trnResponse to set
	 */
	public void setTrnResponse(TransactionResponse trnResponse) {
		this.trnResponse = trnResponse;
	}


	/**
	 * @return the errors
	 */
	public List<Errors> getErrors() {
		return errors;
	}


	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<Errors> errors) {
		this.errors = errors;
	}

    
}
