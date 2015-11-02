using PayHubSDK.com.payhub.ws.model;
using PayHubSDK.com.payhub.ws.api;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;
using PayHubSDK.com.payhub.ws.util;

namespace PayHubSDK.com.payhub.ws.model
{
    ///  @author Agustin Breit 
    /// 
    [DataContract]
    public class AuthOnly : WsConnections
    {
        public static string AUTH_ID_LINK = "authonly/";
        private string _url_operation = "authonly/";
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
        public AuthOnly(Merchant merchant, Bill bill, CardData card_data,Customer customer)
        {
            this.merchant = merchant;
            this.bill = bill;
            this.card_data = card_data;
            this.customer = customer;
        }

        public AuthorizationResponseInformation authonly(string json, HttpWebRequest request)
        {
            AuthorizationResponseInformation responseObject = new AuthorizationResponseInformation();
            using (var streamWriter = new StreamWriter(request.GetRequestStream()))
            {
                streamWriter.Write(json);
                streamWriter.Flush();
                streamWriter.Close();
            }
            var result = doPost(request, _url);
            responseObject = JsonConvert.DeserializeObject<AuthorizationResponseInformation>(result);
            responseObject.rowData = result;
            return responseObject;

        }

       
    }
}
