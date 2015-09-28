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
    class SaleAndVoidSample
    {
        public void doSale()
        {
            string url = "https://staging-api.payhub.com/api/v2/";
            string oauth = "bb96358e-2aa8-4c6c-8a2e-901b676e979d";

            Merchant merchant = new Merchant();
            merchant.organization_id = 10127;
            merchant.terminal_id = 215;


            Bill bill = new Bill();
            bill.Base_amount = (decimal)7.00m;
            bill.Shipping_amount = (decimal)2.00m;
            bill.Tax_amount = (decimal)1.00m;
            bill.note = "";
            bill.invoice_number = "";
            bill.po_number = "";
            CardData card_data = new CardData();
            card_data.card_number = "4055011111111111";
            card_data.card_expiry_date = "202012";
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
            Sale sale = new Sale(merchant, bill, card_data, customer);

            TransactionManager transaction = new TransactionManager(url, oauth, merchant);
            SaleResponseInformation response = transaction.doSale(sale);
            Console.Write(response.rowData);
            if (response.errors == null)
            {
                var saleId = response.SaleResponse.SaleId;
                VoidTransaction voidTransaction = new VoidTransaction(merchant, saleId);
                VoidResponseInformation voidInfo = transaction.doVoid(voidTransaction);
                Console.Write(voidInfo.rowData);
            }
            else {
                Console.Write(response.errors);
            }
        }

        public void getInformation()
        {
            string url = "https://staging-api.payhub.com/api/v2/";
            string oauth = "107d74ab-4a18-4713-88ff-69bd05710086";

            Merchant merchant = new Merchant();
            merchant.organization_id = 10127;
            merchant.terminal_id = 215;

            TransactionManager transaction = new TransactionManager(url, oauth, merchant);
            SaleResponseInformation response = transaction.getSaleInformation("18243011");
            Console.Write(response.rowData);
        }
    }
}
