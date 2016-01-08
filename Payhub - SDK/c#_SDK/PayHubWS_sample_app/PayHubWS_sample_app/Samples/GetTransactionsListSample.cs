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
            string url = "https://staging-api.payhub.com/api/v2/";
            string oauth = "107d74ab-4a18-4713-88ff-69bd05710086";

            Merchant merchant = new Merchant();
            merchant.organization_id = 10127;
            merchant.terminal_id = 215;

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
