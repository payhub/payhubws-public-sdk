using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using PayHubSDK.com.payhub.ws.api;
using PayHubSDK.com.payhub.ws.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Runtime.Serialization;
using System.Text;

namespace PayHubSDK.com.payhub.ws.api
{
    [DataContract]
    public class BillInformation
    {
        [DataMember(Name = "version")]
        private string _version;
        [DataMember(Name = "createdAt")]
        private string _createdAt;
       [DataMember(Name = "lastModified")]
        private string _lastModified;
        [DataMember(Name = "createdBy")]
        private string _createdBy;
       [DataMember(Name = "lastModifiedBy")]
        private string _lastModifiedBy;
        [DataMember(Name = "metaData")]
        private Object _metaData;
	    private TransactionManager transactionManager;
        public TransactionManager TransactionManager { set { this.transactionManager = value; } }
	    private TransactionType transactionType;

        public string Version { get { return this._version; } set { this._version = value; } }
        public string CreatedAt { get { return this._createdAt; } set { this._createdAt = value; } }
        public string LastModified { get { return this._lastModified; } set { this._lastModified = value; } }
        public string CreatedBy { get { return this._createdBy; } set { this._createdBy = value; } }
        public string LastModifiedBy { get { return this._lastModifiedBy; } set { this._lastModifiedBy = value; } }
        public Object metaData { get { return this._metaData.ToString(); } set { this._metaData = value.ToString(); } }
        public string url { get; set; }
        public Bill bill { get; set; }

        public BillInformation() {
            this.transactionType = TransactionType.Bill;
        }
        public BillInformation(TransactionManager t)
        {
            this.transactionManager = t;
            this.transactionType = TransactionType.Bill;
        }
        private void convertData(String json)
        {
            // read from file, convert it to user class
            var node = JObject.Parse(json);
            this.Version = (string)node["version"];
            this.CreatedAt = (string)node["createdAt"];
            this.LastModified = (string)node["lastModified"];
            this.CreatedBy = (string)node["createdBy"];
            this.LastModifiedBy = (string)node["lastModifiedBy"];
            this.metaData = (string)node["metaData"];
        }

        private void convertDataToBill(String json){
            bill = JsonConvert.DeserializeObject<Bill>(json, new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
	    }

        public void getBillForSaleInformationByTransactionId(String id){
		    String url = this.url+id+"/bill";
		    HttpWebRequest request = this.transactionManager.setHeadersGet(url, this.transactionManager.oauthToken);
		    String json=this.transactionManager.doGet(request);
		    convertData(json);
		    convertDataToBill(json);
	    }
	    public void getBillForSaleInformationById(String id){
		    String url = this.transactionManager.Url+"bill-for-sale/"+id;
		    HttpWebRequest request = this.transactionManager.setHeadersGet(url, this.transactionManager.oauthToken);
		    String json=this.transactionManager.doGet(request);
		    convertData(json);
		    convertDataToBill(json);
	    }
	    public void getBillForRecurringBillInformationByTransactionId(String id){
		    String url = this.url+id+"/bill";
		    HttpWebRequest request = this.transactionManager.setHeadersGet(url, this.transactionManager.oauthToken);
		    String json=this.transactionManager.doGet(request);
		    convertData(json);
		    convertDataToBill(json);
	    }
	    public void getBillForRecurringBillInformationById(String id){
		    String url = this.transactionManager.Url+"bill-for-recurring-bill/"+id;
		    HttpWebRequest request = this.transactionManager.setHeadersGet(url, this.transactionManager.oauthToken);
		    String json=this.transactionManager.doGet(request);
		    convertData(json);
		    convertDataToBill(json);
	    }

    }
}
