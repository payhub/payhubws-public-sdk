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
    public class EmailConfiguration
    {
        public static string EMAIL_LINK = "adminSettings/emailConfiguration";

        [DataMember]
        public Boolean emailRbFailTransaction;
        [DataMember]
        public Boolean emailRbSuccessTransaction;
        [DataMember]
        public Boolean emailBatchFail;
        [DataMember]
        public Boolean emailBatchSuccess;
        [DataMember]
        public Boolean emailTrnReceipt;
        [DataMember]
        public Boolean emailExpPsw;
        [DataMember]
        public Boolean customBatchReport;
        [DataMember]
        public string pdfOrCsvForBatch;
        [DataMember]
        public Boolean customRBReport;
        [DataMember]
        public string pdfOrCsvForRB;
        [DataMember]
        public List<Errors> errors;
    }
}
