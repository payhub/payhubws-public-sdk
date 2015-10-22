/**
 * 
 */
package Samples;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import com.payhub.ws.api.BillInformation;
import com.payhub.ws.api.CardDataInformation;
import com.payhub.ws.api.CustomerInformation;
import com.payhub.ws.api.VoidResponseInformation;
import com.payhub.ws.api.MerchantInformation;
import com.payhub.ws.api.SaleResponseInformation;
import com.payhub.ws.api.TransactionManager;
import com.payhub.ws.model.Bill;
import com.payhub.ws.model.CardData;
import com.payhub.ws.model.Customer;
import com.payhub.ws.model.Merchant;
import com.payhub.ws.model.Sale;
import com.payhub.ws.model.TransactionAmount;
import com.payhub.ws.model.VoidTransaction;

/**
 * @author agustin
 *
 */
public class SaleAndVoidSample {
	public void doSale() throws IOException
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
        Sale sale = new Sale(merchant, bill, card_data, customer);

        TransactionManager transaction = new TransactionManager(url, oauth, merchant);
        SaleResponseInformation response = transaction.doSale(sale);
        System.out.println(response.getRowData());
		if(response.getErrors()==null){
		String saleId = response.getSaleResponse().getSaleId();
        VoidTransaction voidTransaction = new VoidTransaction(merchant, saleId);
        VoidResponseInformation voidInfo = transaction.doVoid(voidTransaction);            
        System.out.println(voidInfo.getRowData());
		}else{
			System.out.println(response.getErrors());
		}
        

        
    }
	 public void getInformation() throws IOException
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
         List<BillInformation> bills = transaction.getAllBillForSalesInformation();
         List<BillInformation> bills2 = transaction.getAllBillForRecurringBillInformation();
         List<CustomerInformation> custom = transaction.getAllCustomerForRecurringBillInformation();
         List<CustomerInformation> custome = transaction.getAllCustomerForSalesInformation();
         List<MerchantInformation> m= transaction.getAllMerchantInformation();
         List<CardDataInformation> carddata = transaction.getAllCardDataInformation();
         
     }
}
