using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace PayHubSDK.com.payhub.ws.vt
{
    [DataContract]
    public class CreditCards
    {
        [DataMember]
        public int transactions_no;
        [DataMember]
        public float transactions_total_net;
        [DataMember]
        public float sales_total;
        [DataMember]
        public float refunds_total;
        [DataMember]
        public string card_type;
    }
}
