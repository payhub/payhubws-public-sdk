
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
    public List<SaleResponseInformation> getAllSalesInformation()
    {
    	//List<SaleResponseInformation> response = new ArrayList<SaleResponseInformation>();
        String url = _url + Sale.SALE_ID_LINK ;
        HttpWebRequest request = setHeadersGet(url, this._oauthToken);
        String result = doGet(request);
        var node = JObject.Parse(result);
        List<SaleResponseInformation> response = JsonConvert.DeserializeObject<List<SaleResponseInformation>>(node["_embedded"]["sales"].ToString());           
        foreach (SaleResponseInformation saleResponseInformation in response) {
        	saleResponseInformation.transactionManager=this;
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
        public List<AuthorizationResponseInformation> getAllAuthOnlyInformation()
        {

            String url = _url + AuthOnly.AUTH_ID_LINK;
            HttpWebRequest request = setHeadersGet(url, this._oauthToken);
            String result = doGet(request);
            var node = JObject.Parse(result);
            List<AuthorizationResponseInformation> response = JsonConvert.DeserializeObject<List<AuthorizationResponseInformation>>(node["_embedded"]["authonlys"].ToString(), new JsonSerializerSettings { NullValueHandling = NullValueHandling.Ignore, DefaultValueHandling = DefaultValueHandling.Ignore });
            foreach (AuthorizationResponseInformation authorizationResponseInformation in response)
            {
                authorizationResponseInformation.TransactionManager = this;
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
        public List<CaptureResponseInfromation> getAllCaptureInformation()
        {

            String url = _url + Capture.CAPTURE_ID_LINK;
            HttpWebRequest request = setHeadersGet(url, this._oauthToken);
            String result = doGet(request);
            var node = JObject.Parse(result);
            List<CaptureResponseInfromation> response = JsonConvert.DeserializeObject<List<CaptureResponseInfromation>>(node["_embedded"]["authonlys"].ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
            foreach (CaptureResponseInfromation lastCaptureResponseInfromation in response)
            {
                lastCaptureResponseInfromation.transactionManager = this;
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
        public List<VoidResponseInformation> getAllVoidResponseInformation()
        {

            String url = _url + VoidTransaction.VOID_ID_LINK;
            HttpWebRequest request = setHeadersGet(url, this._oauthToken);
            String result = doGet(request);
            var node = JObject.Parse(result);
            List<VoidResponseInformation> response = JsonConvert.DeserializeObject<List<VoidResponseInformation>>(node["_embedded"]["voids"].ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
            foreach (VoidResponseInformation lastVoidResponseInformation in response)
            {
                lastVoidResponseInformation.transactionManager = this;
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
        public List<VerifyResponseInformation> getAllVerifyResponseInformation()
        {

            String url = _url + Verify.VERIFY_ID_LINK;
            HttpWebRequest request = setHeadersGet(url, this._oauthToken);
            String result = doGet(request);
            var node = JObject.Parse(result);

            List<VerifyResponseInformation> response = JsonConvert.DeserializeObject<List<VerifyResponseInformation>>(node["_embedded"]["verifications"].ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
            foreach (VerifyResponseInformation verifyResponseInformation in response)
            {
                verifyResponseInformation.transactionManager = this;
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
        public List<RefundInformation> getAllRefundInformation()
        {

            String url = _url + Refund.REFUND_ID_LINK;
            HttpWebRequest request = setHeadersGet(url, this._oauthToken);
            String result = doGet(request);
            var node = JObject.Parse(result);
            List<RefundInformation> response = JsonConvert.DeserializeObject<List<RefundInformation>>(node["_embedded"]["refunds"].ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
            foreach (RefundInformation refundInformation in response)
            {
                refundInformation.transactionManager = this;
            }
            return response;
        }
        ///<summary> 
        /// Perform a new query that retrieves you the list of Bills for Sales Information.
        /// <returns>
        /// a BillInformation list object.
        /// </returns> 
        ///</summary>
        public List<BillInformation> getAllBillForSaleInformation()
        {

            String url = _url + "bill-for-sale/";
            HttpWebRequest request = setHeadersGet(url, this._oauthToken);
            String result = doGet(request);
            var node = JObject.Parse(result);
            List<BillInformation> response = JsonConvert.DeserializeObject<List<BillInformation>>(node["_embedded"]["billforsale"].ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
            int index = 0;
            foreach (BillInformation billInformation in response)
            {                
                billInformation.TransactionManager = this;
                billInformation.bill = JsonConvert.DeserializeObject<Bill>(node["_embedded"]["billforsale"][index].ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
                index++;
            }
            return response;
        }
        ///<summary> 
        /// Perform a new query that retrieves you the list of Bills for Recurring Bill Information.
        /// <returns>
        /// a BillInformation list object.
        /// </returns> 
        ///</summary>
        public List<BillInformation> getAllBillForRecurringBillInformation()
        {

            String url = _url + "bill-for-recurring-bill/";
            HttpWebRequest request = setHeadersGet(url, this._oauthToken);
            String result = doGet(request);
            var node = JObject.Parse(result);
            List<BillInformation> response = JsonConvert.DeserializeObject<List<BillInformation>>(node["_embedded"]["billsforrecurringbill"].ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
            int index = 0;
            foreach (BillInformation billInformation in response)
            {
                billInformation.TransactionManager = this;
                billInformation.bill = JsonConvert.DeserializeObject<Bill>(node["_embedded"]["billsforrecurringbill"][index].ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
                index++;
            }
            return response;
        }
        ///<summary> 
        /// Perform a new query that retrieves you the list of Merchant Information.
        /// <returns>
        /// a MerchantInformation list object.
        /// </returns> 
        ///</summary>
        public List<MerchantInformation> getAllMerchantInformation()
        {

            String url = _url + "merchant/";
            HttpWebRequest request = setHeadersGet(url, this._oauthToken);
            String result = doGet(request);
            var node = JObject.Parse(result);
            List<MerchantInformation> response = JsonConvert.DeserializeObject<List<MerchantInformation>>(node["_embedded"]["merchants"].ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
            int index = 0;
            foreach (MerchantInformation merchantInformation in response)
            {
                merchantInformation.TransactionManager = this;
                merchantInformation.merchant = JsonConvert.DeserializeObject<Merchant>(node["_embedded"]["merchants"][index].ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
                index++;
            }
            return response;
        }
        ///<summary> 
        /// Perform a new query that retrieves you the list of Card Data.
        /// <returns>
        /// a CardDataInformation list object.
        /// </returns> 
        ///</summary>
        public List<CardDataInformation> getAllCardDataInformation()
        {

            String url = _url + "carddata/";
            HttpWebRequest request = setHeadersGet(url, this._oauthToken);
            String result = doGet(request);
            var node = JObject.Parse(result);
            List<CardDataInformation> response = JsonConvert.DeserializeObject<List<CardDataInformation>>(node["_embedded"]["carddata"].ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
            int index = 0;
            foreach (CardDataInformation cardDataInformation in response)
            {
                cardDataInformation.TransactionManager = this;
                cardDataInformation.cardData = JsonConvert.DeserializeObject<CardData>(node["_embedded"]["carddata"][index].ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
                index++;
            }
            return response;
        }
        ///<summary> 
        /// Perform a new query that retrieves you the list of Customers for sales.
        /// <returns>
        /// a CustomerInformation list object.
        /// </returns> 
        ///</summary>
        public List<CustomerInformation> getAllCustomerForSalesInformation()
        {

            String url = _url + "customer-for-sale/";
            HttpWebRequest request = setHeadersGet(url, this._oauthToken);
            String result = doGet(request);
            var node = JObject.Parse(result);
            List<CustomerInformation> response = JsonConvert.DeserializeObject<List<CustomerInformation>>(node["_embedded"]["customerforsale"].ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
            int index = 0;
            foreach (CustomerInformation customerInformation in response)
            {
                customerInformation.TransactionManager = this;
                customerInformation.customer = JsonConvert.DeserializeObject<Customer>(node["_embedded"]["customerforsale"][index].ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
                index++;
            }
            return response;
        }
        ///<summary> 
        /// Perform a new query that retrieves you the list of Customers for Recurring billings.
        /// <returns>
        /// a CustomerInformation list object.
        /// </returns> 
        ///</summary>
        public List<CustomerInformation> getAllCustomerForRecurringBillInformation()
        {

            String url = _url + "customer";
            HttpWebRequest request = setHeadersGet(url, this._oauthToken);
            String result = doGet(request);
            var node = JObject.Parse(result);
            List<CustomerInformation> response = JsonConvert.DeserializeObject<List<CustomerInformation>>(node["_embedded"]["customers"].ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
            int index = 0;
            foreach (CustomerInformation customerInformation in response)
            {
                customerInformation.TransactionManager = this;
                customerInformation.customer = JsonConvert.DeserializeObject<Customer>(node["_embedded"]["customers"][index].ToString(), new JsonSerializerSettings { DefaultValueHandling = DefaultValueHandling.Ignore });
                index++;
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

        public List<RecurringBillInformation> getAllRecurringBillInformation()
        {
           
            RecurringBillInformation response = new RecurringBillInformation();
            var url = _url + RecurringBill.RECURRENT_BILL_ID_LINK;
            var request = setHeadersGet(url, this._oauthToken);
            string result = doGet(request);
            if (result == null || result.Equals(""))
                return null;
            var node = JObject.Parse(result);
            List<RecurringBillInformation> rb = null;
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
            List<RecurringBillInformation> rb = null;
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
        public Boolean updateRecurringBillStatus(String id)
        {
            if (id == null || id == "")
            {
                return false;
            }
            String url = _url + "recurring-bill-status/" + id;
            HttpWebRequest request = setHeadersPatch(url, this._oauthToken);
            Boolean result = doPatch(request);
            return result;
        }
    }
}
