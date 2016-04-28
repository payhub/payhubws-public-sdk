using Newtonsoft.Json;
using PayHubSDK.com.payhub.ws.api;
using PayHubSDK.com.payhub.ws.util;
using PayHubSDK.com.payhub.ws.model;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace PayHubSDK.com.payhub.ws.model
{
    [DataContract]
    public class RecurringBill : WsConnections
    {
        private string _url_operation = "recurring-bill/";
        private string _url_basePath;
        public string _url
        {
            get { return this._url_basePath + this._url_operation; }
            set { if (value != null)this._url_basePath = value; }
        }
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

        //public Merchant merchant { get; set; }
        [DataMember]
        private Customer customer;
        public Customer Customer
        {
            get { return this.customer; }
            set
            {
                if (value != null)
                {
                    this.customer = value;
                }
            }
        }
        //public SaleResponse saleResponse { get; set; }

        //private RecordFormat record_format { get; set; }
        [DataMember]
        private Bill bill;
        public Bill Bill
        {
            get { return this.bill; }
            set
            {
                if (value != null)
                {
                    this.bill = value;
                }
            }
        }
        [DataMember]
        private CardData card_data;
        public CardData Card_data
        {
            get { return this.card_data; }
            set
            {
                if (value != null)
                {
                    this.card_data = value;
                }
            }
        }
        [DataMember]
        private Schedule schedule;
        public static string RECURRENT_BILL_ID_LINK = "recurring-bill/";
        public Schedule Schedule 
        {
            get { return this.schedule; }
            set
            {
                if (value != null)
                {
                    this.schedule = value;
                }
            }
        }

        public RecurringBill(Merchant merchant, CardData card_data, Customer customer, model.Schedule schedule, Bill bill)
        {
            // TODO: Complete member initialization
            this.merchant = merchant;
            this.card_data = card_data;
            this.customer = customer;
            this.schedule = schedule;
            this.bill = bill;
        }
        public RecurringBill(){ }

        public RecurringBillInformation PerformRecurringBill(string json, System.Net.HttpWebRequest request)
        {
            RecurringBillInformation responseObject = new RecurringBillInformation();
            using (var streamWriter = new StreamWriter(request.GetRequestStream()))
            {
                streamWriter.Write(json);
                streamWriter.Flush();
                streamWriter.Close();
            }
            var result = doPost(request, _url);
            responseObject = JsonConvert.DeserializeObject<RecurringBillInformation>(result);
            responseObject.rowData = result;
            return responseObject;
  
        }

        
    }
}

