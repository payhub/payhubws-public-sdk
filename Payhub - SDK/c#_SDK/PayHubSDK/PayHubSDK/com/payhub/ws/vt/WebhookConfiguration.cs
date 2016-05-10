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
    public class WebhookConfiguration
    {
        public static string WEBHOOK_LINK = "adminSettings/webhookConfiguration";

        [DataMember]
        public Boolean mobileHub;
        [DataMember]
        public Boolean recurringBill;
        [DataMember]
        public Boolean virtualHub;
        [DataMember]
        public Boolean webhookActive;
        [DataMember]
        public Boolean api;
        [DataMember]
        public Boolean batchIsActive;
        [DataMember]
        public string endPoint;
        [DataMember]
        public List<Errors> errors;
    }
}
