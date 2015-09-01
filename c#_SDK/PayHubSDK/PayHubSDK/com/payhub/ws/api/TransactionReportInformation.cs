using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace PayHubSDK.com.payhub.ws.api
{
    [DataContract]
    public class TransactionReportInformation
    {
        [DataMember]
        private string transactionID;
        [DataMember]
        private string batchID;
        [DataMember]
        private string transactionDate;
        [DataMember]
        private string customerName;
        [DataMember]
        private string cardType;
        [DataMember]
        private string cardLast4Digits;
        [DataMember]
        private string cardToken;
        [DataMember]
        private string responseCode;
        [DataMember]
        private string responseText;
        [DataMember]
        private string transactionType;
        [DataMember]
        private string amount;
        [DataMember]
        private string authAmount;
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
        private List<Errors> errors;

        public string TransactionID { get { return this.transactionID; } set { this.transactionID = value; } }
        public string BatchID { get { return this.batchID; } set { this.batchID = value; } }
        public string TransactionDate { get { return this.transactionDate; } set { this.transactionDate = value; } }
        public string CustomerName { get { return this.customerName; } set { this.customerName = value; } }
        public string CardType { get { return this.cardType; } set { this.cardType = value; } }
        public string CardLast4Digits { get { return this.cardLast4Digits; } set { this.cardLast4Digits = value; } }
        public string CardToken { get { return this.cardToken; } set { this.cardToken = value; } }
        public string ResponseCode { get { return this.responseCode; } set { this.responseCode = value; } }
        public string ResponseText { get { return this.responseText; } set { this.responseText = value; } }
        public string TransactionType { get { return this.transactionType; } set { this.transactionType = value; } }
        public string Amount { get { return this.amount; } set { this.amount= value; } }
        public string AuthAmount { get { return this.authAmount; } set { this.authAmount = value; } }
        public string Swiped { get { return this.swiped; } set { this.swiped= value; } }
        public string Source { get { return this.source; } set { this.source= value; } }
        public string PhoneNumber { get { return this.phoneNumber; } set { this.phoneNumber= value; } }
        public string Email { get { return this.email; } set { this.email = value; } }
        public string Note { get { return this.note; } set { this.note= value; } }
        public string TransactionStatus { get { return this.transactionStatus; } set { this.transactionStatus = value; } }
        public List<Errors> Errors { get { return this.errors; } set { this.errors = value; } }
    }
}
