/**
 * 
 */
package Samples;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.payhub.ws.api.AuthorizationResponseInformation;
import com.payhub.ws.api.CaptureResponseInformation;
import com.payhub.ws.api.TransactionType;
import com.payhub.ws.api.SaleResponseInformation;
import com.payhub.ws.api.TransactionManager;
import com.payhub.ws.model.AuthOnly;
import com.payhub.ws.model.Bill;
import com.payhub.ws.model.Capture;
import com.payhub.ws.model.CardData;
import com.payhub.ws.model.Customer;
import com.payhub.ws.model.Merchant;
import com.payhub.ws.model.TransactionAmount;

/**
 * @author agustin
 *
 */
public class AuthOnlyAndCaptureSample {
	 public void doAuthorization() throws IOException
     {
         String url = "https://staging-api.payhub.com/api/v2/";
         String oauth = "107d74ab-4a18-4713-88ff-69bd05710086";
        
         Merchant merchant = new Merchant();
         merchant.organization_id = 10127;
         merchant.terminal_id = 215;
         Bill bill = new Bill();
         bill.setBase_amount(new TransactionAmount().dollars(new BigDecimal(100)));
         bill.setShipping_amount((new TransactionAmount().dollars(new BigDecimal(200))));
         bill.setTax_amount((new TransactionAmount().dollars(new BigDecimal(100))));
         bill.note = "";
         bill.invoice_number = "";
         bill.po_number = "";
         CardData card_data = new CardData();
         card_data.setCard_number( "5466410004374507");
         card_data.setCard_expiry_date("202012"); //September 2018
         card_data.setBilling_address_1 ("123 Happy St");
         card_data.setBilling_address_2 ("On the corner");
         card_data.setBilling_city ("San Rafael");
         card_data.setBilling_state ("CA");
         card_data.setBilling_zip ("12345");
         card_data.setCvv_data ("998");
         
         Customer customer = new Customer();
         customer.setFirst_name("Joe");
         customer.setLast_name("Tester");
         customer.setCompany_name("Payhub Inc");
         customer.setJob_title("Software Engineer");
         customer.setEmail_address("test@payhub.com");
         customer.setWeb_address("http://payhub.com");
         customer.setPhone_number("844-217-1631");
         customer.setPhone_ext("123");
         customer.setPhone_type("W");
         AuthOnly authorization = new AuthOnly(merchant,bill,card_data,customer);
         TransactionManager transaction = new TransactionManager(url, oauth, merchant);
         AuthorizationResponseInformation auth =  transaction.doAuthOnly(authorization);
         System.out.println(auth.getRowData());
         
     }
}
