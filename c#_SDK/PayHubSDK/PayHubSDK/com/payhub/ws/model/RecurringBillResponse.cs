using PayHubSDK.com.payhub.ws.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace PayHubSDK.com.payhub.ws.model
{
    [DataContract]
    public class RecurringBillResponse
    {
        [DataMember]
        private string recurringBillId;
        public string RecurringBillId { get { return this.recurringBillId; } set { this.recurringBillId = value; } }
        [DataMember]
        private CustomerReference customerReference;
        public CustomerReference CustomerReference { get { return this.customerReference; } set { this.customerReference = value; } }
        [DataMember]
        private BillingReferences billingReferences;
        public BillingReferences BillingReferences { get { return this.billingReferences; } set { this.billingReferences = value; } }
    }
}
