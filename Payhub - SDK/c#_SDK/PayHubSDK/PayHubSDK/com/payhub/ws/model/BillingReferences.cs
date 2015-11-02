using System;
using System.Runtime.Serialization;

namespace PayHubSDK.com.payhub.ws.model
{
    ///  @author Agustin Breit 
    /// 
    [DataContract]
	public class BillingReferences
	{
        
		private static readonly long serialVersionUID = -9171573799378897702L;
        private string cardObscured;
        [DataMember(Name="cardObscured")]
        public string CardObscured
        {
            get { return this.cardObscured; }
            set
            {
                if (value != null)
                    cardObscured = value;
            }
        }
        private string tokenizedCard;
        [DataMember(Name = "tokenizedCard")]
        public string TokenizedCard
        {
            get { return this.tokenizedCard; }
            set
            {
                if (value != null)
                    this.tokenizedCard = value;
            }
        }
        private long customerId;
        [DataMember(Name = "customerId")]
        public long CustomerId 
        { 
            get{
                return this.customerId;
            }
            set
            {
                this.customerId = value;
            }
        }
        private string customerCardId;
        [DataMember(Name = "customerCardId")]
        public string CustomerCardId
        {
            get { return this.customerCardId; }
            set
            {
                if (value != null)
                    this.customerCardId = value;
            }
        }
        private long customerBillId;
        [DataMember(Name="customerBillId")]
        public long CustomerBillId
        {
            get
            {
                return this.customerBillId;
            }
            set
            {
                this.customerBillId = value;
            }
        }

        

	}

}

