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
    public class VoidTransaction : WsConnections
    {
        private string _url_operation = "void/";
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
        [DataMember]
        private string transaction_id;
        public static string VOID_ID_LINK = "void/";
        //private string saleId;

        public VoidTransaction(Merchant merchant, string saleId)
        {
            // TODO: Complete member initialization
            this.merchant = merchant;
            this.transaction_id = saleId;
        }
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

        public VoidResponseInformation performVoidTransaction(string json, HttpWebRequest request)
        {
            VoidResponseInformation responseObject = new VoidResponseInformation();
            using (var streamWriter = new StreamWriter(request.GetRequestStream()))
            {
                streamWriter.Write(json);
                streamWriter.Flush();
                streamWriter.Close();
            }
            var result = doPost(request, _url);
            responseObject = JsonConvert.DeserializeObject<VoidResponseInformation>(result);
            responseObject.rowData = result;
            return responseObject;
        }

    }
}
