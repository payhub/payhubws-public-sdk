/**
 * 
 */
package Samples;

import java.io.IOException;

import com.payhub.ws.api.RefundInformation;
import com.payhub.ws.api.TransactionManager;
import com.payhub.ws.model.Merchant;
import com.payhub.ws.model.Refund;

/**
 * @author agustin
 *
 */
public class RefundSample {
	public void doRefund() throws IOException{
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

        //'{someSaleId}' is the Id for the sale that is going to be refunded, each refund transaction will be valid only if the batch has been settled
        //'{someRecordFormat}' like CREDIT_CARD
        String transaction_id="someSaleId";
        String record_format="CREDIT_CARD";
        Refund refund = new Refund(merchant, transaction_id, record_format);
        TransactionManager transaction = new TransactionManager(url, oauth, merchant);
        RefundInformation response = transaction.doRefund(refund);
        System.out.println(response.getRowData());
    }
}
