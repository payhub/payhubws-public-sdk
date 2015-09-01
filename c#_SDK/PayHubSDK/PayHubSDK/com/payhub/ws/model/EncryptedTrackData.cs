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
        [DataMember]
        private string encrypted_track = "";
        [DataMember]
        private string swiper_brand = "IDTECH";
        [DataMember]
        private string swiper_model = "UNIMAGII";
        

        public EncryptedTrackData(string value)
        {
            // TODO: Complete member initialization
            this.encrypted_track = value;
        }

    }
}
