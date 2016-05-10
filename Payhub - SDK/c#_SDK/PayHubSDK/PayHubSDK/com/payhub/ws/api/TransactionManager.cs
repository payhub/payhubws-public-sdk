
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using PayHubSDK.com.payhub.ws.model;
using Newtonsoft.Json;
using System.IO;
using System.Net;
using PayHubSDK.com.payhub.ws.api;
using PayHubSDK.com.payhub.ws.model;
using PayHubSDK.com.payhub.ws.util;
using Newtonsoft.Json.Linq;
using System.Runtime.InteropServices;
using PayHubSDK.com.payhub.ws.vt;
namespace PayHubSDK.com.payhub.ws.api
{
    ///  @author Agustin Breit 
    /// <summary> 
    /// Create a new Transaction Manager for access to the API and perform queries.
    ///
    /// <param name="url"> 
    /// String url: the url that allows you to retrieve information from the API.
    /// </param>
    /// <param name="token"> 
    /// String token: the token that allows you to access the API.
    /// </param>
    /// <param name="merchant"> 
    /// Merchant merchant: your Merchant information.
    /// </param>  
    /// </summary> 
    public class TransactionManager : WsConnections
    {
        private Merchant _merchant;
        public Merchant Merchant { 
                get{return this._merchant;} 
                set{
                    if(value!=null){
                        this._merchant=value;
                        }  
                    } 
        }
        private string _url;
        public string Url{ 
                get{return this._url;} 
                set{
                    if(value!=null){
                        this._url=value;
                        }  
                    } 
        }
        private string _oauthToken;
        public string oauthToken { 
                get{return this._oauthToken;} 
                set{
                    if(value!=null){
                        this._oauthToken=value;
                        }  
                    } 
        }

        public TransactionManager(string url,string token,Merchant m){
            this._url = url;
            this._oauthToken = token;
            this._merchant = m;
        }

