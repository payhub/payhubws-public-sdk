using PayHubSDK.com.payhub.ws.api;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace PayHubSDK.com.payhub.ws.vt
{
    [DataContract]
    public class Batch
    {
        public static string BATCH_LINK = "batch/";

        [DataMember]
        public string terminalId;
        [DataMember(Name = "MSG")]
        public string msg;
        [DataMember]
        public string orgnazationId;
        [DataMember]
        public string batchId;
        [DataMember(Name = "TRN_RESPONSE")]
        public TransactionResponse trnResponse;

        [DataMember]
        private List<Errors> errors;

        public List<Errors> Errors { get { return this.errors; } set { this.errors = value; } }

        [DataContract]
        public class TransactionResponse{
            [DataMember(Name = "RESPONSE_TEXT")]
            public string responseText;
            [DataMember(Name = "RESPONSE_CODE")]
            public string responseCode;
            [DataMember(Name = "TRN_DATE_TIME")]
            public string trnDateTime;
        }
    }
}
