using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace PayHubSDK.com.payhub.ws.model
{
    [DataContract]
    public class RefundResponse
    {
        [DataMember]
        private string saleTransactionId;
        public string SaleTransactionId { get { return this.saleTransactionId; } set { this.saleTransactionId = value; } }
        [DataMember]
        private string refundTransactionId;
        public string RefundTransactionId { get { return this.refundTransactionId; } set { this.refundTransactionId = value; } }
        [DataMember]
        private string token;
        public string Token { get { return this.token; } set { this.token = value; } }
    }
}
