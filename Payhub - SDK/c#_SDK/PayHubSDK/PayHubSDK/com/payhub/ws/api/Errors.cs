using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace PayHubSDK.com.payhub.ws.api
{
    ///  @author Agustin Breit 
    /// 
    [DataContract]
    public class Errors
    {
        [DataMember]
        private string status;
        public string Status { get { return this.status; } set { if (value != null)this.status = value; } }
        [DataMember]
        private string code;
        public string Code { get { return this.code; } set { if (value != null)this.code = value; } }
        [DataMember]
        private string location;
        public string Location { get { return this.location; } set { if (value != null)this.location = value; } }
        [DataMember]
        private string reason;
        public string Reason { get { return this.reason; } set { if (value != null)this.reason = value; } }
        [DataMember]
        private string severity;
        public string Severity { get { return this.severity; } set { if (value != null)this.severity = value; } }
    }
}
