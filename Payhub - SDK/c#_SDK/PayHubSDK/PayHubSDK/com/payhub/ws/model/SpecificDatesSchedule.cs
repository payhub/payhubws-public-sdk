using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace PayHubSDK.com.payhub.ws.model
{
    [DataContract]
    public class SpecificDatesSchedule
    {
        [DataMember]
        private String[] specific_dates;
        public String[] Specific_dates
        {
            get { return this.specific_dates; }
            set { if (value != null)this.specific_dates = value; }
        }
    }
}
