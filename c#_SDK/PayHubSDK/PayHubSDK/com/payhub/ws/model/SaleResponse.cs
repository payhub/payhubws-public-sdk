using System;
using System.Runtime.Serialization;
using System.Collections.Generic;
using PayHubSDK.com.payhub.ws.model;

namespace PayHubSDK.com.payhub.ws.model
{
    ///  @author Agustin Breit 
    /// 
    [DataContract]
	public class SaleResponse
	{
		private static readonly long serialVersionUID = 1L;
        [DataMember]
		private string saleId;
        public string SaleId {
            get { return saleId; }
            set { if (value != null)saleId = value; }
        }
        [DataMember]
		public string approvalCode;
        [DataMember]
		public string processedDateTime;
        [DataMember]
		public string avsResultCode;
        [DataMember]
		public string verificationResultCode;
        [DataMember]
		public string batchId;
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
		public BillingReferences billingReferences;
        [DataMember]
		public CustomerReference customerReference;

	}

}

