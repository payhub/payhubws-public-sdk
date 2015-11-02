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
    [DataContract]
    public class Capture : WsConnections
    {
        private string _url_operation = "capture/";
        private string _url_basePath;
        public string _url
        {
            get { return this._url_basePath+this._url_operation; }
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
        [DataMember]
        private string transaction_id;
        public string TransactionId
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
        private Bill bill;
        public static string CAPTURE_ID_LINK = "capture/";
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

        public Capture(Merchant merchant, string transactionId, Bill bill)
        {
            // TODO: Complete member initialization
            this.merchant = merchant;
            this.TransactionId = transactionId;
            this.bill = bill;
        }
        public CaptureResponseInfromation captureData(string json, HttpWebRequest request)
        {
            CaptureResponseInfromation responseObject = new CaptureResponseInfromation();
            using (var streamWriter = new StreamWriter(request.GetRequestStream()))
            {
                streamWriter.Write(json);
                streamWriter.Flush();
                streamWriter.Close();
            }
            var result = doPost(request, _url);
            responseObject = JsonConvert.DeserializeObject<CaptureResponseInfromation>(result);
            responseObject.rowData = result;
            return responseObject;       
        }


    }

}

