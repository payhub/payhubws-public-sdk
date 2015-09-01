using System.Runtime.Serialization;
namespace PayHubSDK.com.payhub.ws.model
{
    ///  @author Agustin Breit 
    /// 
     [DataContract]
	public class Merchant 
	{
		private static readonly long serialVersionUID = 8527142639482598808L;

		public static readonly string TERMINAL_ID_FIELD = "terminal_id";

		public static readonly string ORGANIZATION_ID_FIELD = "organization_id";
          [DataMember]
        public int organization_id;
          [DataMember]
        public int terminal_id;
          [DataMember]
        private string api_username;
          [DataMember]
        private string api_password;

	}

}