        /// <summary> 
        /// Perform a new Sale.
        ///
        /// <param name="sale"> 
        /// Sale Object
        /// </param>
        /// <returns>
        /// SaleResponseInformation object.
        /// </returns>   
        /// <seealso cref="PayHubWS.com.payhub.ws.api.SaleResponseInformation"/>
        /// </summary> 
        public SaleResponseInformation doSale(Sale sale)
        {
            sale.Merchant = _merchant;
            sale._url = _url;
            var request = setHeadersPost(sale._url, this._oauthToken);
            string json = JsonConvert.SerializeObject(sale, Formatting.None, new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
            SaleResponseInformation response = sale.doSale(json, request);
            response.transactionManager=this;
            return response;
        }
        /// <summary> 
        /// Perform a new query that retrieves you the Sale Information for a particular Sale Transaction.
        ///
        /// <param name="saleId"> 
        /// the ID of a particular Sale Transaction.
        /// </param>
        /// <returns>
        /// SaleResponseInformation object.
        /// </returns>   
        /// <seealso cref="PayHubWS.com.payhub.ws.api.SaleResponseInformation"/>
        /// </summary> 
        public SaleResponseInformation getSaleInformation(string saleId)
        {
            if (saleId == null || saleId.Equals(""))
                return null;

            SaleResponseInformation response = new SaleResponseInformation();
            var url = _url + Sale.SALE_ID_LINK + saleId;
            var request = setHeadersGet(url, this._oauthToken);
            string result = doGet(request);
            response = JsonConvert.DeserializeObject<SaleResponseInformation>(result);
            if (result == null || result.Equals(""))
                return null;

            response.rowData = result;
            response.transactionManager = this;
            return response;
        }
     ///<summary> 
     /// Perform a new query that retrieves you the list of Sales Information.
     /// <returns>
     /// a SaleResponseInformation list object.
     /// </returns> 
    ///</summary>
        public List<SaleResponseInformation> getAllSalesInformation([Optional, DefaultParameterValue(0)]int page, [Optional, DefaultParameterValue(20)] int size)
    {
        
    	//List<SaleResponseInformation> response = new ArrayList<SaleResponseInformation>();
        String url = _url + Sale.SALE_ID_LINK + "?page="+page+"&size="+size + "&sort=id,desc";
        HttpWebRequest request = setHeadersGet(url, this._oauthToken);
        String result = doGet(request);
        var node = JObject.Parse(result);
        
        List<SaleResponseInformation> response = new List<SaleResponseInformation>();
        if (node["_embedded"] != null && node["_embedded"]["sales"] != null)
        {
            foreach (var authorizationResponseInformation in node["_embedded"]["sales"])
            {
                //billInformation.TransactionManager = this;
                var a = JsonConvert.DeserializeObject<SaleResponseInformation>(authorizationResponseInformation.ToString());
                if (authorizationResponseInformation["metaData"] != null)
                {
                    a.metaData = authorizationResponseInformation["metaData"].ToString();
                }
                a.transactionManager = this;
                response.Add(a);

            }
        }


        return  response;
    }
        /// <summary> 
        /// Perform a new AuthOnly.
        ///
        /// <param name="authorization"> 
        /// AuthOnly Object
        /// </param>
        /// <returns>
        /// AuthorizationResponseInformation object.
        /// </returns>   
        /// <seealso cref="PayHubWS.com.payhub.ws.api.AuthorizationResponseInformation"/>
        /// </summary> 
        public AuthorizationResponseInformation doAuthonly(AuthOnly authorization)
        {
            authorization.Merchant = _merchant;
            authorization._url = _url;
            var request = setHeadersPost(authorization._url, this._oauthToken);
            string json = JsonConvert.SerializeObject(authorization, Formatting.None, new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
            AuthorizationResponseInformation response = authorization.authonly(json, request);
            response.TransactionManager = this;
            return response;
        }
        /// <summary> 
        /// Perform a new query that retrieves you the AuthorizationOnly Information for a particular AuthorizationOnly Transaction.
        ///
        /// <param name="authorizationId"> 
        /// the ID of a particular AuthorizationOnly Transaction.
        /// </param>
        /// <returns>
        /// AuthorizationResponseInformation object.
        /// </returns>   
        /// <seealso cref="PayHubWS.com.payhub.ws.api.AuthorizationResponseInformation"/>
        /// </summary> 
        public AuthorizationResponseInformation getAuthorizationInformation(string authorizationId)
        {
            if (authorizationId == null || authorizationId.Equals(""))
                return null;
            AuthorizationResponseInformation response = new AuthorizationResponseInformation();
            var url = _url + AuthOnly.AUTH_ID_LINK + authorizationId;
            var request = setHeadersGet(url, this._oauthToken);
            string result = doGet(request);
            if (result == null || result.Equals(""))
                return null;
            response = JsonConvert.DeserializeObject<AuthorizationResponseInformation>(result);
            response.rowData = result;
            response.TransactionManager = this;
            return response;
        }
        ///<summary> 
        /// Perform a new query that retrieves you the list of AuthOnly Information.
        /// <returns>
        /// a AuthorizationResponseInformation list object.
        /// </returns> 
        ///</summary>
        public List<AuthorizationResponseInformation> getAllAuthOnlyInformation([Optional, DefaultParameterValue(0)]int page, [Optional, DefaultParameterValue(20)] int size)
        {

            String url = _url + AuthOnly.AUTH_ID_LINK + "?page="+page+"&size="+size + "&sort=id,desc";
            HttpWebRequest request = setHeadersGet(url, this._oauthToken);
            String result = doGet(request);
            var node = JObject.Parse(result);
            
            List<AuthorizationResponseInformation> response = new List<AuthorizationResponseInformation>();
            if (node["_embedded"] != null && node["_embedded"]["authonlys"] != null)
            {
                foreach (var authorizationResponseInformation in node["_embedded"]["authonlys"])
                {
                    //billInformation.TransactionManager = this;
                    var a = JsonConvert.DeserializeObject<AuthorizationResponseInformation>(authorizationResponseInformation.ToString());
                    if (authorizationResponseInformation["metaData"] != null)
                    {
                        a.metaData = authorizationResponseInformation["metaData"].ToString();
                    }
                    a.TransactionManager = this;
                    response.Add(a);

                }
            }
            return response;
        }
        /// <summary> 
        /// Perform a new Capture.
        ///
        /// <param name="capture"> 
        /// Capture Object
        /// </param>
        /// <returns>
        /// LastCaptureResponseInfromation object.
        /// </returns>   
        /// <seealso cref="PayHubWS.com.payhub.ws.api.LastCaptureResponseInfromation"/>
        /// </summary> 
        public CaptureResponseInfromation doCapture(Capture capture)
        {
            capture.Merchant = _merchant;
            capture._url = _url;
            var request = setHeadersPost(capture._url, this._oauthToken);
            string json = JsonConvert.SerializeObject(capture, Formatting.None, new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
            CaptureResponseInfromation response = capture.captureData(json, request);
            response.transactionManager = this;
            return response;
        }
        /// <summary> 
        /// Perform a new query that retrieves you the Capture Information for a particular Capture Transaction.
        ///
        /// <param name="captureId"> 
        /// the ID of a particular Capture Transaction.
        /// </param>
        /// <returns>
        /// LastCaptureResponseInfromation object.
        /// </returns>   
        /// <seealso cref="PayHubWS.com.payhub.ws.api.LastCaptureResponseInfromation"/>
        /// </summary> 
        public CaptureResponseInfromation getCaptureInformation(string captureId)
        {
            if (captureId == null || captureId .Equals(""))
                return null;
            CaptureResponseInfromation response = new CaptureResponseInfromation();
            var url = _url + Capture.CAPTURE_ID_LINK + captureId;
            var request = setHeadersGet(url, this._oauthToken);
            string result = doGet(request);
            if (result == null || result.Equals(""))
                return null;
            response = JsonConvert.DeserializeObject<CaptureResponseInfromation>(result);
            response.rowData = result;
            response.transactionManager = this;
            return response;
        }
        ///<summary> 
        /// Perform a new query that retrieves you the list of Captures Information.
        /// <returns>
        /// a LastCaptureResponseInfromation list object.
        /// </returns> 
        ///</summary>
        public List<CaptureResponseInfromation> getAllCaptureInformation([Optional, DefaultParameterValue(0)]int page, [Optional, DefaultParameterValue(20)] int size)
        {

            String url = _url + Capture.CAPTURE_ID_LINK + "?page="+page+"&size="+size + "&sort=id,desc";
            HttpWebRequest request = setHeadersGet(url, this._oauthToken);
            String result = doGet(request);
            var node = JObject.Parse(result);
            
            List<CaptureResponseInfromation> response = new List<CaptureResponseInfromation>();
            if (node["_embedded"] != null && node["_embedded"]["captures"] != null)
            {
                foreach (var lastCaptureResponseInfromation in node["_embedded"]["captures"])
                {
                    //billInformation.TransactionManager = this;
                    var a = JsonConvert.DeserializeObject<CaptureResponseInfromation>(lastCaptureResponseInfromation.ToString());
                    if (lastCaptureResponseInfromation["metaData"] != null)
                    {
                        a.metaData = lastCaptureResponseInfromation["metaData"].ToString();
                    }
                    a.transactionManager = this;
                    response.Add(a);

                }
            }
            return response;
        }
        /// <summary> 
        /// Perform a new VoidTransaction.
        ///
        /// <param name="voidData"> 
        /// VoidTransaction Object
        /// </param>
        /// <returns>
        /// LastVoidResponseInformation object.
        /// </returns>   
        /// <seealso cref="PayHubWS.com.payhub.ws.api.LastVoidResponseInformation"/>
        /// </summary> 
        public VoidResponseInformation doVoid(VoidTransaction voidData)
        {
            voidData.Merchant = _merchant;
            voidData._url = _url;
            var request = setHeadersPost(voidData._url, this._oauthToken);
            string json = JsonConvert.SerializeObject(voidData, Formatting.None, new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
            VoidResponseInformation response = voidData.performVoidTransaction(json, request);
            response.transactionManager = this;
            return response;
        }
        /// <summary> 
        /// Perform a new query that retrieves you the Void Information for a particular Void Transaction.
        ///
        /// <param name="voidId"> 
        /// the ID of a particular Void Transaction.
        /// </param>
        /// <returns>
        /// LastVoidResponseInformation object.
        /// </returns>   
        /// <seealso cref="PayHubWS.com.payhub.ws.api.LastVoidResponseInformation"/>
        /// </summary> 
        public VoidResponseInformation getVoidInformation(string voidId)
        {
            if (voidId == null || voidId.Equals(""))
                return null;
            VoidResponseInformation response = new VoidResponseInformation();
            var url = _url + VoidTransaction.VOID_ID_LINK + voidId;
            var request = setHeadersGet(url, this._oauthToken);
            string result = doGet(request);
            if (result == null || result.Equals(""))
                return null;
            response = JsonConvert.DeserializeObject<VoidResponseInformation>(result);
            response.rowData = result;
            response.transactionManager = this;
            return response;
        }
        ///<summary> 
        /// Perform a new query that retrieves you the list of Voids Information.
        /// <returns>
        /// a LastVoidResponseInformation list object.
        /// </returns> 
        ///</summary>
        public List<VoidResponseInformation> getAllVoidResponseInformation([Optional, DefaultParameterValue(0)]int page, [Optional, DefaultParameterValue(20)] int size)
        {

            String url = _url + VoidTransaction.VOID_ID_LINK + "?page="+page+"&size="+size + "&sort=id,desc";
            HttpWebRequest request = setHeadersGet(url, this._oauthToken);
            String result = doGet(request);
            var node = JObject.Parse(result);
            
            List<VoidResponseInformation> response = new List<VoidResponseInformation>();
            if (node["_embedded"] != null && node["_embedded"]["voids"] != null)
            {
                foreach (var lastVoidResponseInformation in node["_embedded"]["voids"])
                {
                    //billInformation.TransactionManager = this;
                    var a = JsonConvert.DeserializeObject<VoidResponseInformation>(lastVoidResponseInformation.ToString());
                    if (lastVoidResponseInformation["metaData"] != null)
                    {
                        a.metaData = lastVoidResponseInformation["metaData"].ToString();
                    }
                    a.transactionManager = this;
                    response.Add(a);

                }
            }
            return response;
        }
        /// <summary> 
        /// Perform a new Verify.
        /// <param name="verifyData"> 
        /// Verify Object
        /// </param>
        /// <returns>
        /// VerifyResponseInformation object.
        /// </returns>   
        /// <seealso cref="PayHubWS.com.payhub.ws.api.VerifyResponseInformation"/>
        /// </summary> 
        public VerifyResponseInformation doVerify(Verify verifyData) {
            verifyData.Merchant = _merchant;
            verifyData._url = _url;
            var request = setHeadersPost(verifyData._url, this._oauthToken);
            string json = JsonConvert.SerializeObject(verifyData, Formatting.None, new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
            VerifyResponseInformation response = verifyData.performVoidTransaction(json, request);
            response.transactionManager = this;
            return response;
        }
        /// <summary> 
        /// Perform a new query that retrieves you the Verify Information for a particular Verify Transaction.
        ///
        /// <param name="verifyId"> 
        /// the ID of a particular Verify Transaction.
        /// </param>
        /// <returns>
        /// VerifyResponseInformation object.
        /// </returns>   
        /// <seealso cref="PayHubWS.com.payhub.ws.api.VerifyResponseInformation"/>
        /// </summary> 
        public VerifyResponseInformation getVerifyInformation(string verifyId)
        {
            if (verifyId == null || verifyId .Equals(""))
                return null;
            VerifyResponseInformation response = new VerifyResponseInformation();
            var url = _url + Verify.VERIFY_ID_LINK + verifyId;
            var request = setHeadersGet(url, this._oauthToken);
            string result = doGet(request);
            if (result == null || result.Equals(""))
                return null;
            response = JsonConvert.DeserializeObject<VerifyResponseInformation>(result);
            response.rowData = result;
            response.transactionManager = this;
            return response;
        }
        ///<summary> 
        /// Perform a new query that retrieves you the list of Verify Information.
        /// <returns>
        /// a VerifyResponseInformation list object.
        /// </returns> 
        ///</summary>
        public List<VerifyResponseInformation> getAllVerifyResponseInformation([Optional, DefaultParameterValue(0)]int page, [Optional, DefaultParameterValue(20)] int size)
        {

            String url = _url + Verify.VERIFY_ID_LINK + "?page="+page+"&size="+size + "&sort=id,desc";
            HttpWebRequest request = setHeadersGet(url, this._oauthToken);
            String result = doGet(request);
            var node = JObject.Parse(result);

            List<VerifyResponseInformation> response = new List<VerifyResponseInformation>();
            if (node["_embedded"] != null && node["_embedded"]["verifications"] != null)
            {
                foreach (var verifyResponseInformation in node["_embedded"]["verifications"])
                {
                    //billInformation.TransactionManager = this;
                    var a = JsonConvert.DeserializeObject<VerifyResponseInformation>(verifyResponseInformation.ToString());
                    if (verifyResponseInformation["metaData"] != null)
                    {
                        a.metaData = verifyResponseInformation["metaData"].ToString();
                    }
                    a.transactionManager = this;
                    response.Add(a);

                }
            }

            return response;
        }

        /// <summary> 
        /// Perform a new Refund.
        ///
        /// <param name="refundData"> 
        /// Refund Object
        /// </param>
        /// <returns>
        /// RefundInformation object.
        /// </returns>   
        /// <seealso cref="PayHubWS.com.payhub.ws.api.RefundInformation"/>
        /// </summary> 
        public RefundInformation doRefund(Refund refundData)
        {
            refundData.Merchant = _merchant;
            refundData._url = _url;
            var request = setHeadersPost(refundData._url, this._oauthToken);
            string json = JsonConvert.SerializeObject(refundData, Formatting.None, new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
            RefundInformation response = refundData.PerformRefund(json, request);
            response.transactionManager = this;
            return response;
        }
        /// <summary> 
        /// Perform a new query that retrieves you the Refund Information for a particular Refund Operation.
        ///
        /// <param name="refundId"> 
        /// the ID of a particular Refund Transaction.
        /// </param>
        /// <returns>
        /// RefundInformation object.
        /// </returns>   
        /// <seealso cref="PayHubWS.com.payhub.ws.api.RecurringBillingInformation"/>
        /// </summary> 
        public RefundInformation getRefundInformation(string refundId)
        {
            if (refundId == null || refundId.Equals(""))
                return null;
            RefundInformation response = new RefundInformation();
            var url = _url + Refund.REFUND_ID_LINK + refundId;
            var request = setHeadersGet(url, this._oauthToken);
            string result = doGet(request);
            if (result == null || result.Equals(""))
                return null;
            response = JsonConvert.DeserializeObject<RefundInformation>(result);
            response.rowData = result;
            response.transactionManager = this;
            return response;
        }
        ///<summary> 
        /// Perform a new query that retrieves you the list of Refund Information.
        /// <returns>
        /// a RefundInformation list object.
        /// </returns> 
        ///</summary>
        public List<RefundInformation> getAllRefundInformation([Optional, DefaultParameterValue(0)]int page, [Optional, DefaultParameterValue(20)] int size)
        {

            String url = _url + Refund.REFUND_ID_LINK + "?page="+page+"&size="+size + "&sort=id,desc";
            HttpWebRequest request = setHeadersGet(url, this._oauthToken);
            String result = doGet(request);
            var node = JObject.Parse(result);
            
            List<RefundInformation> response = new List<RefundInformation>();
            if (node["_embedded"] != null && node["_embedded"]["refunds"] != null)
            {
                foreach (var refundInformation in node["_embedded"]["refunds"])
                {
                    //billInformation.TransactionManager = this;
                    var a = JsonConvert.DeserializeObject<RefundInformation>(refundInformation.ToString());
                    if (refundInformation["metaData"] != null)
                    {
                        a.metaData = refundInformation["metaData"].ToString();
                    }
                    
                    a.transactionManager = this;
                    response.Add(a);

                }
            }

            return response;
        }
        ///<summary> 
        /// Perform a new query that retrieves you the list of Bills for Sales Information.
        /// <returns>
        /// a BillInformation list object.
        /// </returns> 
        ///</summary>
        public List<BillInformation> getAllBillForSaleInformation([Optional, DefaultParameterValue(0)]int page, [Optional, DefaultParameterValue(20)] int size)
        {

            String url = _url + "bill-for-sale?page=" + page + "&size=" + size + "&sort=id,desc";
            HttpWebRequest request = setHeadersGet(url, this._oauthToken);
            String result = doGet(request);
            var node = JObject.Parse(result);           
            List<BillInformation> response = new List<BillInformation>();
            if (node["_embedded"] != null && node["_embedded"]["billforsale"] != null)
            {
                foreach (var billInformation in node["_embedded"]["billforsale"])
                {
                    //billInformation.TransactionManager = this;
                    var a = JsonConvert.DeserializeObject<BillInformation>(billInformation.ToString());
                    if (billInformation["metaData"] != null)
                    {
                        a.metadata = billInformation["metaData"].ToString();
                    }
                    a.bill = JsonConvert.DeserializeObject<Bill>(billInformation.ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
                    a.TransactionManager = this;
                    response.Add(a);

                }
            }


            return response;
        }
        ///<summary> 
        /// Perform a new query that retrieves you the list of Bills for Recurring Bill Information.
        /// <returns>
        /// a BillInformation list object.
        /// </returns> 
        ///</summary>
        public List<BillInformation> getAllBillForRecurringBillInformation([Optional, DefaultParameterValue(0)]int page, [Optional, DefaultParameterValue(20)] int size)
        {

            String url = _url + "bill-for-recurring-bill?page="+page+"&size="+size + "&sort=id,desc";
            HttpWebRequest request = setHeadersGet(url, this._oauthToken);
            String result = doGet(request);
            var node = JObject.Parse(result);
            List<BillInformation> response = new List<BillInformation>();
            if (node["_embedded"] != null && node["_embedded"]["billsforrecurringbill"] != null)
            {
                foreach (var billInformation in node["_embedded"]["billsforrecurringbill"])
                {
                    //billInformation.TransactionManager = this;
                    var a = JsonConvert.DeserializeObject<BillInformation>(billInformation.ToString());
                    if (billInformation["metaData"] != null)
                    {
                        a.metadata = billInformation["metaData"].ToString();
                    }
                    a.bill = JsonConvert.DeserializeObject<Bill>(billInformation.ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
                    a.TransactionManager = this;
                    response.Add(a);

                }
            }
            return response;
        }
        ///<summary> 
        /// Perform a new query that retrieves you the list of Merchant Information.
        /// <returns>
        /// a MerchantInformation list object.
        /// </returns> 
        ///</summary>
        public List<MerchantInformation> getAllMerchantInformation([Optional, DefaultParameterValue(0)]int page, [Optional, DefaultParameterValue(20)] int size)
        {

            String url = _url + "merchant?page="+page+"&size="+size + "&sort=id,desc";
            HttpWebRequest request = setHeadersGet(url, this._oauthToken);
            String result = doGet(request);
            var node = JObject.Parse(result);            
            List<MerchantInformation> response = new List<MerchantInformation>();

            if (node["_embedded"] != null && node["_embedded"]["merchants"] != null)
            {
                foreach (var merchantInformation in node["_embedded"]["merchants"])
                {
                    var m = JsonConvert.DeserializeObject<MerchantInformation>(merchantInformation.ToString());
                    m.TransactionManager = this;
                    if (merchantInformation["metaData"] != null)
                    {
                        m.metaData = merchantInformation["metaData"].ToString();
                    }
                    m.merchant = JsonConvert.DeserializeObject<Merchant>(merchantInformation.ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
                    response.Add(m);
                }
            }

            return response;
        }
        ///<summary> 
        /// Perform a new query that retrieves you the list of Card Data.
        /// <returns>
        /// a CardDataInformation list object.
        /// </returns> 
        ///</summary>
        public List<CardDataInformation> getAllCardDataInformation([Optional, DefaultParameterValue(0)]int page, [Optional, DefaultParameterValue(20)] int size)
        {

            String url = _url + "carddata?page="+page+"&size="+size + "&sort=id,desc";
            HttpWebRequest request = setHeadersGet(url, this._oauthToken);
            String result = doGet(request);
            var node = JObject.Parse(result);
            List<CardDataInformation> response = new List<CardDataInformation>();

            if (node["_embedded"] != null && node["_embedded"]["carddata"] != null)
            {
                foreach (var cardDataInformation in node["_embedded"]["carddata"])
                {
                    var card = JsonConvert.DeserializeObject<CardDataInformation>(cardDataInformation.ToString());
                    card.TransactionManager = this;
                    if (cardDataInformation["metaData"] != null)
                    {
                        card.metaData = cardDataInformation["metaData"].ToString();
                    }
                    card.cardData = JsonConvert.DeserializeObject<CardData>(cardDataInformation.ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
                    response.Add(card);
                }
            }

            return response;
        }
        ///<summary> 
        /// Perform a new query that retrieves you the list of Customers for sales.
        /// <returns>
        /// a CustomerInformation list object.
        /// </returns> 
        ///</summary>
        public List<CustomerInformation> getAllCustomerForSalesInformation([Optional, DefaultParameterValue(0)]int page, [Optional, DefaultParameterValue(20)] int size)
        {

            String url = _url + "customer-for-sale?page="+page+"&size="+size + "&sort=id,desc";
            HttpWebRequest request = setHeadersGet(url, this._oauthToken);
            String result = doGet(request);
            var node = JObject.Parse(result);
            List<CustomerInformation> response = new List<CustomerInformation>();

            if (node["_embedded"] != null && node["_embedded"]["customerforsale"] != null)
            {
                foreach (var customerInformation in node["_embedded"]["customerforsale"])
                {
                    var customer = JsonConvert.DeserializeObject<CustomerInformation>(customerInformation.ToString());
                    customer.TransactionManager = this;
                    if (customerInformation["metaData"] != null)
                    {
                        customer.metaData = customerInformation["metaData"].ToString();
                    }
                    customer.customer = JsonConvert.DeserializeObject<Customer>(customerInformation.ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
                    response.Add(customer);
                }
            }

            return response;
        }
        ///<summary> 
        /// Perform a new query that retrieves you the list of Customers for Recurring billings.
        /// <returns>
        /// a CustomerInformation list object.
        /// </returns> 
        ///</summary>
        public List<CustomerInformation> getAllCustomerForRecurringBillInformation([Optional, DefaultParameterValue(0)]int page, [Optional, DefaultParameterValue(20)] int size)
        {

            String url = _url + "customer?page="+page+"&size="+size + "&sort=id,desc";
            HttpWebRequest request = setHeadersGet(url, this._oauthToken);
            String result = doGet(request);
            var node = JObject.Parse(result);
            List<CustomerInformation> response = new List<CustomerInformation>();

            if (node["_embedded"] != null && node["_embedded"]["recurringbills"] != null)
            {               
                foreach (var customerInformation in node["_embedded"]["customers"])
                {
                    var customer = JsonConvert.DeserializeObject<CustomerInformation>(customerInformation.ToString());
                    customer.TransactionManager = this;
                    if (customerInformation["metaData"] != null)
                    {
                        customer.metaData = customerInformation["metaData"].ToString();
                    }
                    customer.customer = JsonConvert.DeserializeObject<Customer>(customerInformation.ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
                    response.Add(customer);
                }
            }

            return response;
        }
        /// <summary> 
        /// Perform a new RecurringBilling.
        ///
        /// <param name="recurringBill"> 
        /// RecurringBill object.
        /// </param>
        /// <returns>
        /// RecurringBillingInformation object.
        /// </returns>   
        /// <seealso cref="PayHubWS.com.payhub.ws.api.RecurringBillingInformation"/>
        /// </summary> 
        public RecurringBillInformation doRecurringBill(RecurringBill recurringBill)
        {
            recurringBill.Merchant = _merchant;
            recurringBill._url = _url;
            var request = setHeadersPost(recurringBill._url, this._oauthToken);
            string json = JsonConvert.SerializeObject(recurringBill, Formatting.None, new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
            RecurringBillInformation response = recurringBill.PerformRecurringBill(json, request);
            response.transactionManager = this;
            return response;
        }
        /// <summary> 
        /// Perform a new query that retrieves you the Recurring Bill Information for a particular Recurring Bill transaction.
        ///
        /// <param name="recurringBillId"> 
        /// String recurringBillId: the ID of a particular Recurring Bill Transaction.
        /// </param>
        /// <returns>
        /// a RecurringBillingInformation object.
        /// </returns>   
        /// <seealso cref="PayHubWS.com.payhub.ws.api.RecurringBillingInformation"/>
        /// </summary> 
        public RecurringBillInformation getRecurringBillInformation(string refundId)
        {
            if (refundId == null || refundId.Equals(""))
                return null;
            RecurringBillInformation response = new RecurringBillInformation();
            var url = _url + RecurringBill.RECURRENT_BILL_ID_LINK + refundId;
            var request = setHeadersGet(url, this._oauthToken);
            string result = doGet(request);
            if (result == null || result.Equals(""))
                return null;
            response = JsonConvert.DeserializeObject<RecurringBillInformation>(result);
            response.rowData = result;
            response.transactionManager = this;
            return response;
        }

        public List<RecurringBillInformation> getAllRecurringBillInformation([Optional, DefaultParameterValue(0)]int page, [Optional, DefaultParameterValue(20)] int size)
        {
           
            RecurringBillInformation response = new RecurringBillInformation();
            var url = _url + RecurringBill.RECURRENT_BILL_ID_LINK+"?page="+page+"&size="+size + "&sort=id,desc";
            var request = setHeadersGet(url, this._oauthToken);
            string result = doGet(request);
            if (result == null || result.Equals(""))
                return null;
            var node = JObject.Parse(result);
            List<RecurringBillInformation> rb = new List<RecurringBillInformation>();
            if (node["_embedded"] != null && node["_embedded"]["recurringbills"] != null)
            {
                rb = JsonConvert.DeserializeObject<List<RecurringBillInformation>>(node["_embedded"]["recurringbills"].ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
                foreach (RecurringBillInformation recurringBillInformation in rb)
                {
                    recurringBillInformation.transactionManager = this;
                }
                return rb;
            }
            if (node["errors"] != null)
            {
                List<Errors> errors = JsonConvert.DeserializeObject<List<Errors>>(node["errors"].ToString());
                RecurringBillInformation rbForErrors = new RecurringBillInformation();
                rbForErrors.errors = errors;
                rb.Add(rbForErrors);
                return rb;
            }

            else
            {
                return null;
            }
        }
        
        /// <summary> 
        ///  Perform a new query that retrieves you the Recurring Bill Information from a Customer Id.
        ///
        /// <param name="recurringBillId"> 
        /// String recurringBillId: the ID of a particular Recurring Bill Transaction.
        /// </param>
        /// <returns>
        /// a RecurringBillingInformation object.
        /// </returns>   
        /// <seealso cref="PayHubWS.com.payhub.ws.api.RecurringBillInformation"/>
        /// </summary> 
        public List<RecurringBillInformation> findRecurringBillInformationByCustomer(string customerId)
        {
            if (customerId.Equals("") || customerId == null)
            {
                return null;
            }
            RecurringBillInformation response = new RecurringBillInformation();
            var url = _url + "recurring-bill/search/findByCustomerRef?customerId=" + customerId;
            var request = setHeadersGet(url, this._oauthToken);
            string result = doGet(request);
            var node = JObject.Parse(result);
            List<RecurringBillInformation> rb = new List<RecurringBillInformation>();
            if (node["_embedded"] != null && node["_embedded"]["recurringbills"] != null)
            {
                rb = JsonConvert.DeserializeObject<List<RecurringBillInformation>>(node["_embedded"]["recurringbills"].ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
                foreach (RecurringBillInformation recurringBillInformation in rb)
                {
                    recurringBillInformation.transactionManager = this;
                }
                return rb;
            }
            if (node["errors"] != null)
            {
                List<Errors> errors = JsonConvert.DeserializeObject<List<Errors>>(node["errors"].ToString());
                RecurringBillInformation rbForErrors = new RecurringBillInformation();
                rbForErrors.errors = errors;
                rb.Add(rbForErrors);
                return rb;
            }

            else
            {
                return null;
            }
        }
        /// <summary> 
        /// Perform a new query that retrieves you the Transaction results from a set of parameters.
        ///
        /// <param name="parameters"> 
        /// String parameters: the set of parameters to search the transactions.
        /// </param>
        /// <returns>
        /// a TransactionReportInformation List object.
        /// </returns>   
        /// <seealso cref="PayHubWS.com.payhub.ws.api.TransactionReportInformation"/>
        /// </summary> 
        public List<TransactionReportInformation> findTransactions(TransactionSearchParameters parameters)
        {
            String url = _url + "report/transactionReport";
            HttpWebRequest request = setHeadersPost(url, this._oauthToken);
            string json = JsonConvert.SerializeObject(parameters, Formatting.None, new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
            string result = findTransactionReports(request, json);
            List<TransactionReportInformation> response = new List<TransactionReportInformation>();
            try
            {
                response = JsonConvert.DeserializeObject<List<TransactionReportInformation>>(result.ToString());
            }
            catch {
                try
                {
                    var node = JObject.Parse(result);
                    List<Errors> errors = JsonConvert.DeserializeObject<List<Errors>>(node["errors"].ToString());
                    TransactionReportInformation t = new TransactionReportInformation();
                    t.Errors = errors;
                    response.Add(t);
                }
                catch {
                    List<Errors> errors = new List<Errors>();
                    Errors error = new Errors();
                    error.Reason = "Unknown Error";
                    errors.Add(error);
                    TransactionReportInformation t = new TransactionReportInformation();
                    t.Errors = errors;
                    response.Add(t);
                }
            }
            

            return response;
        }

        

        /// <summary> 
        /// Add Metadata on one transaction.
        ///
        /// <param name="metadata"> 
        /// String metadata: the metadata to add.
        /// </param>
        /// <param name="type"> 
        ///  OperationType type: the specific type of operation.
        /// </param>
        /// <param name="operationId"> 
        /// String operationId: the Id of the operation.
        /// </param>
        /// </summary> 
        public void addMetaData(String metadata,TransactionType type,String operationId){
            string metadataUrl=null;
            if(TransactionType.Sale.Equals(type)){
        	    metadataUrl=this._url+"metadata/forSale/"+operationId;
            }if(TransactionType.AuthOnly.Equals(type)){
        	    metadataUrl=this._url+"metadata/forAuthOnly/"+operationId;
            }if(TransactionType.Capture.Equals(type)){
        	    metadataUrl=this._url+"metadata/forCapture/"+operationId;
            }if(TransactionType.Bill.Equals(type)){
        	    metadataUrl=this._url+"metadata/forBill/"+operationId;
            }if(TransactionType.CardData.Equals(type)){
        	    metadataUrl=this._url+"metadata/forCardData/"+operationId;
            }if(TransactionType.Customer.Equals(type)){
        	    metadataUrl=this._url+"metadata/forCustomer/"+operationId;
            }if(TransactionType.Merchant.Equals(type)){
        	    metadataUrl=this._url+"metadata/forMerchant/"+operationId;
            }if(TransactionType.RecurringBill.Equals(type)){
        	    metadataUrl=this._url+"metadata/forRecurringBill/"+operationId;
            }if(TransactionType.Schedule.Equals(type)){
        	    metadataUrl=this._url+"metadata/forSchedule/"+operationId;
            }if(TransactionType.Refund.Equals(type)){
        	    metadataUrl=this._url+"metadata/forRefund/"+operationId;
            }if(TransactionType.VoidTransaction.Equals(type)){
        	    metadataUrl=this._url+"metadata/forVoid/"+operationId;
            }
            HttpWebRequest request = setHeadersPut(metadataUrl, this._oauthToken);
            String result = doPut(request,metadata);//revisar el codigo del doPut porque con postman el json funciona y aca no
            if(!result.Equals("")){
        	    Console.WriteLine(result);
        	
            }else{
                Console.WriteLine("Metadata added successfully");	
            }
        
        }
        public Boolean updateRecurringBillStatus(String id,RecurringBillStatus status)
        {
            if (id == null || id == "")
            {
                return false;
            }
            String url = _url + "recurring-bill-status/" + id;
            HttpWebRequest request = setHeadersPatch(url, this._oauthToken);
            var json = "{ \n\t\"recurring_bill_status\": \"" + status + "\"\n}";
            String result = doPatch(request,json);
            if (result == null) { return true; }
            Console.Write(result);
            return false;
        }
        public RecurringBillInformation updateRecurringBill(String id, RecurringBill recurringBill)
        {
            if (id == null || id == "")
            {
                return null;
            }
            String url = _url + "recurring-bill/" + id;
            HttpWebRequest request = setHeadersPatch(url, this._oauthToken);
            string json = JsonConvert.SerializeObject(recurringBill, Formatting.None, new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
            String result = doPatch(request, json);
            if (result == null) { return null; }
            return JsonConvert.DeserializeObject<RecurringBillInformation>(result);
             
        }

        public EmailConfiguration getEmailConfiguration()
        {
            EmailConfiguration response = new EmailConfiguration();
            var url = _url + EmailConfiguration.EMAIL_LINK;
            var request = setHeadersGet(url, this._oauthToken);
            string result = doGet(request);
            if (result == null || result.Equals(""))
                return null;
            var node = JObject.Parse(result);
            if (node["errors"] != null)
            {
                response = JsonConvert.DeserializeObject<EmailConfiguration>(result);
            }
            else {
                response = JsonConvert.DeserializeObject<EmailConfiguration>(node["emailConfiguration"].ToString()); 
            }          
            return response;
        }

        public EmailConfiguration updateEmailConfiguration(EmailConfiguration emailConfig)
        {
            var url = _url + EmailConfiguration.EMAIL_LINK;
            
            var request = setHeadersPatch(url, this._oauthToken);
            string json = JsonConvert.SerializeObject(emailConfig, Formatting.None, new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore, NullValueHandling = NullValueHandling.Ignore });
            String result = doPatch(request, json);
            if (result == null || result.Equals("")) { return null; }
            EmailConfiguration email = new EmailConfiguration();
            var node = JObject.Parse(result);
            if (node["errors"] != null)
            {
                email = JsonConvert.DeserializeObject<EmailConfiguration>(result);
            }
            else
            {
                email = JsonConvert.DeserializeObject<EmailConfiguration>(node["emailConfiguration"].ToString());
            }
            return email;

        }

        public WebhookConfiguration getWebhookConfiguration()
        {
            WebhookConfiguration response = new WebhookConfiguration();
            var url = _url + WebhookConfiguration.WEBHOOK_LINK;
            var request = setHeadersGet(url, this._oauthToken);
            string result = doGet(request);
            if (result == null || result.Equals(""))
                return null;
            WebhookConfiguration email = new WebhookConfiguration();
            var node = JObject.Parse(result);
            if (node["errors"] != null)
            {
                email = JsonConvert.DeserializeObject<WebhookConfiguration>(result);
            }
            else
            {
                email = JsonConvert.DeserializeObject<WebhookConfiguration>(node["webhookConfiguration"].ToString());
            }
            return email;
        }

        public WebhookConfiguration updateWebhookConfiguration(WebhookConfiguration webhookConfiguration)
        {
            var url = _url + WebhookConfiguration.WEBHOOK_LINK;
            var request = setHeadersPatch(url, this._oauthToken);
            string json = JsonConvert.SerializeObject(webhookConfiguration, Formatting.None, new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore, NullValueHandling = NullValueHandling.Ignore });
            String result = doPatch(request, json);
            if (result == null || result.Equals("")) { return null; } 
            return JsonConvert.DeserializeObject<WebhookConfiguration>(result);
        }

        public ValidatedDevices getValidatedDevices()
        {
            ValidatedDevices response = new ValidatedDevices();
            var url = _url + ValidatedDevices.VALIDATED_DEVICES_LINK;
            var request = setHeadersGet(url, this._oauthToken);
            string result = doGet(request);
            if (result == null || result.Equals(""))
                return null;
            response = JsonConvert.DeserializeObject<ValidatedDevices>(result);
            return response;
        }

        public ValidatedDevices updateValidatedDevices(ValidatedDevices validatedDevices)
        {
            var url = _url + ValidatedDevices.VALIDATED_DEVICES_LINK;
            var request = setHeadersPatch(url, this._oauthToken);
            string json = JsonConvert.SerializeObject(validatedDevices, Formatting.None, new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore, NullValueHandling = NullValueHandling.Ignore });
            String result = doPatch(request, json);
            if (result == null) { return null; }
            return JsonConvert.DeserializeObject<ValidatedDevices>(result);
        }
        public GeneralSettings getGeneralSettings()
        {
            GeneralSettings response = new GeneralSettings();
            var url = _url + GeneralSettings.GENERAL_SETTINGS_LINK;
            var request = setHeadersGet(url, this._oauthToken);
            string result = doGet(request);
            if (result == null || result.Equals(""))
                return null;
            response = JsonConvert.DeserializeObject<GeneralSettings>(result);
            return response;
        }

        public RiskFraudSettings getRiskFraudSettings()
        {
            RiskFraudSettings response = new RiskFraudSettings();
            var url = _url + RiskFraudSettings.RISK_FRAUD_PATCH_SETTINGS_LINK;
            var request = setHeadersGet(url, this._oauthToken);
            string result = doGet(request);
            if (result == null || result.Equals(""))
                return null;
            response = JsonConvert.DeserializeObject<RiskFraudSettings>(result);
            return response;
        }

        public RiskFraudSettings updateRiskFraudSettings(RiskFraudSettings riskFraudSettings)
        {
            var url = _url + RiskFraudSettings.RISK_FRAUD_PATCH_SETTINGS_LINK;
            var request = setHeadersPatch(url, this._oauthToken);
            string json = JsonConvert.SerializeObject(riskFraudSettings, Formatting.None, new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore, NullValueHandling = NullValueHandling.Ignore });
            String result = doPatch(request, json);
            if (result == null) { return null; }
            return JsonConvert.DeserializeObject<RiskFraudSettings>(result);
        }

        public UserRoles getUserRoles()
        {
            UserRoles response = new UserRoles();
            var url = _url + UserRoles.ALL_USER_ROLE_LINK;
            var request = setHeadersGet(url, this._oauthToken);
            string result = doGet(request);
            if (result == null || result.Equals(""))
                return null;
            response = JsonConvert.DeserializeObject<UserRoles>(result);
            return response;
        }

        public RoleSettings getUserRolesById(string roleId)
        {
		    if(roleId==null || roleId.Equals("")){
    		    return null;
    	    }
            RoleSettings response = new RoleSettings();
            var url = _url + RoleSettings.USER_ROLE_LINK+roleId;
            var request = setHeadersGet(url, this._oauthToken);
            string result = doGet(request);
            if (result == null || result.Equals(""))
                return null;
            response = JsonConvert.DeserializeObject<RoleSettings>(result);
            return response;
        }
        public RoleSettings updateRoleSettings(string roleId, RoleSettings roleSettings)
        {
            if (roleId == null || roleId.Equals(""))
            {
                return null;
            }
            var url = _url + RoleSettings.PATCH_USER_ROLE_LINK+roleId;
            var request = setHeadersPatch(url, this._oauthToken);
            string json = JsonConvert.SerializeObject(roleSettings, Formatting.None, new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore, NullValueHandling = NullValueHandling.Ignore });
            String result = doPatch(request, json);
            if (result == null) { return null; }
            return JsonConvert.DeserializeObject<RoleSettings>(result);
        }

        public RoleSettings createRoleSettings(RoleSettings roleSettings)
        {
            if (roleSettings == null)
            {
                return null;
            }
            var url = _url + RoleSettings.CREATE_USER_ROLE_LINK;
            string json = JsonConvert.SerializeObject(roleSettings, Formatting.None, new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore, NullValueHandling = NullValueHandling.Ignore });
            String result = doPostForUserRoles(url,this._oauthToken, json);
            if (result == null) { return null; }
            return JsonConvert.DeserializeObject<RoleSettings>(result);
        }

    }
}
