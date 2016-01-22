/**
 * 
 */
package Samples;

import java.io.IOException;

import com.payhub.ws.api.RefundInformation;
import com.payhub.ws.api.TransactionManager;
import com.payhub.ws.model.*;


/**
 * @author agustin
 *
 */
public class RefundSample {
	public static void doRefund() throws IOException{
        String url = "https://staging-api.payhub.com/api/v2/";
        String oauth = "bb96358e-2aa8-4c6c-8a2e-901b676e979d";

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
        Sale sale = new Sale(merchant, bill, card_data, customer);

        TransactionManager transaction = new TransactionManager(url, oauth, merchant);
        SaleResponseInformation response = transaction.doSale(sale);
        
		if(response.getErrors()==null){
			String saleId = response.getSaleResponse().getSaleId();
	        String record_format="CREDIT_CARD";
	        Refund refund = new Refund(merchant, saleId, record_format);
	        transaction = new TransactionManager(url, oauth, merchant);
	        RefundInformation refundResponse = transaction.doRefund(refund);
	        System.out.println(refundResponse.getLastRefundResponse().getRefundTransactionId());
		}
    }
	public static void doRefundWithDiffAmmount() throws IOException{
        String url = "https://staging-api.payhub.com/api/v2/";
        String oauth = "bb96358e-2aa8-4c6c-8a2e-901b676e979d";

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
        Sale sale = new Sale(merchant, bill, card_data, customer);

        TransactionManager transaction = new TransactionManager(url, oauth, merchant);
        SaleResponseInformation response = transaction.doSale(sale);
        System.out.println(response.getRowData());
		if(response.getErrors()==null){
			String saleId = response.getSaleResponse().getSaleId();
	        String record_format="CREDIT_CARD";
			Bill billForRefund = new Bill();
			billForRefund.setBase_amount(new TransactionAmount().dollars(new BigDecimal(200)));
			billForRefund.setShipping_amount((new TransactionAmount().dollars(new BigDecimal(300))));
			billForRefund.setTax_amount((new TransactionAmount().dollars(new BigDecimal(200))));
			billForRefund.note = "";
			billForRefund.invoice_number = "";
			billForRefund.po_number = "";
	        Refund refund = new Refund(merchant, saleId, record_format,billForRefund);
	        transaction = new TransactionManager(url, oauth, merchant);
	        RefundInformation refundResponse = transaction.doRefund(refund);
	        System.out.println(refundResponse.getLastRefundResponse().getRefundTransactionId());
		}
    }


	public static void doRefundWithOutSale() throws IOException{
        String url = "https://staging-api.payhub.com/api/v2/";
        String oauth = "bb96358e-2aa8-4c6c-8a2e-901b676e979d";

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
        
		String record_format="CREDIT_CARD";
        TransactionManager transaction = new TransactionManager(url, oauth, merchant);
        Refund refund = new Refund(merchant,record_format,bill,customer,card_data);
	    RefundInformation refundResponse = transaction.doRefund(refund);
	    System.out.println(refundResponse.getLastRefundResponse().getRefundTransactionId());
		
    }
}
