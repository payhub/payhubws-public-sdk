using System.Runtime.Serialization;
using PayHubSDK.com.payhub.ws.model;

namespace PayHubSDK.com.payhub.ws.model
{
    ///  @author Agustin Breit 
    /// 
    [DataContract]
	public class CardData 
	{
		protected static readonly long serialVersionUID = -1025520346816831812L;

		protected static readonly string CARD_NUMBER_FIELD = "card_number";

		private static readonly string CARD_EXPIRY_DATE_FIELD = "card_expiry_date";

		private static readonly string TRACK1_DATA_FIELD = "track1_data";

		private static readonly string TRACK2_DATA_FIELD = "track2_data";

		private static readonly string ENCRYPTED_DATA_FIELD = "encrypted_track_data";

		private static readonly string TOKENIZED_CARD_DATA_FIELD = "tokenized_card";

		private static readonly string CVV_FIELD = "cvv_data";

		private static readonly string CARD_EXPIRY_REGEX = "2[0-9][0-9]{2}(0[1-9]|1[0-2])";

		private static readonly string ZIP_REG_EX = "^\\d{5}(?:[-\\s]\\d{4})?$";
         [DataMember]
        public string cvv_data { get; set; }
         [DataMember]
        public string track1_data { get; set; }
         [DataMember]
        public string track2_data { get; set; }
         [DataMember]
        public string card_number { get; set; }
         [DataMember]
        public string card_expiry_date { get; set; }
         [DataMember]
        public string tokenized_card { get; set; }
         [DataMember]
        public string billing_address_1 { get; set; }
         [DataMember]
        public string billing_address_2 { get; set; }
         [DataMember]
        public string billing_city { get; set; }
         [DataMember]
        public string billing_state { get; set; }
         [DataMember]
        public string billing_zip { get; set; }
        [DataMember(Name = "encrypted_track_data")]
        private EncryptedTrackData _encrypted_track_data;
        
        public string encrypted_track_data {
             get {
                 if (this._encrypted_track_data != null)
                 {
                     return this._encrypted_track_data.encrypted_track;
                 }
                 else {
                     return "";
                 }
             }
             set {                  
                 EncryptedTrackData enc = new EncryptedTrackData(value);
                 this._encrypted_track_data = enc;                 
             }
         }
		

	}

}

