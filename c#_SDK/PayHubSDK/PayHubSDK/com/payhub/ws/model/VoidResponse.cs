using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace PayHubSDK.com.payhub.ws.model
{
    [DataContract]
    public class VoidResponse
    {
        [DataMember]
        public string saleTransactionId;
        
        [DataMember]
        private string voidTransactionId;
        public string VoidTransactionId
        {
            get { return this.voidTransactionId; }
            set
            {
                if (value != null)
                {
                    this.voidTransactionId = value;
                }
            }
        }
        [DataMember]
        public string token;
    }
}
