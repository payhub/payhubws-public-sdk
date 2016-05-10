using PayHubSDK.com.payhub.ws.util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;
using PayHubSDK.com.payhub.ws.api;

namespace PayHubSDK.com.payhub.ws.vt
{
    [DataContract]
    public class ValidatedDevices
    {
        public static string VALIDATED_DEVICES_LINK = "adminSettings/validatedDevices";

        [DataMember]
        public Boolean enforce_device_validation;
        [DataMember]
        public List<Devices> devices;
        [DataMember]
        public List<Errors> errors;

        public ValidatedDevices() { }

        [DataContract]
        public class Devices
        {
            [DataMember]
            public string product;
            [DataMember]
            public string nick_name;
            [DataMember]
            public string platform;
            [DataMember]
            public string details;
            [DataMember]
            public string date_added;
            [DataMember]
            public long device_id;
            public Devices() { }
        }
    }
    
}
