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
    public class Refund : WsConnections
    {
        public static string REFUND_ID_LINK = "refund/";
        private string _url_operation = "refund/";
        private string _url_basePath;
        public string _url
        {
            get { return this._url_basePath + this._url_operation; }
            set { if (value != null)this._url_basePath = value; }
        }
        [DataMember]
        private string transaction_id;
        public string Transaction_id
        {
            get { return this.transaction_id; }
            set
            {
                if (value != null)
                {
                    this.transaction_id = value;
                }
            }
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
        [DataMember]
        private string record_format;
        public string Record_format
        {
            get { return this.record_format; }
            set { if (value != null)this.record_format = value; }
        }

        [DataMember(Name = "bill")]
        private Bill _bill;
        public Bill bill
        {
            get { return this._bill; }
            set { if (value != null)this._bill = value; }
        }
        [DataMember(Name = "customer")]
        private Customer _customer;
        public Customer customer
        {
            get { return this._customer; }
            set { if (value != null)this._customer = value; }
        }
        [DataMember(Name = "card_data")]
        private CardData _card_data;
        public CardData card_data
        {
            get { return this._card_data; }
            set { if (value != null)this._card_data = value; }
        }

        public Refund(Merchant merchant, string transaction_id, string record_format)
        {
            // TODO: Complete member initialization
            this.merchant = merchant;
            this.transaction_id = transaction_id;
            this.record_format = record_format;
        }
        public Refund(Merchant merchant, string transaction_id, string record_format,Bill bill)
        {
            // TODO: Complete member initialization
            this.merchant = merchant;
            this.transaction_id = transaction_id;
            this.record_format = record_format;
            this._bill = bill;
        }

        public Refund(Merchant merchant, string record_format, Bill bill,Customer customer,CardData card)
        {
            // TODO: Complete member initialization
            this.merchant = merchant;
            this.record_format = record_format;
            this._bill = bill;
            this._customer = customer;
            this._card_data = card;
        }

        public RefundInformation PerformRefund(string json, HttpWebRequest request)
        {
            RefundInformation responseObject = new RefundInformation();
            using (var streamWriter = new StreamWriter(request.GetRequestStream()))
            {
                streamWriter.Write(json);
                streamWriter.Flush();
                streamWriter.Close();
            }
            var result = doPost(request, _url);
            responseObject = JsonConvert.DeserializeObject<RefundInformation>(result);
            responseObject.rowData = result;
            return responseObject;
        }


        
    }
}
