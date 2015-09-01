using PayHubSDK.com.payhub.ws.model;
using PayHubSDK.com.payhub.ws.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;
using PayHubSDK.com.payhub.ws.api;

namespace PayHubSDK.com.payhub.ws.api
{
    ///  @author Agustin Breit 
    /// 
    [DataContract]
    public class AuthorizationResponseInformation
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
        private AuthOnlyResponse authOnlyResponse;
        public AuthOnlyResponse AuthOnlyResponse
        {
            get { return this.authOnlyResponse; }
            set
            {
                if (value != null)
                    this.authOnlyResponse = value;    
            }
        }
        [DataMember]
        public Object _links;

        [DataMember]
        public List<Errors> errors;
       
        public string rowData { get; set; }
        private TransactionManager transactionManager;
        public TransactionManager TransactionManager
        { get { return this.transactionManager; } set { this.transactionManager = value; } }
        private BillInformation _billInformation;
        public BillInformation billInformation
        { get {
            if (_billInformation == null)
            {
                BillInformation b = new BillInformation(this.transactionManager);
                b.url = this.transactionManager.Url + "authonly/";
                b.getBillForSaleInformationByTransactionId(authOnlyResponse.TransactionId);
                _billInformation = b;
            }
            return _billInformation;
            } 
        }
        private CardDataInformation _cardDataInformation;
        public CardDataInformation cardDataInformation
        {
            get
            {
                if (_cardDataInformation == null)
                {
                    CardDataInformation c = new CardDataInformation(this.transactionManager);
                    c.getDataByTransaction(TransactionType.AuthOnly, authOnlyResponse.TransactionId);
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
                    CustomerInformation c = new CustomerInformation(this.transactionManager);
                    c.Url = this.transactionManager.Url + "authonly/";
                    c.getCustomerForSaleInformationByTransactionId(authOnlyResponse.TransactionId);
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
                    MerchantInformation m = new MerchantInformation(this.transactionManager);
                    m.getDataByTransaction(TransactionType.AuthOnly, authOnlyResponse.TransactionId);
                    _merchantInformation = m;
                }
                return _merchantInformation;
            }
        }
    }
}
