using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PayHubSDK.com.payhub.ws.api
{
    public enum TransactionType
    {
        Sale,//forSale
        AuthOnly,//forAuthOnly
        Capture,//forCapture
        Bill,//forBill
        CardData,//forCardData
        Customer,//forCustomer
        Merchant,//forMerchant
        RecurringBill,//forRecurringBill
        Schedule,//forSchedule
        Refund,//forRefund
        VoidTransaction,
        Verify//forVoid
    }
}
