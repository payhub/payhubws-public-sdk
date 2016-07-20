using PayHubSDK.com.payhub.ws.util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;
using PayHubSDK.com.payhub.ws.api;

namespace PayHubSDK.com.payhub.ws.vt
{
    [DataContract]
    public class TransactionTotals
    {
        public static string TRN_TOTAL_LINK = "report/transactionTotals";

        [DataMember]
        public List<CreditCards> credit_cards;
        [DataMember]
        public AllTransactions all_transactions;       
        [DataMember]
        private List<Errors> errors;

        public List<Errors> Errors { get { return this.errors; } set { this.errors = value; } }
    }
}
