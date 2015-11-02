package Samples;

import java.io.IOException;
import java.util.List;

import com.payhub.ws.api.TransactionManager;
import com.payhub.ws.api.TransactionReportInformation;
import com.payhub.ws.api.TransactionType;
import com.payhub.ws.model.Merchant;
import com.payhub.ws.model.TransactionSearchParameters;

public class FindTransactionReportsSample {
	public void findTransactions() throws IOException{
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

        TransactionSearchParameters tsp = new TransactionSearchParameters();
        tsp.setAmountFrom("1");
        tsp.setAmountTo("1002");
		TransactionManager transaction = new TransactionManager(url, oauth, merchant);
		List<TransactionReportInformation> tri = transaction.findTransactions(tsp);

	}
}
