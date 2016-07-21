package com.payhub.ws.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.payhub.ws.vt.AllTransactions;
import com.payhub.ws.vt.CreditCards;

@JsonInclude(JsonInclude.Include.NON_NULL)  
public class BatchResponseInformation {
	
    private List<TransactionReportInformation> transactions_detail;
    private String batch_settled_on;
    public String batch_status;
    private BatchInfo batch_info;
    private List<Errors> errors;
    
    public static class BatchInfo {
        public AllTransactions all_transactions;        
        public List<CreditCards> credit_cards;
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
        
    }

	/**
	 * @return the transactions_detail
	 */
	public List<TransactionReportInformation> getTransactions_detail() {
		return transactions_detail;
	}

	/**
	 * @param transactions_detail the transactions_detail to set
	 */
	public void setTransactions_detail(List<TransactionReportInformation> transactions_detail) {
		this.transactions_detail = transactions_detail;
	}

	/**
	 * @return the batch_settled_on
	 */
	public String getBatch_settled_on() {
		return batch_settled_on;
	}

	/**
	 * @param batch_settled_on the batch_settled_on to set
	 */
	public void setBatch_settled_on(String batch_settled_on) {
		this.batch_settled_on = batch_settled_on;
	}

	/**
	 * @return the batch_status
	 */
	public String getBatch_status() {
		return batch_status;
	}

	/**
	 * @param batch_status the batch_status to set
	 */
	public void setBatch_status(String batch_status) {
		this.batch_status = batch_status;
	}

	/**
	 * @return the batch_info
	 */
	public BatchInfo getBatch_info() {
		return batch_info;
	}

	/**
	 * @param batch_info the batch_info to set
	 */
	public void setBatch_info(BatchInfo batch_info) {
		this.batch_info = batch_info;
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
