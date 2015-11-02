using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace PayHubSDK.com.payhub.ws.model
{
    [DataContract]
    public class CustomerPhones
    {
        [DataMember]
        public string phone;
        [DataMember]
        public string extension;
        [DataMember]
        public string type;
    }
}
