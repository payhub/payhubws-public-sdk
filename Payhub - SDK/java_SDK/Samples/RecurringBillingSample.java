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
        String url = "https://staging-api.payhub.com/api/v2/";
        String oauth = "107d74ab-4a18-4713-88ff-69bd05710086";
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
        
        Merchant merchant = new Merchant();
        merchant.setOrganization_id(10127);
        merchant.setTerminal_id(215);
        
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
}
