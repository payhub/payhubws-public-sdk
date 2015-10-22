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
