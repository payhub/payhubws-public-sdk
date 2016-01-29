using PayHubSDK.com.payhub.ws.model;
using PayHubSDK.com.payhub.ws.api;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;
using Newtonsoft.Json.Linq;

namespace PayHubSDK.com.payhub.ws.api
{   [DataContract]
    public class VerifyResponseInformation
    {
        [DataMember(Name = "metaData")]
        private JToken _metaData = "";
        public JToken metaData { get { return this._metaData.ToString(); } set { if (value != null) { this._metaData = value.ToObject<string>(); } else { this._metaData = ""; } } }
        [DataMember]
        private VerifyResponse _verifyResponse;
        public VerifyResponse verifyResponse
        {
            get { return this._verifyResponse; }
            set
            {
                if (value != null)
                    this._verifyResponse = value;
            }
        }
        [DataMember]
        public Object _links;

        [DataMember]
        public List<Errors> errors;
        public string rowData { get; set; }
        private TransactionManager _transactionManager;
        public TransactionManager transactionManager
        { set { this._transactionManager = value; } }        
        private CardDataInformation _cardDataInformation;
        public CardDataInformation cardDataInformation
        {
            get
            {
                if (_cardDataInformation == null)
                {
                    CardDataInformation c = new CardDataInformation(this._transactionManager);
                    c.getDataByTransaction(TransactionType.Verify, verifyResponse.verifyId);
                    _cardDataInformation = c;
                }
                return _cardDataInformation;
            }
        }
        private CustomerInformation _customerInformation;
        public CustomerInformation customerInformation
        {
            get
            {
                if (_customerInformation == null)
                {
                    CustomerInformation c = new CustomerInformation(this._transactionManager);
                    c.Url = this._transactionManager.Url + "verify/";
                    c.getCustomerForSaleInformationByTransactionId(verifyResponse.verifyId);
                    _customerInformation = c;
                }
                return _customerInformation;
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
                    m.getDataByTransaction(TransactionType.Verify, verifyResponse.verifyId);
                    _merchantInformation = m;
                }
                return _merchantInformation;
            }
        }
    }
}
