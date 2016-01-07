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
		String url = "https://staging-api.payhub.com/api/v2/";
        String oauth = "107d74ab-4a18-4713-88ff-69bd05710086";
        Merchant merchant = new Merchant();
        merchant.organization_id = 10127;
        merchant.terminal_id = 215;	
        TransactionSearchParameters tsp = new TransactionSearchParameters();
        tsp.setAmountFrom("1");
        tsp.setAmountTo("1002");
		TransactionManager transaction = new TransactionManager(url, oauth, merchant);
		List<TransactionReportInformation> tri = transaction.findTransactions(tsp);

	}
}
