using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace PayHubSDK.com.payhub.ws.model
{   [DataContract]
    public class Status
    {
        [DataMember]
        public string id;
        [DataMember]    
        public string version;
        [DataMember]    
        public string createdAt;
        [DataMember]    
        public string lastModified;
        [DataMember]    
        public string createdBy;
        [DataMember]    
        public string lastModifiedBy;
        [DataMember]
        public string nextBillDate;
        [DataMember]
        public string recurring_bill_status;
        [DataMember]
        public string statusLastChangedOn;
    }
}
