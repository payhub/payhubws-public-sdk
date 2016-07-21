package com.payhub.ws.vt;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.payhub.ws.api.Errors;

@JsonInclude(JsonInclude.Include.NON_NULL)  
public class TransactionTotals{
	public static final String TRN_TOTAL_LINK = "report/transactionTotals";

	private List<CreditCards> credit_cards;
	private AllTransactions all_transactions; 
	private List<Errors> errors;
	/**
	 * @return the credit_cards
	 */
	public List<CreditCards> getCredit_cards() {
		return credit_cards;
	}
	/**
	 * @param credit_cards the credit_cards to set
	 */
	public void setCredit_cards(List<CreditCards> credit_cards) {
		this.credit_cards = credit_cards;
	}
	/**
	 * @return the all_transactions
	 */
	public AllTransactions getAll_transactions() {
		return all_transactions;
	}
	/**
	 * @param all_transactions the all_transactions to set
	 */
	public void setAll_transactions(AllTransactions all_transactions) {
		this.all_transactions = all_transactions;
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
