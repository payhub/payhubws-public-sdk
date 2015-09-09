package com.payhub.ws.api;
import java.io.IOException;
import java.util.List;

import com.payhub.ws.model.Bill;
import com.payhub.ws.model.CardData;
import com.payhub.ws.model.Customer;
import com.payhub.ws.model.Merchant;
import com.payhub.ws.model.RecurringBillResponse;
import com.payhub.ws.model.Schedule;
import com.payhub.ws.model.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@JsonInclude(JsonInclude.Include.NON_NULL)  
public class RecurringBillResponseInformation {
	private Merchant merchant;
	private Customer customer;
	private CardData card_data;
	private Bill bill;
	private Schedule schedule;
	private StatusInformation status;
	private RecurringBillResponse lastRecurringBillResponse;         
	public Object _links;
	private List<Errors> errors;
	public String rowData;
	private Object metaData;
    private TransactionManager transactionManager;
    private BillInformation billInformation;
    private CardDataInformation cardDataInformation;
    private CustomerInformation customerInformation;
    private MerchantInformation merchantInformation; 
    private ScheduleInformation scheduleInformation;
    
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public CardData getCard_data() {
		return card_data;
	}
	public void setCard_data(CardData card_data) {
		this.card_data = card_data;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public String getMetaData() {
		return (String) metaData;
	}
	public void setMetaData(Object metadata) {
		this.metaData = metadata;
	}
	public RecurringBillResponse getLastRecurringBillResponse() {
		return lastRecurringBillResponse;
	}
	public void setLastRecurringBillResponse(
			RecurringBillResponse lastRecurringBillResponse) {
		this.lastRecurringBillResponse = lastRecurringBillResponse;
	}
	public Object get_links() {
		return _links;
	}
	public void set_links(Object _links) {
		this._links = _links;
	}
	public List<Errors> getErrors() {
		return errors;
	}
	public void setErrors(List<Errors> errors) {
		this.errors = errors;
	}
	public String getRowData() {
		return rowData;
	}
	public void setRowData(String rowData) {
		this.rowData = rowData;
	}
	/**
	 * @param transactionManager the transactionManager to set
	 */
	public void setTransactionManager(TransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	/**
	 * @return the billInformation
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public BillInformation getBillInformation() throws JsonParseException, JsonMappingException, IOException {
		if(billInformation==null){
			BillInformation b = new BillInformation(this.transactionManager);
			b.setUrl(this.transactionManager.getUrl()+"recurring-bill/");
			b.getBillForRecurringBillInformationByTransactionId(lastRecurringBillResponse.getRecurringBillId());
			billInformation=b;
		}
		return billInformation;
	}
	/**
	 * @return the cardDataInformation
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public CardDataInformation getCardDataInformation() throws JsonParseException, JsonMappingException, IOException {
		if(cardDataInformation==null){
			CardDataInformation c = new CardDataInformation(this.transactionManager);
			c.getDataByTransaction(TransactionType.RecurringBill, lastRecurringBillResponse.getRecurringBillId());
			cardDataInformation=c;			
			}
		return cardDataInformation;
	}

	/**
	 * @return the customerInformation
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public CustomerInformation getCustomerInformation() throws JsonParseException, JsonMappingException, IOException {
		if(customerInformation==null){
				CustomerInformation c = new CustomerInformation(this.transactionManager);
				c.setUrl(this.transactionManager.getUrl()+"recurring-bill/");
				c.getCustomerForSaleInformationByTransactionId(lastRecurringBillResponse.getRecurringBillId());
				customerInformation=c;				
			}
		return customerInformation; 
	}

	/**
	 * @return the merchantInformation
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public MerchantInformation getMerchantInformation() throws JsonParseException, JsonMappingException, IOException {
		if(merchantInformation==null){			
				MerchantInformation m = new MerchantInformation(this.transactionManager);
				m.getDataByTransaction(TransactionType.RecurringBill, lastRecurringBillResponse.getRecurringBillId());
				merchantInformation=m;				
			}
		return merchantInformation;
	}
	/**
	 * @return the scheduleInformation
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public ScheduleInformation getScheduleInformation() throws JsonParseException, JsonMappingException, IOException {
		if(scheduleInformation==null){			
			ScheduleInformation s = new ScheduleInformation(this.transactionManager);
			s.getDataByTransaction(TransactionType.Schedule, lastRecurringBillResponse.getRecurringBillId());
			scheduleInformation=s;				
		}
		return scheduleInformation;
	}
	public StatusInformation getStatusInformation() throws JsonParseException, JsonMappingException, IOException {
		if(status==null){			
			StatusInformation s = new StatusInformation(this.transactionManager);
			s.getDataByTransaction(TransactionType.RecurringBill, lastRecurringBillResponse.getRecurringBillId());
			status=s;				
		}
		return status;
	}

}
