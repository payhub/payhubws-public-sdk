using PayHubSDK.com.payhub.ws.api;
using PayHubSDK.com.payhub.ws.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PayHubWS_sample_app.Samples
{
    class GetTransactionsListSample
    {
        public void getLists() {
 			/* The current url, oauth_token, orgId and Terminal Id provided in this example, are only for testing purposes
			*  For development purposes you need to contact the Payhub Integration Support team. They will provide you with  *  all you need.
			*  Thanks.
			*/
			//Defining the Web Service URL
            string url = "https://sandbox-api.payhub.com/api/v2/";
            string oauth = "2a5d6a73-d294-4fba-bfba-957a4948d4a3";
           
            Merchant merchant = new Merchant();
            merchant.organization_id = 10074;
            merchant.terminal_id = 134;


            TransactionManager transaction = new TransactionManager(url, oauth, merchant);
            // debug and see the result list for each transaction
            var a = transaction.getAllBillForSaleInformation();
            var b = transaction.getAllBillForRecurringBillInformation();
            var c = transaction.getAllCardDataInformation();
            var d = transaction.getAllCustomerForRecurringBillInformation();
            var e = transaction.getAllCustomerForSalesInformation();
            var f = transaction.getAllMerchantInformation();
            
        }
    }
}
