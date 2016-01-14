using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace PayHubSDK.com.payhub.ws.model
{
    ///  @author Agustin Breit 
    ///   
    [DataContract]
    public class EncryptedTrackData
    {
        [DataMember(Name = "encrypted_track")]
        private string _encrypted_track = "";
        
        public string encrypted_track{
            get { return this._encrypted_track; }
            set { this._encrypted_track = value; }
        }
        

        [DataMember]
        private string swiper_brand = "IDTECH";
        [DataMember]
        private string swiper_model = "UNIMAGII";
        

        public EncryptedTrackData(string value)
        {
            if (value != null)
            {
                this._encrypted_track = value;
            }
            else {
                this._encrypted_track = "";
            }
        }

    }
}
