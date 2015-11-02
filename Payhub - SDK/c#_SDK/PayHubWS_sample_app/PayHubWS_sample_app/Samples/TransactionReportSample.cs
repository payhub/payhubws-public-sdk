using PayHubSDK.com.payhub.ws.api;
using PayHubSDK.com.payhub.ws.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PayHubWS.Samples
{
    class TransactionReportSample
    {
        public void findReports()
        {
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


            TransactionSearchParameters tsp = new TransactionSearchParameters();
            tsp.AmountFrom = "1";
            tsp.AmountTo = "1002";
            tsp.CardLast4Digits = "4507";
            tsp.BatchIdFrom = "1300";
            tsp.BatchIdTo = "1320";
            tsp.Email = "marrighi";
            tsp.TransactionType = "Sale";
            tsp.ResponseCode = "00";
            tsp.FirstName = "First";
            tsp.LastName = "Cont";
            tsp.PhoneNumber = "(415) 479 1349";
            tsp.TrnDateFrom = "2015-04-01 00:00:00";
            tsp.TrnDateTo = "2015-04-30 00:00:00";
            tsp.CardType = "MasterCard";
            tsp.CardToken = "9999000000001853";
            tsp.Swiped = "true";
            tsp.Source = "3rd Party API";


            TransactionManager transaction = new TransactionManager(url, oauth, merchant);
            List<TransactionReportInformation> tri = transaction.findTransactions(tsp);
            
            Console.Write(tri.ElementAt(0).CustomerName);

        }
    }
}
