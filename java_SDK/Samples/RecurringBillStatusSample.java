package Samples;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.payhub.ws.api.RecurringBillResponseInformation;
import com.payhub.ws.api.TransactionManager;
import com.payhub.ws.model.Bill;
import com.payhub.ws.model.CardData;
import com.payhub.ws.model.Customer;
import com.payhub.ws.model.Merchant;
import com.payhub.ws.model.MontlySchedule;
import com.payhub.ws.model.RecurringBill;
import com.payhub.ws.model.Schedule;
import com.payhub.ws.model.ScheduleSartAndEnd;
import com.payhub.ws.model.TransactionAmount;


public class RecurringBillStatusSample {

	public void updateRecurringBill() throws IOException, ParseException {
		
	        String url = "https://staging-api.payhub.com/api/v2/";
	        String oauth = "bb96358e-2aa8-4c6c-8a2e-901b676e979d";
	        ScheduleSartAndEnd scheduleSartAndEnd = new ScheduleSartAndEnd();
	        scheduleSartAndEnd.setStartDate("2015-09-20");
	        scheduleSartAndEnd.setEndDate("2016-07-08");
	        scheduleSartAndEnd.setEnd_date_type("O");
	        MontlySchedule montlySchedule = new MontlySchedule();
	        montlySchedule.setMonthly_type("E");
	        List<Integer> m = new ArrayList<Integer>();
	        m.add(15);
	        montlySchedule.setMonthly_each_days(m);
	        Schedule schedule = new Schedule(scheduleSartAndEnd, montlySchedule);
	        schedule.setSchedule_type("M");
	        schedule.setBill_generation_interval(1);
	        
	        Merchant merchant = new Merchant();
	        merchant.setOrganization_id(10002);
	        merchant.setTerminal_id(2);
	        
	        Bill bill = new Bill();
	        bill.setBase_amount(new TransactionAmount().dollars(new BigDecimal(100)));
	        
	        CardData card_data = new CardData();
	        card_data.setCard_number( "4012881888818888");
	        card_data.setCard_expiry_date("202012"); //September 2018
	        card_data.setBilling_zip ("60527");
	        
	        Customer customer = new Customer();
	        customer.setFirst_name("Joe");
	        customer.setLast_name("Tester");
	        customer.setPhone_number("844-217-1631");
	        customer.setPhone_type("W");
	        
	        RecurringBill recurringBill = new RecurringBill(merchant,card_data,customer,schedule,bill);
	        
	        TransactionManager transaction = new TransactionManager(url, oauth, merchant);
	        RecurringBillResponseInformation response = transaction.doRecurringBill(recurringBill);
	        if(response.getErrors()==null){
	    		String id = response.getLastRecurringBillResponse().getRecurringBillId();
	    		System.out.println(response.getStatusInformation().getStatus().getRecurring_bill_status());
	    		boolean canUpdate = transaction.updateRecurringBillStatus(id);
	    		if(canUpdate){
	    			RecurringBillResponseInformation responseUpdated = transaction.getRecurringBillInformation(id);
	    			if(responseUpdated.getErrors()==null){
	    				System.out.println(responseUpdated.getStatusInformation().getStatus().getRecurring_bill_status());
	    			}
	    		}
	        }
	}

}
