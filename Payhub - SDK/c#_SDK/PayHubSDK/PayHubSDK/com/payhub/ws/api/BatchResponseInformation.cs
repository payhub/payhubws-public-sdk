using PayHubSDK.com.payhub.ws.model;
using PayHubSDK.com.payhub.ws.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;
using PayHubSDK.com.payhub.ws.api;
using Newtonsoft.Json.Linq;
using PayHubSDK.com.payhub.ws.vt;

namespace PayHubSDK.com.payhub.ws.api
{
    ///  @author Agustin Breit 
    /// 
    [DataContract]
    public class BatchResponseInformation
    {
        [DataMember(Name = "transactions_detail")]
        public List<TransactionReportInformation> transactions_detail;        
        [DataMember]
        public string batch_settled_on;
        [DataMember]
        public string batch_status;
        [DataMember]
        public BatchInfo batch_info;
        [DataMember]
        private List<Errors> errors;

        public List<Errors> Errors { get { return this.errors; } set { this.errors = value; } }

        [DataContract]
        public class BatchInfo {
            [DataMember]
            public AllTransactions all_transactions;
            [DataMember]
            public List<CreditCards> credit_cards;
        }
       
    }
}
