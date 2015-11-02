package Samples;

import java.io.IOException;

import com.payhub.ws.api.TransactionType;
import com.payhub.ws.api.TransactionManager;
import com.payhub.ws.model.Merchant;

public class MetadataSample {
	public void addMetadata() throws IOException{
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
         String datos = "{\"order\": {\"id\": 465, \"invoice\":\"MyIncoice\", \"lines\": [{\"City\": \"Cordoba\"}, {\"Neighborhood\": \"Nueva Cordoba\"}]}}";
	    transaction.addMetaData(datos, TransactionType.Sale, saleId);          
        System.out.println(voidInfo.getRowData());
		}else{
			System.out.println(response.getErrors());
		}
	   
	}
}
