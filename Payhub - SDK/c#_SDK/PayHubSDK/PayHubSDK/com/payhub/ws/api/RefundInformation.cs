using PayHubSDK.com.payhub.ws.model;
using PayHubSDK.com.payhub.ws.api;
using PayHubSDK.com.payhub.ws.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace PayHubSDK.com.payhub.ws.api
{
    [DataContract]
    public class RefundInformation
    {
        [DataMember(Name = "metaData")]
        private string _metadata = "";

        public string metaData { get { return this._metadata.ToString(); } set { if (value != null) { this._metadata = value.ToString(); } else { this._metadata = ""; } } }
        [DataMember]
        private Merchant merchant;
        public Merchant Merchant
        {
            get { return this.merchant; }
            set
            {
                if (value != null)
                {
                    this.merchant = value;
                }
            }
        }
        [DataMember]
        public string transaction_id;
        [DataMember]
        public RefundResponse lastRefundResponse;
        [DataMember]
        public string merchantOrganizationId;
        [DataMember]
        public Object _links;

        [DataMember]
        public List<Errors> errors;
        public string rowData { get; set; }
        private TransactionManager _transactionManager;
        public TransactionManager transactionManager { set { this._transactionManager = value; } }
        private MerchantInformation _merchantInformation;
        public MerchantInformation merchantInformation
        {
            get
            {
                if (_merchantInformation == null)
                {
                    MerchantInformation m = new MerchantInformation(this._transactionManager);
                    m.getDataByTransaction(TransactionType.Refund, lastRefundResponse.RefundTransactionId);
                    _merchantInformation = m;
                }
                return _merchantInformation;
            }
        }
    }
}
