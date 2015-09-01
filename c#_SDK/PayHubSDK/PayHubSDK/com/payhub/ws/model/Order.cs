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
    public class Order
    {        
        private long id;
        [DataMember(Name="id")]
        public long Id
        {
            get{return this.id;}
            set {this.id=value;}
        }
        private string invoice;
        [DataMember(Name="invoice")]
        public string Invoice
        {
            get{return this.invoice;}
            set {
                if(value!=null)
                    this.invoice=value;
            }
        }
        private List<Object> lines;
        [DataMember(Name="lines")]
        public List<Object> Lines
        {
            get { return this.lines; }
            set
            {
                if (value != null)
                    this.lines.Add(value);
            }
        }
    }
}
