using Newtonsoft.Json;
using PayHubSDK.com.payhub.ws.model;
using PayHubSDK.com.payhub.ws.api;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PayHubSDK.com.payhub.ws.api
{
    public class ScheduleInformation : AbstractInfo
    {
        public Schedule schedule;
        public ScheduleInformation(): base()
        {
            this.transactionType = TransactionType.Schedule;
        }

        public ScheduleInformation(TransactionManager transactionManager): base(transactionManager)
        {
            this.transactionType = TransactionType.Schedule;
        }
        public override void convertData(string json)
        {
            schedule = JsonConvert.DeserializeObject<Schedule>(json);
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
