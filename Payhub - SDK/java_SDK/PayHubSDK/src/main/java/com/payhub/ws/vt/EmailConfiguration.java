package com.payhub.ws.vt;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payhub.ws.api.Errors;

@JsonInclude(JsonInclude.Include.NON_NULL)  
public class EmailConfiguration{
	public static final String EMAIL_LINK = "adminSettings/emailConfiguration";

	private Boolean emailRbFailTransaction;

    private Boolean emailRbSuccessTransaction;

    private Boolean emailBatchFail;

    private Boolean emailBatchSuccess;

    private Boolean emailTrnReceipt;

    private Boolean emailExpPsw;
    
    private Boolean customBatchReport;
    
    private String pdfOrCsvForBatch;

    private Boolean customRBReport;
    
    private String pdfOrCsvForRB;
    
    private List<Errors> errors;
    
	/**
	 * @return the emailRbFailTransaction
	 */
	public Boolean getEmailRbFailTransaction() {
		return emailRbFailTransaction;
	}




	/**
	 * @param emailRbFailTransaction the emailRbFailTransaction to set
	 */
	public void setEmailRbFailTransaction(Boolean emailRbFailTransaction) {
		this.emailRbFailTransaction = emailRbFailTransaction;
	}




	/**
	 * @return the emailRbSuccessTransaction
	 */
	public Boolean getEmailRbSuccessTransaction() {
		return emailRbSuccessTransaction;
	}




	/**
	 * @param emailRbSuccessTransaction the emailRbSuccessTransaction to set
	 */
	public void setEmailRbSuccessTransaction(Boolean emailRbSuccessTransaction) {
		this.emailRbSuccessTransaction = emailRbSuccessTransaction;
	}




	/**
	 * @return the emailBatchFail
	 */
	public Boolean getEmailBatchFail() {
		return emailBatchFail;
	}




	/**
	 * @param emailBatchFail the emailBatchFail to set
	 */
	public void setEmailBatchFail(Boolean emailBatchFail) {
		this.emailBatchFail = emailBatchFail;
	}




	/**
	 * @return the emailBatchSuccess
	 */
	public Boolean getEmailBatchSuccess() {
		return emailBatchSuccess;
	}




	/**
	 * @param emailBatchSuccess the emailBatchSuccess to set
	 */
	public void setEmailBatchSuccess(Boolean emailBatchSuccess) {
		this.emailBatchSuccess = emailBatchSuccess;
	}




	/**
	 * @return the emailTrnReceipt
	 */
	public Boolean getEmailTrnReceipt() {
		return emailTrnReceipt;
	}




	/**
	 * @param emailTrnReceipt the emailTrnReceipt to set
	 */
	public void setEmailTrnReceipt(Boolean emailTrnReceipt) {
		this.emailTrnReceipt = emailTrnReceipt;
	}




	/**
	 * @return the emailExpPsw
	 */
	public Boolean getEmailExpPsw() {
		return emailExpPsw;
	}




	/**
	 * @param emailExpPsw the emailExpPsw to set
	 */
	public void setEmailExpPsw(Boolean emailExpPsw) {
		this.emailExpPsw = emailExpPsw;
	}




	/**
	 * @return the customBatchReport
	 */
	public Boolean getCustomBatchReport() {
		return customBatchReport;
	}




	/**
	 * @param customBatchReport the customBatchReport to set
	 */
	public void setCustomBatchReport(Boolean customBatchReport) {
		this.customBatchReport = customBatchReport;
	}




	/**
	 * @return the pdfOrCsvForBatch
	 */
	public String getPdfOrCsvForBatch() {
		return pdfOrCsvForBatch;
	}




	/**
	 * @param pdfOrCsvForBatch the pdfOrCsvForBatch to set
	 */
	public void setPdfOrCsvForBatch(String pdfOrCsvForBatch) {
		this.pdfOrCsvForBatch = pdfOrCsvForBatch;
	}




	/**
	 * @return the customRBReport
	 */
	public Boolean getCustomRBReport() {
		return customRBReport;
	}




	/**
	 * @param customRBReport the customRBReport to set
	 */
	public void setCustomRBReport(Boolean customRBReport) {
		this.customRBReport = customRBReport;
	}




	/**
	 * @return the pdfOrCsvForRB
	 */
	public String getPdfOrCsvForRB() {
		return pdfOrCsvForRB;
	}




	/**
	 * @param pdfOrCsvForRB the pdfOrCsvForRB to set
	 */
	public void setPdfOrCsvForRB(String pdfOrCsvForRB) {
		this.pdfOrCsvForRB = pdfOrCsvForRB;
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




	public String toString(){
		ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        String jsonInString;
		try {
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
			return jsonInString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return null;
		}
        
	}
    
}
