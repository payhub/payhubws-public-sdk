/**
 * 
 */
package com.payhub.ws.api;

/**
 * @author agustin
 *
 */
public enum TransactionType {
	Sale,//forSale
	AuthOnly,//forAuthOnly
	Capture,//forCapture
	Bill,//forBill
	CardData,//forCardData
	Customer,//forCustomer
	Merchant,//forMerchant
	RecurringBill,//forRecurringBill
	Schedule,//forSchedule
	Refund,//forRefund
	VoidTransaction,
	Verify//forVoid
}
