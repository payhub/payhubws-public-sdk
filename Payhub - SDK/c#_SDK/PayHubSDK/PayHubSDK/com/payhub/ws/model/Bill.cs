using System;
using System.Numerics;

using System.Runtime.Serialization;

namespace PayHubSDK.com.payhub.ws.model
{
    ///  @author Agustin Breit 
    /// 
    [DataContract]
	public class Bill 
	{
		protected static readonly long serialVersionUID = 2865435483666149222L;
        [DataMember]
        public string note { get; set; }
        [DataMember]
        public string po_number { get; set; }
        [DataMember]
        public string invoice_number { get; set; }
        [DataMember]
        public long? customerId { get; set; }
        [DataMember]
        public long? customerCardId { get; set; }
        [DataMember]
        private TransactionAmount tax_amount;
        public decimal Tax_amount
        {
            get { 
                return tax_amount.Amount; 
            }
            set
            {
                if (value != null) {
                    TransactionAmount t = new TransactionAmount(value);
                    this.tax_amount = t; 
                    }                             
                }
        }
        [DataMember]
        private TransactionAmount base_amount;
        public decimal Base_amount
        {
            get{return this.base_amount.Amount;}
            set
            {                    
                    this.base_amount = new TransactionAmount(value);
            }
        }
        [DataMember]
		private BillingReferences billingReferences{ get; set; }
        [DataMember]
        private TransactionAmount totalAmount;
        public decimal TotalAmount
        {
            get { return this.totalAmount.Amount; }
            set
            {
                    this.totalAmount = new TransactionAmount(value);
            }
        }
        [DataMember]
        private TransactionAmount shipping_amount;
        public decimal Shipping_amount
        {
            get { return this.shipping_amount.Amount; }
            set
            {
                this.shipping_amount = new TransactionAmount(value);
            }
        }

        public Bill() { } 

	}

}

