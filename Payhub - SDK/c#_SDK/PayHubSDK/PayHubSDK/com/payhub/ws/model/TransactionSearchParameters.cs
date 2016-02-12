using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace PayHubSDK.com.payhub.ws.model
{
    [DataContract]
    public class TransactionSearchParameters
    {
        [DataMember]
        private string batchIdFrom;
        [DataMember]
        private string batchIdTo;
        [DataMember]
        private string transactionType;
        [DataMember]
        private string responseCode;
        [DataMember]
        private string amountFrom;
        [DataMember]
        private string amountTo;
        [DataMember]
        private string firstName;
        [DataMember]
        private string lastName;
        [DataMember]
        private string trnDateFrom;
        [DataMember]
        private string trnDateTo;
        [DataMember]
        private string cardType;
        [DataMember]
        private string cardLast4Digits;
        [DataMember]
        private string cardToken;
        [DataMember]
        private string authAmountFrom;
        [DataMember]
        private string authAmountTo;
        [DataMember]
        private string swiped;
        [DataMember]
        private string source;
        [DataMember]
        private string phoneNumber;
        [DataMember]
        private string email;
        [DataMember]
        private string note;
        [DataMember]
        private string transactionStatus;
        [DataMember]
        private string customerId;
        


        public string BatchIdFrom { get { return this.batchIdFrom; } set { this.batchIdFrom = value; } }
        public string BatchIdTo { get { return this.batchIdTo; } set { this.batchIdTo = value; } }
        public string TransactionType { get { return this.transactionType; } set { this.transactionType = value; } }
        public string ResponseCode { get { return this.responseCode; } set { this.responseCode = value; } }
        public string AmountFrom { get { return this.amountFrom; } set { this.amountFrom = value; } }
        public string AmountTo { get { return this.amountTo; } set { this.amountTo = value; } }
        public string FirstName { get { return this.firstName; } set { this.firstName = value; } }
        public string LastName { get { return this.lastName; } set { this.lastName = value; } }
        public string TrnDateFrom { get { return this.trnDateFrom; } set { this.trnDateFrom = value; } }
        public string TrnDateTo { get { return this.trnDateTo; } set { this.trnDateTo = value; } }  
     
        public string CardType { get { return this.cardType; } set { this.cardType = value; } }
        public string CardLast4Digits { get { return this.cardLast4Digits; } set { this.cardLast4Digits = value; } }
        public string CardToken { get { return this.cardToken; } set { this.cardToken = value; } }
        public string AuthAmountFrom { get { return this.authAmountFrom; } set { this.authAmountFrom = value; } }
        public string AuthAmountTo { get { return this.authAmountTo; } set { this.authAmountTo = value; } }
        public string Swiped { get { return this.swiped; } set { this.swiped = value; } }
        public string Source { get { return this.source; } set { this.source = value; } }
        public string PhoneNumber { get { return this.phoneNumber; } set { this.phoneNumber = value; } }
        public string Email { get { return this.email; } set { this.email = value; } }
        public string Note { get { return this.note; } set { this.note = value; } }
        public string TransactionStatus { get { return this.transactionStatus; } set { this.transactionStatus = value; } }
        public string CustomerId { get { return this.customerId; } set { this.customerId = value; } }
    }
}
