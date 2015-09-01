using PayHubSDK.com.payhub.ws.api;
using PayHubSDK.com.payhub.ws.model;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Globalization;


namespace PayHubWS.Samples
{
    public class RefundSample
    {
        public void doRefund(){
            string url = "https://staging-api.payhub.com/api/v2/";
            string oauth = "107d74ab-4a18-4713-88ff-69bd05710086";

            Merchant merchant = new Merchant();
            merchant.organization_id = 10127;
            merchant.terminal_id = 215;
            
            //'{someSaleId}' is the Id for the sale that is going to be refunded, each refund transaction will be valid only if the batch has been settled
            //'{someRecordFormat}' like CREDIT_CARD
            var someSaleId = "someSaleId";
            var someRecordFormat = "CREDIT_CARD";
            Refund refund = new Refund(merchant, someSaleId, someRecordFormat);
            TransactionManager transaction = new TransactionManager(url, oauth, merchant);
            RefundInformation response = transaction.doRefund(refund);
            Console.Write(response.rowData);
        }
    }
}
