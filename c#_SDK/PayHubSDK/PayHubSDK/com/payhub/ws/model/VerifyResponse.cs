using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace PayHubSDK.com.payhub.ws.model
{
    [DataContract]
    public class VerifyResponse
    {
        [DataMember]
        public string verifyId;
        [DataMember]
        public string approvalCode;
        [DataMember]
        public string processedDateTime;
        [DataMember]
        public string avsResultCode;
        [DataMember]
        public string verificationResultCode;
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
        public string saleDateTime;
        [DataMember]
        public string tokenizedCard;
        [DataMember]
        public CustomerReference customerReference;
    }
}
