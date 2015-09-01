using PayHubSDK.com.payhub.ws.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace PayHubSDK.com.payhub.ws.model
{   
    ///  @author Agustin Breit 
    /// 
    [DataContract]
    public class AuthOnlyResponse
    {
        [DataMember]
        private string transactionId;
        public string TransactionId
        {
            get { return this.transactionId; }
            set
            {
                if (value != null)
                {
                    this.transactionId = value;
                }
            }
        }
        [DataMember]
        public string approvalCode;
        [DataMember]
        public string processedDateTime;
        [DataMember]
        public string avsResultCode;
        [DataMember]
        public string verificationResultCode;
        [DataMember]
        public string batchId;
        [DataMember]
        public string responseCode;
        [DataMember]
        public string responseText;
        [DataMember]
        public string cisNote;
        [DataMember]
        public string riskStatusResponseText;
        [DataMember]
        public string riskStatusRespondeCode;
        [DataMember]
        public string dateTime;
        [DataMember]
        public string tokenizedCard;
        [DataMember]
        public BillingReferences billingReferences;
        [DataMember]
        public CustomerReference customerReference;
    }
}
