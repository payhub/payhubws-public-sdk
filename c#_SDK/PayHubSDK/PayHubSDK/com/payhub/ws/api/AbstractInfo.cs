using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using PayHubSDK.com.payhub.ws.api;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace PayHubSDK.com.payhub.ws.api
{
    [DataContract]
    [KnownType(typeof(MerchantInformation))]
    [KnownType(typeof(CardDataInformation))]
    public abstract class AbstractInfo
    {
    protected string _version;
        [DataMember(Name = "version")]
        public string Version
        {get{return this._version;}
        set{this._version=value;}
        }
    [DataMember]
	protected string createdAt;
        public string CreatedAt
        {get{return this.createdAt;}
        set{this.createdAt=value;}
        }
    [DataMember]
	protected string lastModified;
        public string LastModified
        {get{return this.lastModified;}
        set{this.lastModified=value;}
        }
    [DataMember]
	protected string createdBy;
        public string CreatedBy
        {get{return this.createdBy;}
        set{this.createdBy=value;}
        }
    [DataMember]
	protected string lastModifiedBy;
        public string LastModifiedBy
        {get{return this.lastModifiedBy;}
        set{this.lastModifiedBy=value;}
        }
    [DataMember]
	protected Object metaData
    {
    get{
        return this.metaData.ToString();
        }
     set{
        this.metaData=value.ToString();   
     }
    }
    protected TransactionManager transactionManager;
    public TransactionManager TransactionManager { set { this.transactionManager = value; } }
	protected TransactionType transactionType{get;set;}

    public AbstractInfo() { }
    public AbstractInfo(TransactionManager transactionManager)
    {
        this.transactionManager = transactionManager;
    }
        public void getDataByID(String id){
		String url = this.transactionManager.Url+getUrlForTransactionType(this.transactionType)+id;
		HttpWebRequest request = this.transactionManager.setHeadersGet(url, this.transactionManager.oauthToken);
		String json=this.transactionManager.doGet(request);
		convertData(json);
		convertAbstractData(json);
	}
	public void getDataByTransaction(TransactionType type,String transactionId){
		String url=null;
		if(TransactionType.CardData.Equals(this.transactionType)){
			url = this.transactionManager.Url+getUrlForTransactionType(type)+transactionId+"/card_data";
		}else{
			url = this.transactionManager.Url+getUrlForTransactionType(type)+transactionId+"/"+getUrlForTransactionType(this.transactionType);
		}
		HttpWebRequest request = (HttpWebRequest) this.transactionManager.setHeadersGet(url, this.transactionManager.oauthToken);
		String json=this.transactionManager.doGet(request);
		convertData(json);
		convertAbstractData(json);
	}
	public abstract void convertData(String json);
	
	public void convertAbstractData(String json) {  
    		// read from file, convert it to user class
            var node = JObject.Parse(json);
    			this.Version=(string)node["version"];
    			this.CreatedAt=(string)node["createdAt"];
    			this.LastModified=(string)node["lastModified"];
    			this.CreatedBy=(string)node["createdBy"];
    			this.LastModifiedBy=(string)node["lastModifiedBy"];
    			this.metaData=(string)node["metaData"];
	}
	public abstract string getUrlForTransactionType(TransactionType type);
    }
}
