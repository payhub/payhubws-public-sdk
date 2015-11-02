using Newtonsoft.Json;
using PayHubSDK.com.payhub.ws.api;
using PayHubSDK.com.payhub.ws.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PayHubSDK.com.payhub.ws.api
{
    public class CardDataInformation:AbstractInfo
    {
        public CardData cardData;

        public CardDataInformation(): base()
        {
            this.transactionType = TransactionType.CardData;
        }

        public CardDataInformation(TransactionManager transactionManager):base(transactionManager)
        {            
            this.transactionType = TransactionType.CardData;
        }

        public override void convertData(string json)
        {
            cardData = JsonConvert.DeserializeObject<CardData>(json, new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
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
