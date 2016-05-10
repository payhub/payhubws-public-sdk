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
    public class GeneralSettings
    {
        public static string GENERAL_SETTINGS_LINK = "adminSettings/generalSettings";

        [DataMember]
        public string inactivityHour;
        [DataMember]
        public List<TerminalList> terminalList;
        [DataMember]
        public List<Errors> errors;

        [DataContract]
        public class TerminalList
        {
            [DataMember]
            public string nickName;
            [DataMember]
            public string terminalType;
            [DataMember]
            public string settlementTime;

            public TerminalList() { }
        }
    }
    
}
