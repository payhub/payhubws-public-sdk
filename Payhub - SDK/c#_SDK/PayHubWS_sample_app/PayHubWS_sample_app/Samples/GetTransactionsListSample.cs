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
            string url = "https://sandbox-api.payhub.com/api/v2/";
            string oauth = "2a5d6a73-d294-4fba-bfba-957a4948d4a3";

            Merchant merchant = new Merchant();
            merchant.organization_id = 10074;
            merchant.terminal_id = 134;
            

            TransactionManager transaction = new TransactionManager(url, oauth, merchant);
            // debug and see the result list for each transaction
            var sales = transaction.getAllSalesInformation(0,100);
            var auths = transaction.getAllAuthOnlyInformation(0,100);
            var caps = transaction.getAllCaptureInformation(0,100);
            var voids = transaction.getAllVoidResponseInformation(0,100);
            var refunds = transaction.getAllRefundInformation(0,100);

            var a = transaction.getAllBillForSaleInformation(0,100);
            var b = transaction.getAllBillForRecurringBillInformation(0,100);
            var c = transaction.getAllCardDataInformation(0,100);
            var d = transaction.getAllCustomerForRecurringBillInformation(0,100);
            var e = transaction.getAllCustomerForSalesInformation(0,100);
            var f = transaction.getAllMerchantInformation(0,100);
            
        }
    }
}
