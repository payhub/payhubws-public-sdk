﻿using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using PayHubSDK.com.payhub.ws.api;
using PayHubSDK.com.payhub.ws.model;
using System.Globalization;


namespace PayHubWS.Samples
{
    public class AuthOnlyAndCaptureSample
    {
        public void doAuthorization()
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


            Bill bill = new Bill();
            bill.Base_amount = (decimal)7.00m;
            bill.Shipping_amount = (decimal)2.00m;
            bill.Tax_amount = (decimal)1.00m;              
            bill.note = "";
            bill.invoice_number = "";
            bill.po_number = "";
            CardData card_data = new CardData();
            card_data.card_number = "4055011111111111";
            card_data.card_expiry_date = "202012"; //September 2018
            card_data.billing_address_1 = "123 Happy St";
            card_data.billing_address_2 = "On the corner";
            card_data.billing_city = "San Rafael";
            card_data.billing_state = "CA";
            card_data.billing_zip = "12345";
            card_data.cvv_data = "999";
            Customer customer = new Customer();
            customer.first_name = "Joe";
            customer.last_name = "Tester";
            customer.company_name = "Payhub Inc";
            customer.job_title = "Software Engineer";
            customer.email_address = "test@payhub.com";
            customer.web_address = "http://payhub.com";
            customer.phone_number = "844-217-1631";
            customer.phone_ext = "123";
            customer.phone_type = "W";
            AuthOnly authorization = new AuthOnly(merchant,bill,card_data,customer);

            TransactionManager transaction = new TransactionManager(url, oauth, merchant);
            AuthorizationResponseInformation response = transaction.doAuthonly(authorization);
            Console.Write(response.rowData);
            if (response.errors == null)
            {
                var transactionId = response.AuthOnlyResponse.TransactionId;
                Capture capture = new Capture(merchant, transactionId, bill);
                CaptureResponseInfromation responseCapture = transaction.doCapture(capture);
                Console.Write(responseCapture.rowData);
            }
            else
            {
                Console.Write(response.errors);
            }


        }
    }
}
