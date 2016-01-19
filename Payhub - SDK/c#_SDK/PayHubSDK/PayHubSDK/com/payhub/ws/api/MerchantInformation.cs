using Newtonsoft.Json;
using PayHubSDK.com.payhub.ws.api;
using PayHubSDK.com.payhub.ws.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PayHubSDK.com.payhub.ws.api
{
    public class MerchantInformation : AbstractInfo
    {
        public Merchant merchant;
        
        public MerchantInformation(): base()
        {
            this.transactionType = TransactionType.Merchant;
        }

        public MerchantInformation(TransactionManager transactionManager): base(transactionManager)
        {            
            this.transactionType = TransactionType.Merchant;
        }
        public override void convertData(string json)
        {
            merchant = JsonConvert.DeserializeObject<Merchant>(json, new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
        }

        public override string getUrlForTransactionType(TransactionType type)
        {
            string url = null;
            if (TransactionType.Sale.Equals(type))
            {
                url = "sale/";
            }
            if (TransactionType.AuthOnly.Equals(type))
            {
                url = "authonly/";
            }
            if (TransactionType.Capture.Equals(type))
            {
                url = "capture/";
            } if (TransactionType.Bill.Equals(type))
            {
                url = "bill";
            } if (TransactionType.CardData.Equals(type))
            {
                url = "carddata/";
            } if (TransactionType.Customer.Equals(type))
            {
                url = "customer/";
            } if (TransactionType.Merchant.Equals(type))
            {
                url = "merchant/";
            } if (TransactionType.RecurringBill.Equals(type))
            {
                url = "recurring-bill/";
            } if (TransactionType.Schedule.Equals(type))
            {
                url = "schedule/";
            } if (TransactionType.Refund.Equals(type))
            {
                url = "refund/";
            } if (TransactionType.VoidTransaction.Equals(type))
            {
                url = "void/";
            }
            if (TransactionType.Verify.Equals(type))
            {
                url = "verify/";
            }
            return url;
        }
    }
}
