using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace PayHubSDK.com.payhub.ws.model
{
    [DataContract]
    public class MontlySchedule
    {
        [DataMember]
        private string monthly_type;
        public string Monthly_type
        {
            get { return this.monthly_type; }
            set { if (value != null)this.monthly_type = value; }
        }
        [DataMember]
        private List<int> monthly_each_days;
        public List<int> Monthly_each_days
        {
            get { return this.monthly_each_days; }
            set { if (value != null)this.monthly_each_days = value; } 
        }
        [DataMember]
        private int? monthly_on_the_day_of_week_in_month;
        public int? Monthly_on_the_day_of_week_in_month
        {
            get { return this.monthly_on_the_day_of_week_in_month; }
            set { if (value != null)this.monthly_on_the_day_of_week_in_month = value; }
        }
        
        [DataMember]
        private int? monthly_day_of_week;
        public int? Monthly_day_of_week
        {
            get { return this.monthly_day_of_week; }
            set { if (value != null)this.monthly_day_of_week = value; }
        }
    }
}
