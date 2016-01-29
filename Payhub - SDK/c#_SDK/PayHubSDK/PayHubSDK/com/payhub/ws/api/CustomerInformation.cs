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
    public class CustomerInformation
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
        private JToken _metaData = "";
        public JToken metaData { get { return this._metaData.ToString(); } set { if (value != null) { this._metaData = value.ToObject<string>(); } else { this._metaData = ""; } } }
        
        private TransactionManager transactionManager;
        public TransactionManager TransactionManager { set { this.transactionManager = value; } }
	    
        private TransactionType transactionType;
        public Customer customer{ get; set; }

        public string Version { get { return this._version; } set { this._version = value; } }
        public string CreatedAt { get { return this._createdAt; } set { this._createdAt = value; } }
        public string LastModified { get { return this._lastModified; } set { this._lastModified = value; } }
        public string CreatedBy { get { return this._createdBy; } set { this._createdBy = value; } }
        public string LastModifiedBy { get { return this._lastModifiedBy; } set { this._lastModifiedBy = value; } }
        
        public string Url { get; set; }

        public CustomerInformation() {
		    this.transactionType=TransactionType.Customer;
	    }
        public CustomerInformation(TransactionManager transactionManager) {
		    this.transactionManager=transactionManager;
		    this.transactionType=TransactionType.Customer;
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
            this.metaData = node["metaData"].ToObject<string>();
        }

         private void convertDataToCustomer(String json){
             customer = JsonConvert.DeserializeObject<Customer>(json, new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
	    }
    
        public void getCustomerForSaleInformationByTransactionId(String id){
		    String url = this.Url+id+"/customer";
		    HttpWebRequest request = this.transactionManager.setHeadersGet(url, this.transactionManager.oauthToken);
		    String json=this.transactionManager.doGet(request);
		    convertData(json);
		    convertDataToCustomer(json);
	    }
	    public void getCustomerForSaleInformationById(String id){
		        String url = this.transactionManager.Url+"customer-for-sale/"+id;
                HttpWebRequest request = this.transactionManager.setHeadersGet(url, this.transactionManager.oauthToken);
		        String json=this.transactionManager.doGet(request);
		        convertData(json);
		        convertDataToCustomer(json);
	        }
	    public void getCustomerForRecurringBillInformationByTransactionId(String id){
		    String url = this.Url+id+"/customer";
            HttpWebRequest request = this.transactionManager.setHeadersGet(url, this.transactionManager.oauthToken);
		    String json=this.transactionManager.doGet(request);
		    convertData(json);
		    convertDataToCustomer(json);
	    }
	    public void getCustomerForRecurringBillInformationById(String id){
		    String url = this.transactionManager.Url+"customer/"+id;
            HttpWebRequest request = this.transactionManager.setHeadersGet(url, this.transactionManager.oauthToken);
		    String json=this.transactionManager.doGet(request);
		    convertData(json);
		    convertDataToCustomer(json);
	    }
    }
}
