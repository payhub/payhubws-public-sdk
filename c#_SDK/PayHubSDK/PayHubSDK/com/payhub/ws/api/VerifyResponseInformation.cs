using PayHubSDK.com.payhub.ws.model;
using PayHubSDK.com.payhub.ws.api;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace PayHubSDK.com.payhub.ws.api
{   [DataContract]
    public class VerifyResponseInformation
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
        private VerifyResponse verifyResponse;
        public VerifyResponse _verifyResponse
        {
            get { return this.verifyResponse; }
            set
            {
                if (value != null)
                    this.verifyResponse = value;
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
