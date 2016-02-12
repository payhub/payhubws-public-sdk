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
public class TransactionSearchParameters {
	private String batchIdFrom;
	private String batchIdTo;
	private String transactionType;
	private String responseCode;
	private String amountFrom;
	private String amountTo;
	private String firstName;
	private String lastName;
	private String trnDateFrom;
	private String trnDateTo;
	private String cardType;
	private String cardLast4Digits;
	private String cardToken;
	private String authAmountFrom;
	private String authAmountTo;
	private String swiped;
	private String source;
	private String phoneNumber;
	private String email   ;
	private String note ;
	private String transactionStatus;
	private String customerId;
	/**
	 * @return the batchIdFrom
	 */
	public String getBatchIdFrom() {
		return batchIdFrom;
	}
	/**
	 * @param batchIdFrom the batchIdFrom to set
	 */
	public void setBatchIdFrom(String batchIdFrom) {
		this.batchIdFrom = batchIdFrom;
	}
	/**
	 * @return the batchIdTo
	 */
	public String getBatchIdTo() {
		return batchIdTo;
	}
	/**
	 * @param batchIdTo the batchIdTo to set
	 */
	public void setBatchIdTo(String batchIdTo) {
		this.batchIdTo = batchIdTo;
	}
	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}
	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
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
	 * @return the amountFrom
	 */
	public String getAmountFrom() {
		return amountFrom;
	}
	/**
	 * @param amountFrom the amountFrom to set
	 */
	public void setAmountFrom(String amountFrom) {
		this.amountFrom = amountFrom;
	}
	/**
	 * @return the amountTo
	 */
	public String getAmountTo() {
		return amountTo;
	}
	/**
	 * @param amountTo the amountTo to set
	 */
	public void setAmountTo(String amountTo) {
		this.amountTo = amountTo;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the trnDateFrom
	 */
	public String getTrnDateFrom() {
		return trnDateFrom;
	}
	/**
	 * @param trnDateFrom the trnDateFrom to set
	 */
	public void setTrnDateFrom(String trnDateFrom) {
		this.trnDateFrom = trnDateFrom;
	}
	/**
	 * @return the trnDateTo
	 */
	public String getTrnDateTo() {
		return trnDateTo;
	}
	/**
	 * @param trnDateTo the trnDateTo to set
	 */
	public void setTrnDateTo(String trnDateTo) {
		this.trnDateTo = trnDateTo;
	}
	/**
	 * @return the cardType
	 */
	public String getCardType() {
		return cardType;
	}
	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	/**
	 * @return the cardLast4Digits
	 */
	public String getCardLast4Digits() {
		return cardLast4Digits;
	}
	/**
	 * @param cardLast4Digits the cardLast4Digits to set
	 */
	public void setCardLast4Digits(String cardLast4Digits) {
		this.cardLast4Digits = cardLast4Digits;
	}
	/**
	 * @return the cardToken
	 */
	public String getCardToken() {
		return cardToken;
	}
	/**
	 * @param cardToken the cardToken to set
	 */
	public void setCardToken(String cardToken) {
		this.cardToken = cardToken;
	}
	/**
	 * @return the authAmountFrom
	 */
	public String getAuthAmountFrom() {
		return authAmountFrom;
	}
	/**
	 * @param authAmountFrom the authAmountFrom to set
	 */
	public void setAuthAmountFrom(String authAmountFrom) {
		this.authAmountFrom = authAmountFrom;
	}
	/**
	 * @return the authAmountTo
	 */
	public String getAuthAmountTo() {
		return authAmountTo;
	}
	/**
	 * @param authAmountTo the authAmountTo to set
	 */
	public void setAuthAmountTo(String authAmountTo) {
		this.authAmountTo = authAmountTo;
	}
	/**
	 * @return the swiped
	 */
	public String getSwiped() {
		return swiped;
	}
	/**
	 * @param swiped the swiped to set
	 */
	public void setSwiped(String swiped) {
		this.swiped = swiped;
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * @return the transactionStatus
	 */
	public String getTransactionStatus() {
		return transactionStatus;
	}
	/**
	 * @param transactionStatus the transactionStatus to set
	 */
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	
}
