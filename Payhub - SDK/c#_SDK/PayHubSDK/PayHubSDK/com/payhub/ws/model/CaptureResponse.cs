using PayHubSDK.com.payhub.ws.model;
using PayHubSDK.com.payhub.ws.api;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace PayHubSDK.com.payhub.ws.model
{
    [DataContract]
    public class CaptureResponse
    {
        [DataMember]
        private string batchId;
        public string BatchId { get{return this.batchId;} set { this.batchId=value; }}
        [DataMember]
        private string transactionId;
        public string TransactionId { get { return this.transactionId; } set { this.transactionId = value; } }
        [DataMember]
        private BillingReferences billingReferences;
        public BillingReferences BillingReferences { get { return this.billingReferences; } set { this.billingReferences = value; } }
    }
}
