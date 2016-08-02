package com.payhub.ws.vt;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)  
public class CreditCards{
	private int transactions_no;
	private float transactions_total_net;
	private float sales_total;
	private float refunds_total;
	private String card_type;
	/**
	 * @return the transactions_no
	 */
	public int getTransactions_no() {
		return transactions_no;
	}
	/**
	 * @param transactions_no the transactions_no to set
	 */
	public void setTransactions_no(int transactions_no) {
		this.transactions_no = transactions_no;
	}
	/**
	 * @return the transactions_total_net
	 */
	public float getTransactions_total_net() {
		return transactions_total_net;
	}
	/**
	 * @param transactions_total_net the transactions_total_net to set
	 */
	public void setTransactions_total_net(float transactions_total_net) {
		this.transactions_total_net = transactions_total_net;
	}
	/**
	 * @return the sales_total
	 */
	public float getSales_total() {
		return sales_total;
	}
	/**
	 * @param sales_total the sales_total to set
	 */
	public void setSales_total(float sales_total) {
		this.sales_total = sales_total;
	}
	/**
	 * @return the refunds_total
	 */
	public float getRefunds_total() {
		return refunds_total;
	}
	/**
	 * @param refunds_total the refunds_total to set
	 */
	public void setRefunds_total(float refunds_total) {
		this.refunds_total = refunds_total;
	}
	/**
	 * @return the card_type
	 */
	public String getCard_type() {
		return card_type;
	}
	/**
	 * @param card_type the card_type to set
	 */
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	
	
	
}
