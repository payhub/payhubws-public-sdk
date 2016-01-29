using Newtonsoft.Json.Linq;
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
    ///  @author Agustin Breit 
    /// 
    [DataContract]
    public class SaleResponseInformation
    {
        [DataMember(Name = "metaData")]
        private JToken _metaData = "";
        public JToken metaData { get { return this._metaData.ToString(); } set { if (value != null) { this._metaData = value.ToObject<string>(); } else { this._metaData = ""; } } }
        [DataMember]
        private SaleResponse saleResponse;
        public SaleResponse SaleResponse {
            get { return this.saleResponse; }
            set
            {
                if (value != null)
                    this.saleResponse = value;    
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
        private BillInformation _billInformation;
        public BillInformation billInformation
        {
            get
            {
                if (_billInformation == null)
                {
                    BillInformation b = new BillInformation(this._transactionManager);
                    b.url = this._transactionManager.Url + "sale/";
                    b.getBillForSaleInformationByTransactionId(saleResponse.SaleId);
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
                    CardDataInformation c = new CardDataInformation(this._transactionManager);
                    c.getDataByTransaction(TransactionType.Sale, saleResponse.SaleId);
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
                    c.Url = this._transactionManager.Url + "sale/";
                    c.getCustomerForSaleInformationByTransactionId(saleResponse.SaleId);
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
                    m.getDataByTransaction(TransactionType.Sale, saleResponse.SaleId);
                    _merchantInformation = m;
                }
                return _merchantInformation;
            }
        }
    }
}
