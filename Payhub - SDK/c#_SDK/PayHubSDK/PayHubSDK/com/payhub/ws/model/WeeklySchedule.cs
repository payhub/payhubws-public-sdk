using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace PayHubSDK.com.payhub.ws.model
{
    [DataContract]
    public class WeeklySchedule
    {
        [DataMember]
        private String[] weekly_bill_days;
        public String[] Weekly_bill_days
        {
            get { return this.weekly_bill_days; }
            set { if (value != null)this.weekly_bill_days = value; }
        }
    }
}
