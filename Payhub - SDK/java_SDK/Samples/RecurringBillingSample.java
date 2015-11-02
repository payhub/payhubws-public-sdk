/**
 * 
 */
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

/**
 * @author agustin
 *
 */
public class RecurringBillingSample {
	public void doRecurringBilling() throws IOException, ParseException
    {
    	 /* The current url, oauth_token, orgId and Terminal Id provided in this example, are only for testing purposes
		 *  For development purposes you need to contact the Payhub Integration Support team. They will provide you with  *  all you need.
		 *  Thanks.
		 */
		 //Defining the Web Service URL
         String url = "https://sandbox-api.payhub.com/api/v2/";
         String oauth = "2a5d6a73-d294-4fba-bfba-957a4948d4a3";

         Merchant merchant = new Merchant();
         merchant.setOrganization_id(10074);
         merchant.setTerminal_id(134);

        ScheduleSartAndEnd scheduleSartAndEnd = new ScheduleSartAndEnd();
        scheduleSartAndEnd.setStartDate("2015-07-08");
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
        
        
        Bill bill = new Bill();
        bill.setBase_amount(new TransactionAmount().dollars(new BigDecimal(100)));
        
        CardData card_data = new CardData();
        card_data.setCard_number( "5466410004374507");
        card_data.setCard_expiry_date("202012"); //September 2018
        card_data.setBilling_zip ("12345");
        
        Customer customer = new Customer();
        customer.setFirst_name("Joe");
        customer.setLast_name("Tester");
        customer.setPhone_number("844-217-1631");
        customer.setPhone_type("W");
        
        RecurringBill recurringBill = new RecurringBill(merchant,card_data,customer,schedule,bill);
        
        TransactionManager transaction = new TransactionManager(url, oauth, merchant);
        RecurringBillResponseInformation response = transaction.doRecurringBill(recurringBill);
        System.out.println(response.rowData);
    }
	public void findAll() throws IOException, ParseException
    {
    	 /* The current url, oauth_token, orgId and Terminal Id provided in this example, are only for testing purposes
		 *  For development purposes you need to contact the Payhub Integration Support team. They will provide you with  *  all you need.
		 *  Thanks.
		 */
		 //Defining the Web Service URL
         String url = "https://sandbox-api.payhub.com/api/v2/";
         String oauth = "2a5d6a73-d294-4fba-bfba-957a4948d4a3";

         Merchant merchant = new Merchant();
         merchant.setOrganization_id(10074);
         merchant.setTerminal_id(134);

        TransactionManager transaction = new TransactionManager(url, oauth, merchant);
        List<RecurringBillResponseInformation> response = transaction.getAllRecurringBillInformation();
        System.out.println(response.get(0).rowData);
    }
}
