using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace PayHubSDK.com.payhub.ws.model
{
    [DataContract]
    public class YearlySchedule
    {
        [DataMember]
        private String year_to_start;
        public String Year_to_start
        {
            get { return this.year_to_start; }
            set { if (value != null)this.year_to_start = value; }
        }
        [DataMember]
        private int? yearly_bill_on_month_number;
        public int? Yearly_bill_on_month_number
        {
            get { return this.yearly_bill_on_month_number; }
            set { if (value != 0)this.yearly_bill_on_month_number = value; }
        }
        [DataMember]
        private String yearly_bill_on_day_of_month;
        public String Yearly_bill_on_day_of_month
        {
            get { return this.yearly_bill_on_day_of_month; }
            set { if (value != null)this.yearly_bill_on_day_of_month = value; }
        }

    }
}
