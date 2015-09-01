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
        String url = "https://staging-api.payhub.com/api/v2/";
        String oauth = "107d74ab-4a18-4713-88ff-69bd05710086";

        Merchant merchant = new Merchant();
        merchant.organization_id = 10127;
        merchant.terminal_id = 215;
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
