using Newtonsoft.Json;
using System;
using System.IO;
using System.Net;
using PayHubSDK.com.payhub.ws.model;
using System.Runtime.Serialization;
using PayHubSDK.com.payhub.ws.api;
using PayHubSDK.com.payhub.ws.util;

namespace PayHubSDK.com.payhub.ws.model
{
	///  @author Agustin Breit 
	/// 
    [DataContract]
    public class Sale : WsConnections
	{
		private static readonly long serialVersionUID = 2178857785393382979L;

        public static readonly string SALE_ID_LINK = "sale/";
		
        public static readonly string CARD_DATA_FIELD = "card_data";

		public static readonly string MERCHANT_FIELD = "merchant";

		public static readonly string CUSTOMER_FIELD = "customer";

		public static readonly string BILL_FIELD = "bill";

		public static readonly string SALE_RESPONSE_FIELD = "saleResponse";

		public static readonly string NOT_SETTLED_STATE = "Not settled";

		public static readonly string SETTLED_STATE = "Settled";

		private string settlementStatus = NOT_SETTLED_STATE;
        
        private string _url_operation = "sale/";
        private string _url_basePath;
        public string _url {
            get { return this._url_basePath + this._url_operation; }
            set { if (value != null)this._url_basePath = value; }
        }
        [DataMember]
        private Merchant merchant;
        public Merchant Merchant
        {
            get { return this.merchant; }
            set { if (value != null) {
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

        public Sale(model.Merchant merchant, model.Bill bill, CardData card_data, model.Customer customer)
        {
            // TODO: Complete member initialization
            this.merchant = merchant;
            this.bill = bill;
            this.card_data = card_data;
            this.customer = customer;
        }

        public SaleResponseInformation doSale(string json, HttpWebRequest request)
        {
            SaleResponseInformation responseObject = new SaleResponseInformation();
            using (var streamWriter = new StreamWriter(request.GetRequestStream()))
            {
                streamWriter.Write(json);
                streamWriter.Flush();
                streamWriter.Close();
            }
            var result = doPost(request, _url);
            responseObject = JsonConvert.DeserializeObject<SaleResponseInformation>(result);
            responseObject.rowData = result;
            return responseObject;
        }
    }

}

