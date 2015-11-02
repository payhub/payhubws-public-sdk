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
    public class RecurringBillInformation
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
        public RecurringBillResponse lastRecurringBillResponse;         
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
                    b.url = this._transactionManager.Url + "recurring-bill/";
                    b.getBillForSaleInformationByTransactionId(lastRecurringBillResponse.RecurringBillId);
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
                    c.getDataByTransaction(TransactionType.RecurringBill, lastRecurringBillResponse.RecurringBillId);
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
                    c.Url = this._transactionManager.Url + "recurring-bill/";
                    c.getCustomerForSaleInformationByTransactionId(lastRecurringBillResponse.RecurringBillId);
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
                    m.getDataByTransaction(TransactionType.RecurringBill, lastRecurringBillResponse.RecurringBillId);
                    _merchantInformation = m;
                }
                return _merchantInformation;
            }
        }
        private ScheduleInformation _scheduleInformation;
        public ScheduleInformation scheduleInformation
         {
            get
            {
                if (_scheduleInformation == null)
                {
                    ScheduleInformation s = new ScheduleInformation(this._transactionManager);
                    s.getDataByTransaction(TransactionType.RecurringBill, lastRecurringBillResponse.RecurringBillId);
                    _scheduleInformation = s;
                }
                return _scheduleInformation;
            }
        }

        private StatusInformation _statusInformation;
        public  StatusInformation statusInformation
        {
            get
            {
                if (_statusInformation == null)
                {
                    StatusInformation s = new StatusInformation(this._transactionManager);
                    s.getDataByTransaction(TransactionType.RecurringBill, lastRecurringBillResponse.RecurringBillId);
                    _statusInformation = s;
                }
                return _statusInformation;
            }
        }
    }
}
