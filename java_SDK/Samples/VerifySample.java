/**
 * 
 */
package Samples;

import java.io.IOException;
import java.math.BigDecimal;

import com.payhub.ws.api.TransactionManager;
import com.payhub.ws.api.VerfyResponseInformation;
import com.payhub.ws.model.CardData;
import com.payhub.ws.model.Customer;
import com.payhub.ws.model.Merchant;
import com.payhub.ws.model.TransactionAmount;
import com.payhub.ws.model.Verify;

/**
 * @author agustin
 *
 */
public class VerifySample {
	public void doVerify() throws IOException {
        String url = "https://staging-api.payhub.com/api/v2/";
        String oauth = "bb96358e-2aa8-4c6c-8a2e-901b676e979d";

        Merchant merchant = new Merchant();
        merchant.organization_id = 10127;
        merchant.terminal_id = 215;

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
        
        Verify verify = new Verify(merchant, card_data, customer);
        TransactionManager transaction = new TransactionManager(url, oauth, merchant);
        VerfyResponseInformation response = transaction.doVerify(verify);
        System.out.println(response.getRowData());
    }
}
