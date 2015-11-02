using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace PayHubSDK.com.payhub.ws.model
{
    [DataContract]
    public class ScheduleSartAndEnd
    {
        [DataMember]
        private string start_date;
        public DateTime Start_date 
        {
            get {
                DateTime dt = Convert.ToDateTime(this.start_date);
                return dt;
            }
            set {
                    this.start_date = value.ToString("yyyy-MM-dd");
            }
        }
        [DataMember]
        public string end_date_type;
        [DataMember]
        private string end_date;
        public DateTime End_date
        {
            get {
                DateTime dt = Convert.ToDateTime(this.end_date);
                return dt;
            }
            set {
                this.end_date = value.ToString("yyyy-MM-dd");
            }
        }
    }
}
