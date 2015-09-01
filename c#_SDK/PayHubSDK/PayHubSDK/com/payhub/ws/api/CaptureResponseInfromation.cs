using PayHubSDK.com.payhub.ws.model;
using PayHubSDK.com.payhub.ws.api;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace PayHubSDK.com.payhub.ws.api
{
    [DataContract]
    public class CaptureResponseInfromation
    {
        [DataMember(Name = "metaData")]
        private Object metadata;
        
        public Object Metadata
        {
            get { return this.metadata.ToString(); }
            set
            {
                if (value != null)
                    this.metadata = value.ToString();
            }
        }
         [DataMember]
        public CaptureResponse lastCaptureResponse { get; set; }
         [DataMember]
         public Object _links { get; set; }
         [DataMember]
         public List<Errors> errors { get; set; }
        public string rowData { get; set; }
        private TransactionManager _transactionManager;
        public TransactionManager transactionManager { set { this._transactionManager = value; } }
        private BillInformation _billInformation;
        public BillInformation billInformation
        {
            get
            {
                if (_billInformation == null)
                {
                    BillInformation b = new BillInformation(this._transactionManager);
                    b.url = this._transactionManager.Url + "capture/";
                    b.getBillForSaleInformationByTransactionId(lastCaptureResponse.TransactionId);
                    _billInformation = b;
                }
                return _billInformation;
            }
        }
        private MerchantInformation _merchantInformation;
        public MerchantInformation merchantInformation
        {
            get
            {
                if (_merchantInformation == null)
                {
                    MerchantInformation m = new MerchantInformation(this._transactionManager);
                    m.getDataByTransaction(TransactionType.Capture, lastCaptureResponse.TransactionId);
                    _merchantInformation = m;
                }
                return _merchantInformation;
            }
        }
    }
}
