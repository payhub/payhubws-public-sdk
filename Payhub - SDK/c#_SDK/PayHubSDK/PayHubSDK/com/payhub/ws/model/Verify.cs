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
{   [DataContract]
    public class Verify : WsConnections
    {
        private string _url_operation = "verify/";
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
        
        [DataMember]
        private CardData card_data;
        public static string VERIFY_ID_LINK = "verify/";

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
        public Verify(Merchant merchant, CardData card_data, Customer customer)
        {
            // TODO: Complete member initialization
            this.merchant = merchant;
            this.card_data = card_data;
            this.customer = customer;
        }
        public VerifyResponseInformation performVoidTransaction(string json, HttpWebRequest request)
        {

            VerifyResponseInformation responseObject = new VerifyResponseInformation();
            using (var streamWriter = new StreamWriter(request.GetRequestStream()))
            {
                streamWriter.Write(json);
                streamWriter.Flush();
                streamWriter.Close();
            }
            var result = doPost(request, _url);
            responseObject = JsonConvert.DeserializeObject<VerifyResponseInformation>(result);
            responseObject.rowData = result;
            return responseObject;
        }

    }
}
