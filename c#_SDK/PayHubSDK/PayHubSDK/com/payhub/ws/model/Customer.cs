using PayHubSDK.com.payhub.ws.model;
using System.Runtime.Serialization;


namespace PayHubSDK.com.payhub.ws.model
{
    ///  @author Agustin Breit 
    /// 
     [DataContract]
	public class Customer 
	{
		private static readonly long serialVersionUID = 7246202263731350762L ;

		public static readonly string CUSTOMER_ID_FIELD = "customerId";
          [DataMember]
		public string first_name { get; set; }
          [DataMember]
        public string last_name { get; set; }
          [DataMember]
        public string email_address { get; set; }
          [DataMember]
        public string phone_number { get; set; }
          [DataMember]
        public string phone_ext { get; set; }
          [DataMember]
        public string phone_type { get; set; }
          [DataMember]
        public string company_name { get; set; }
          [DataMember]
        public string job_title { get; set; }
          [DataMember]
        public string web_address { get; set; }
          [DataMember]
        public long customerId { get; set; }

       // private CustomerReference customerReference { get; set; }


	}

}

