using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace PayHubSDK.com.payhub.ws.model
{
    ///  @author Agustin Breit 
    /// 
    [DataContract]
    public class CustomerReference
    {
        [DataMember]
        public string customerId;
        [DataMember]
        public string customerEmail;
        [DataMember]
        public List<CustomerPhones> customerPhones;
    }
}
