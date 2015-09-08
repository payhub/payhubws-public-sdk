package com.payhub.ws.api;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.omg.CORBA.Any;
import org.omg.CORBA.Object;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.payhub.ws.model.AuthOnly;
import com.payhub.ws.model.Bill;
import com.payhub.ws.model.Capture;
import com.payhub.ws.model.CardData;
import com.payhub.ws.model.Customer;
import com.payhub.ws.model.Merchant;
import com.payhub.ws.model.RecurringBill;
import com.payhub.ws.model.Refund;
import com.payhub.ws.model.Sale;
import com.payhub.ws.model.TransactionSearchParameters;
import com.payhub.ws.model.Verify;
import com.payhub.ws.model.VoidTransaction;
import com.payhub.ws.util.WsConnections;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class TransactionManager extends WsConnections{
	private Merchant _merchant;
    private String _url;
    private String _oauthToken;
    
    /**
     * Create a new Transaction Manager for access to the API and perform queries.
     *
     * @param String url: the url that allows you to retrieve information from the API.
     * @param String token: the token that allows you to access the API.
     * @param Merchant merchant: your Merchant information.
     *  
     */
    public TransactionManager(String url,String token,Merchant m){
    	super(token);    	
        this._url = url;
        this._oauthToken = token;
        this._merchant = m;
    }
    public String getUrl(){
    	return this._url;
    }
    /**
     * Perform a new Sale.
     *
     * @param sale object.
     * @return a SaleResponseInformation object. 
     * @see {@link com.payhub.ws.api.SaleResponseInformation}; 
     */
    public SaleResponseInformation doSale(Sale sale) throws IOException 
    { 
        sale.setMerchant(this._merchant);
        sale.setUrl(this._url);
        
        HttpURLConnection request = setHeadersPost(sale.getUrl(), this.getToken());
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        String json = mapper.writeValueAsString(sale);
        SaleResponseInformation response = sale.doSale(json, request);
        response.setTransactionManager(this);
        return response;
    }
    /**
     * Perform a new query that retrieves you the Sale Information for a particular Sale.
     *
     * @param String saleId: the ID of a particular Sale transaction.
     * @return a SaleResponseInformation object. 
     * @see {@link com.payhub.ws.api.SaleResponseInformation}; 
     */
    public SaleResponseInformation getSaleInformation(String saleId) throws IOException
    {
    	if(saleId.equals("")|| saleId==null){
    		return null;
    	}
        SaleResponseInformation response = new SaleResponseInformation();
        String url = _url + Sale.SALE_ID_LINK + saleId;
        HttpURLConnection request = setHeadersGet(url, this._oauthToken);
        String result = doGet(request);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        response =  mapper.readValue(result, SaleResponseInformation.class);
        response.setRowData(result);
        response.setTransactionManager(this);
        return response;
    }
    /**
     * Perform a new query that retrieves you the list of Sales Information.
     *
     * @return a SaleResponseInformation list object. 
     * @see {@link com.payhub.ws.api.SaleResponseInformation}; 
     */
    public List<SaleResponseInformation> getAllSalesInformation() throws IOException
    {
    	//List<SaleResponseInformation> response = new ArrayList<SaleResponseInformation>();
        String url = _url + Sale.SALE_ID_LINK ;
        HttpURLConnection request = setHeadersGet(url, this._oauthToken);
        String result = doGet(request);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ObjectNode node = mapper.readValue(result,ObjectNode.class);
        List<SaleResponseInformation> response =  mapper.readValue(node.get("_embedded").get("sales").toString(), new TypeReference<List<SaleResponseInformation>>(){});
        for (SaleResponseInformation saleResponseInformation : response) {
        	saleResponseInformation.setTransactionManager(this);
		}
        return  response;
    }
    /**
     * Perform a new Authorization.
     *
     * @param authorization object.
     * @return an AuthorizationResponseInformation object. 
     * @see {@link com.payhub.ws.api.AuthorizationResponseInformation}; 
     */
    public AuthorizationResponseInformation doAuthonly(AuthOnly authorization) throws IOException
    {
    	authorization.setMerchant(this._merchant);
        HttpURLConnection request = setHeadersPost(authorization.getUrl(), this.getToken());
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        String json = mapper.writeValueAsString(authorization);
        AuthorizationResponseInformation response = authorization.authOnly(json, request);
        response.setTransactionManager(this);
        return response;
    }
    /**
     * Perform a new query that retrieves you the Authorization Information for a particular Authorization.
     *
     * @param String authorizationId: the ID of a particular AuthorizationOnly transaction.
     * @return an AuthorizationResponseInformation object. 
     * @see {@link com.payhub.ws.api.AuthorizationResponseInformation}; 
     */
    public AuthorizationResponseInformation getAuthorizationInformation(String authorizationId) throws IOException
    {
    	if(authorizationId.equals("")|| authorizationId==null){
    		return null;
    	}
    	AuthorizationResponseInformation response = new AuthorizationResponseInformation();
        String url = _url + AuthOnly.AUTH_ID_LINK+ authorizationId;
        HttpURLConnection request = setHeadersGet(url, this._oauthToken);
        String result = doGet(request);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        response =  mapper.readValue(result, AuthorizationResponseInformation.class);
        response.setRowData(result);
        response.setTransactionManager(this);
        return response;        
    }
    /**
     * Perform a new query that retrieves you the list of Authorizations Information.
     *
     * @return an AuthorizationResponseInformation list object. 
     * @see {@link com.payhub.ws.api.AuthorizationResponseInformation}; 
     */
    public List<AuthorizationResponseInformation> getAllAuthOnlyInformation() throws IOException
    {
    	//List<SaleResponseInformation> response = new ArrayList<SaleResponseInformation>();
        String url = _url + AuthOnly.AUTH_ID_LINK;
        HttpURLConnection request = setHeadersGet(url, this._oauthToken);
        String result = doGet(request);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ObjectNode node = mapper.readValue(result,ObjectNode.class);
        List<AuthorizationResponseInformation> response =  mapper.readValue(node.get("_embedded").get("authonlys").toString(), new TypeReference<List<AuthorizationResponseInformation>>(){});
        for (AuthorizationResponseInformation authorizationResponseInformation : response) {
        	authorizationResponseInformation.setTransactionManager(this);
		}
        return  response;
    }
    /**
     * Perform a new CaptureResponse.
     *
     * @param capture object.
     * @return a LastCaptureResponseInformation object. 
     * @see {@link com.payhub.ws.api.CaptureResponseInformation}; 
     */
    public CaptureResponseInformation doCapture(Capture capture) throws IOException
    {
        capture.setMerchant(this._merchant);
        capture.setUrl(this._url);
        HttpURLConnection request = setHeadersPost(capture.getUrl(), this.getToken());
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        String json = mapper.writeValueAsString(capture);
        CaptureResponseInformation response = capture.captureData(json, request);
        response.setTransactionManager(this);
        return response;
    }
    /**
     * Perform a new query that retrieves you the Capture Information for a particular Capture.
     *
     * @param String captureId: the ID of a particular Capture.
     * @return a LastCaptureResponseInformation object. 
     * @see {@link com.payhub.ws.api.CaptureResponseInformation}; 
     */
    public CaptureResponseInformation getCaptureInformation(String captureId) throws IOException
    {
    	if(captureId.equals("")|| captureId==null){
    		return null;
    	}
    	CaptureResponseInformation response = new CaptureResponseInformation();
        String url = _url + Capture.CAPTURE_ID_LINK+ captureId;
        HttpURLConnection request = setHeadersGet(url, this._oauthToken);
        String result = doGet(request);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        response =  mapper.readValue(result, CaptureResponseInformation.class);
        response.setRowData(result);
        response.setTransactionManager(this);
        return response;   
        
    }
    /**
     * Perform a new query that retrieves you the list of Captures Information.
     *
     * @return an LastCaptureResponseInformation list object. 
     * @see {@link com.payhub.ws.api.CaptureResponseInformation}; 
     */
    public List<CaptureResponseInformation> getAllCaptureInformation() throws IOException
    {
    	//List<SaleResponseInformation> response = new ArrayList<SaleResponseInformation>();
        String url = _url + Capture.CAPTURE_ID_LINK;
        HttpURLConnection request = setHeadersGet(url, this._oauthToken);
        String result = doGet(request);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ObjectNode node = mapper.readValue(result,ObjectNode.class);
        List<CaptureResponseInformation> response =  mapper.readValue(node.get("_embedded").get("captures").toString(), new TypeReference<List<CaptureResponseInformation>>(){});
        for (CaptureResponseInformation lastCaptureResponseInformation : response) {
        	lastCaptureResponseInformation.setTransactionManager(this);
		}
        return  response;
    }
    /**
     * Perform a new Void Transaction.
     *
     * @param VoidTransaction object.
     * @return a LastVoidResponseInformation object.
     * @see {@link com.payhub.ws.api.VoidResponseInformation};  
     */
    public VoidResponseInformation doVoid(VoidTransaction voidData) throws IOException
    {
    	voidData.setMerchant(this._merchant);
    	voidData.setUrl(this._url);
        HttpURLConnection request = setHeadersPost(voidData.getUrl(), this.getToken());
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(voidData);
        VoidResponseInformation response = voidData.performVoidTransaction(json, request);
        response.setTransactionManager(this);
        return response;
    }
    /**
     * Perform a new query that retrieves you the Void Information for a particular Void Transaction.
     *
     * @param String voidId: the ID of a particular Void Transaction.
     * @return a LastVoidResponseInformation object. 
     * @see {@link com.payhub.ws.api.VoidResponseInformation}; 
     */
    public VoidResponseInformation getVoidInformation(String voidId) throws IOException
    {
    	if(voidId.equals("")|| voidId==null){
    		return null;
    	}
        VoidResponseInformation response = new VoidResponseInformation();
        String url = _url + VoidTransaction.VOID_ID_LINK+ voidId;
        HttpURLConnection request = setHeadersGet(url, this._oauthToken);
        String result = doGet(request);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        response =  mapper.readValue(result, VoidResponseInformation.class);
        response.setRowData(result);
        response.setTransactionManager(this);
        return response;    
    }
    /**
     * Perform a new query that retrieves you the list of Voids Information.
     *
     * @return an LastVoidResponseInformation list object. 
     * @see {@link com.payhub.ws.api.VoidResponseInformation}; 
     */
    public List<VoidResponseInformation> getAllVoidInformation() throws IOException
    {
    	//List<SaleResponseInformation> response = new ArrayList<SaleResponseInformation>();
        String url = _url + VoidTransaction.VOID_ID_LINK;
        HttpURLConnection request = setHeadersGet(url, this._oauthToken);
        String result = doGet(request);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ObjectNode node = mapper.readValue(result,ObjectNode.class);
        List<VoidResponseInformation> response =  mapper.readValue(node.get("_embedded").get("voids").toString(), new TypeReference<List<VoidResponseInformation>>(){});
        for (VoidResponseInformation lastVoidResponseInformation : response) {
        	lastVoidResponseInformation.setTransactionManager(this);
		}
        return  response;
    }
    /**
     * Perform a new Verify.
     *
     * @param Verify object.
     * @return a VerfyResponseInformation object.
     * @see {@link com.payhub.ws.api.VerfyResponseInformation}; 
     */
    public VerfyResponseInformation doVerify(Verify verifyData) throws IOException {
    	verifyData.setMerchant(this._merchant);
    	verifyData.setUrl(this._url);
        HttpURLConnection request = setHeadersPost(verifyData.getUrl(), this.getToken());
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(verifyData);
        VerfyResponseInformation response = verifyData.performVerifyTransaction(json, request);
        response.setTransactionManager(this);
        return response;
    }
    /**
     * Perform a new query that retrieves you the Verify Information for a particular Verify Transaction.
     *
     * @param String verifyId: the ID of a particular Verify Transaction.
     * @return a VerfyResponseInformation object. 
     * @see {@link com.payhub.ws.api.VerfyResponseInformation};
     */
    public VerfyResponseInformation getVerifyInformation(String verifyId) throws JsonProcessingException, IOException, Throwable
    {
    	if(verifyId.equals("")|| verifyId==null){
    		return null;
    	}
    	VerfyResponseInformation response = new VerfyResponseInformation();
        String url = _url + Verify.VERIFY_ID_LINK+ verifyId;
        HttpURLConnection request = setHeadersGet(url, this._oauthToken);
        String result = doGet(request);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        response =  mapper.readValue(result, VerfyResponseInformation.class);
        response.setRowData(result);
        response.setTransactionManager(this);
        return response;        
    }
    /**
     * Perform a new query that retrieves you the list of Verify Information.
     *
     * @return an VerfyResponseInformation list object. 
     * @see {@link com.payhub.ws.api.VerfyResponseInformation}; 
     */
    public List<VerfyResponseInformation> getAllVerifyInformation() throws IOException
    {
    	//List<SaleResponseInformation> response = new ArrayList<SaleResponseInformation>();
        String url = _url + Verify.VERIFY_ID_LINK;
        HttpURLConnection request = setHeadersGet(url, this._oauthToken);
        String result = doGet(request);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ObjectNode node = mapper.readValue(result,ObjectNode.class);
        List<VerfyResponseInformation> response =  mapper.readValue(node.get("_embedded").get("verifications").toString(), new TypeReference<List<VerfyResponseInformation>>(){});
        for (VerfyResponseInformation verfyResponseInformation : response) {
        	verfyResponseInformation.setTransactionManager(this);
		}
        return  response;
    }
    
    /**
     * Perform a new Refund.
     *
     * @param Refund object.
     * @return a RefundInformation object. 
     * @see {@link com.payhub.ws.api.RefundInformation};
     */
    public RefundInformation doRefund(Refund refundData) throws IOException
    {
	   refundData.setMerchant(this._merchant);
	   refundData.setUrl(this._url);
  		HttpURLConnection request = setHeadersPost(refundData.getUrl(), this.getToken());
  		ObjectMapper mapper = new ObjectMapper();
  		String json = mapper.writeValueAsString(refundData);
  		RefundInformation response = refundData.PerformRefund(json, request);
  		response.setTransactionManager(this);
  		return response;
    }
    /**
     * Perform a new query that retrieves you the Refund Information for a particular Refund Operation.
     *
     * @param String refundId: the ID of a particular Refund Transaction.
     * @return a RefundInformation object. 
     * @see {@link com.payhub.ws.api.RefundInformation};
     */
    public RefundInformation getRefundInformation(String refundId) throws JsonParseException, JsonMappingException, IOException
    {    	
    	if(refundId.equals("")|| refundId==null){
    		return null;
    	}
    	RefundInformation response = new RefundInformation();
        String url = _url + Refund.REFUND_ID_LINK+ refundId;
        HttpURLConnection request = setHeadersGet(url, this._oauthToken);
        String result = doGet(request);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        response =  mapper.readValue(result, RefundInformation.class);
        response.setRowData(result);
        response.setTransactionManager(this);
        return response;         
    }
    /**
     * Perform a new query that retrieves you the list of Refund Information.
     *
     * @return an RefundInformation list object. 
     * @see {@link com.payhub.ws.api.VerfyResponseInformation}; 
     */
    public List<RefundInformation> getAllRefundInformation() throws IOException
    {
    	//List<SaleResponseInformation> response = new ArrayList<SaleResponseInformation>();
        String url = _url + Refund.REFUND_ID_LINK;
        HttpURLConnection request = setHeadersGet(url, this._oauthToken);
        String result = doGet(request);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ObjectNode node = mapper.readValue(result,ObjectNode.class);
        List<RefundInformation> response =  mapper.readValue(node.get("_embedded").get("refunds").toString(), new TypeReference<List<RefundInformation>>(){});
        for (RefundInformation refundInformation : response) {
        	refundInformation.setTransactionManager(this);
		}
        return  response;
    }
    /**
     * Perform a new query that retrieves you the list of bills for sales Information.
     *
     * @return an BillInformation list object. 
     * @see {@link com.payhub.ws.api.BillInformation}; 
     */
    public List<BillInformation> getAllBillForSalesInformation() throws IOException
    {
    	//List<SaleResponseInformation> response = new ArrayList<SaleResponseInformation>();
        String url = _url + "bill-for-sale/";
        HttpURLConnection request = setHeadersGet(url, this._oauthToken);
        String result = doGet(request);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ObjectNode node = mapper.readValue(result,ObjectNode.class);
        List<BillInformation> response =  mapper.readValue(node.get("_embedded").get("billforsale").toString(), new TypeReference<List<BillInformation>>(){});
        int i=0;
        for (BillInformation billInformation : response) {
        	billInformation.setTransactionManager(this);
        	billInformation.setBill(mapper.readValue(node.get("_embedded").get("billforsale").get(i).toString(), Bill.class));
        	i++;
		}
        return  response;
    }
    /**
     * Perform a new query that retrieves you the list of bills for recurring bills Information.
     *
     * @return an BillInformation list object. 
     * @see {@link com.payhub.ws.api.BillInformation}; 
     */
    public List<BillInformation> getAllBillForRecurringBillInformation() throws IOException
    {
    	//List<SaleResponseInformation> response = new ArrayList<SaleResponseInformation>();
        String url = _url + "bill-for-recurring-bill/";
        HttpURLConnection request = setHeadersGet(url, this._oauthToken);
        String result = doGet(request);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ObjectNode node = mapper.readValue(result,ObjectNode.class);
        List<BillInformation> response =  mapper.readValue(node.get("_embedded").get("billsforrecurringbill").toString(), new TypeReference<List<BillInformation>>(){});
        int i=0;
        for (BillInformation billInformation : response) {
        	billInformation.setTransactionManager(this);
        	billInformation.setBill(mapper.readValue(node.get("_embedded").get("billsforrecurringbill").get(i).toString(), Bill.class));
        	i++;
		}
        return  response;
    }
    /**
     * Perform a new query that retrieves you the list of Merchants.
     *
     * @return an MerchantInformation list object. 
     * @see {@link com.payhub.ws.api.MerchantInformation}; 
     */
    public List<MerchantInformation> getAllMerchantInformation() throws IOException
    {
    	//List<SaleResponseInformation> response = new ArrayList<SaleResponseInformation>();
        String url = _url + "merchant/";
        HttpURLConnection request = setHeadersGet(url, this._oauthToken);
        String result = doGet(request);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ObjectNode node = mapper.readValue(result,ObjectNode.class);
        List<MerchantInformation> response =  mapper.readValue(node.get("_embedded").get("merchants").toString(), new TypeReference<List<MerchantInformation>>(){});
        int i=0;
        for (MerchantInformation merchantInformation : response) {
        	merchantInformation.setTransactionManager(this);
        	merchantInformation.setMerchant(mapper.readValue(node.get("_embedded").get("merchants").get(i).toString(), Merchant.class));
        	i++;
		}
        return  response;
    }
    /**
     * Perform a new query that retrieves you the list of Card Data.
     *
     * @return an CardDataInformation list object. 
     * @see {@link com.payhub.ws.api.CardDataInformation}; 
     */
    public List<CardDataInformation> getAllCardDataInformation() throws IOException
    {
    	//List<SaleResponseInformation> response = new ArrayList<SaleResponseInformation>();
        String url = _url + "carddata/";
        HttpURLConnection request = setHeadersGet(url, this._oauthToken);
        String result = doGet(request);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ObjectNode node = mapper.readValue(result,ObjectNode.class);
        List<CardDataInformation> response =  mapper.readValue(node.get("_embedded").get("carddata").toString(), new TypeReference<List<CardDataInformation>>(){});
        int i=0;
        for (CardDataInformation cardDataInformation : response) {
        	cardDataInformation.setTransactionManager(this);
        	cardDataInformation.setCardData(mapper.readValue(node.get("_embedded").get("carddata").get(i).toString(), CardData.class));
        	i++;
		}
        return  response;
    }
    /**
     * Perform a new query that retrieves you the list of Customers for sales.
     *
     * @return an CustomerInformation list object. 
     * @see {@link com.payhub.ws.api.CustomerInformation}; 
     */
    public List<CustomerInformation> getAllCustomerForSalesInformation() throws IOException
    {
    	//List<SaleResponseInformation> response = new ArrayList<SaleResponseInformation>();
        String url = _url + "customer-for-sale/";
        HttpURLConnection request = setHeadersGet(url, this._oauthToken);
        String result = doGet(request);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ObjectNode node = mapper.readValue(result,ObjectNode.class);
        List<CustomerInformation> response =  mapper.readValue(node.get("_embedded").get("customerforsale").toString(), new TypeReference<List<CustomerInformation>>(){});
        int i=0;
        for (CustomerInformation customerInformation : response) {
        	customerInformation.setTransactionManager(this);
        	customerInformation.setCustomer(mapper.readValue(node.get("_embedded").get("customerforsale").get(i).toString(), Customer.class));
        	i++;
		}
        return  response;
    }
    /**
     * Perform a new query that retrieves you the list of Customers for Recurring billings.
     *
     * @return an CustomerInformation list object. 
     * @see {@link com.payhub.ws.api.CustomerInformation}; 
     */
    public List<CustomerInformation> getAllCustomerForRecurringBillInformation() throws IOException
    {
    	//List<SaleResponseInformation> response = new ArrayList<SaleResponseInformation>();
        String url = _url + "customer/";
        HttpURLConnection request = setHeadersGet(url, this._oauthToken);
        String result = doGet(request);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ObjectNode node = mapper.readValue(result,ObjectNode.class);
        List<CustomerInformation> response =  mapper.readValue(node.get("_embedded").get("customers").toString(), new TypeReference<List<CustomerInformation>>(){});
        int i=0;
        for (CustomerInformation customerInformation : response) {
        	customerInformation.setTransactionManager(this);
        	customerInformation.setCustomer(mapper.readValue(node.get("_embedded").get("customers").get(i).toString(), Customer.class));
        	i++;
		}
        return  response;
    }
    /**
     * Perform a new RecurringBilling.
     *
     * @param RecurringBill object.
     * @return a RecurringBillingInformation object. 
     * @see {@link com.payhub.ws.api.RecurringBillResponseInformation};
     */
    public RecurringBillResponseInformation doRecurringBill(RecurringBill recurringBill) throws IOException
    {
	   	recurringBill.setMerchant(this._merchant);
	   	recurringBill.setUrl(this._url);
   		HttpURLConnection request = setHeadersPost(recurringBill.getUrl(), this.getToken());
   		ObjectMapper mapper = new ObjectMapper();
   		String json = mapper.writeValueAsString(recurringBill);
   		RecurringBillResponseInformation response = recurringBill.PerformRecurringBill(json, request);
   		response.setTransactionManager(this);
   		return response;
    }
    /**
     * Perform a new query that retrieves you the Recurring Bill Information for a particular Recurring Bill transaction.
     *
     * @param String recurringBillId: the ID of a particular Recurring Bill Transaction.
     * @return a RecurringBillingInformation object. 
     * @see {@link com.payhub.ws.api.RecurringBillResponseInformation};
     */
    public RecurringBillResponseInformation getRecurringBillInformation(String recurringBillId) throws IOException
    {
    	if(recurringBillId.equals("")|| recurringBillId==null){
    		return null;
    	}
    	RecurringBillResponseInformation response = new RecurringBillResponseInformation();
        String url = _url + RecurringBill.RECURRENT_BILL_ID_LINK+ recurringBillId;
        HttpURLConnection request = setHeadersGet(url, this._oauthToken);
        String result = doGet(request);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        response =  mapper.readValue(result, RecurringBillResponseInformation.class);
        response.setRowData(result);
        response.setTransactionManager(this);
        return response;  
        
    }
    /**
     * Perform a new query that retrieves you the Recurring Bill Information from a Merchant Id.
     *
     * @param String customerId: the ID of a particular Merchant Organization.
     * @return a RecurringBillingInformation object. 
     * @see {@link com.payhub.ws.api.RecurringBillResponseInformation};
     */
    public List<RecurringBillResponseInformation> findRecurringBillInformationByMerchantOrganization(String merchantId) throws IOException
    {
    	if(merchantId.equals("")|| merchantId==null){
    		return null;
    	}
    	//RecurringBillResponseInformation response = new RecurringBillResponseInformation();
        String url = _url + "recurring-bill/search/findByMerchantOrganizationId?organizationId="+ merchantId;
        HttpURLConnection request = setHeadersGet(url, this._oauthToken);
        String result = doGet(request);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ObjectNode node = mapper.readValue(result,ObjectNode.class);
        List<RecurringBillResponseInformation> response = new ArrayList<RecurringBillResponseInformation>();
        try{
	        response =  mapper.readValue(node.get("_embedded").get("recurringbills").toString(), new TypeReference<List<RecurringBillResponseInformation>>(){});
	        int i=0;
	        for (RecurringBillResponseInformation recurringBillResponseInformation : response) {
	        	recurringBillResponseInformation.setTransactionManager(this);        
	        	i++;
			}
        }catch(Exception e){
        	System.out.println(e.getMessage());
        	return null;	
        }
        return  response;
        
    }
    
    /**
     * Perform a new query that retrieves you the Recurring Bill Information from a Customer Id.
     *
     * @param String customerId: the ID of a particular Customer.
     * @return a RecurringBillingInformation object. 
     * @see {@link com.payhub.ws.api.RecurringBillResponseInformation};
     */
    public List<RecurringBillResponseInformation> findRecurringBillInformationByCustomer(String customerId) throws IOException
    {
    	if(customerId.equals("")|| customerId==null){
    		return null;
    	}    
        String url = _url + "recurring-bill/search/findByCustomerRef?customerId="+ customerId;
        HttpURLConnection request = setHeadersGet(url, this._oauthToken);
        String result = doGet(request);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ObjectNode node = mapper.readValue(result,ObjectNode.class);
        List<RecurringBillResponseInformation> response = new ArrayList<RecurringBillResponseInformation>();
        try{
	        response =  mapper.readValue(node.get("_embedded").get("recurringbills").toString(), new TypeReference<List<RecurringBillResponseInformation>>(){});
	        int i=0;
	        for (RecurringBillResponseInformation recurringBillResponseInformation : response) {
	        	recurringBillResponseInformation.setTransactionManager(this);        
	        	i++;
			}
        }catch(Exception e){
        	System.out.println(e.getMessage());
        	return null;	
        }
        return  response; 
        
    }
    public List<TransactionReportInformation> findTransactions(TransactionSearchParameters parameters)throws IOException{
    	String url = _url + "report/transactionReport";
        HttpURLConnection request = setHeadersPost(url, this._oauthToken);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        String json = mapper.writeValueAsString(parameters);        
        String result = findTransactionReports(request, json);        
        ObjectNode node = mapper.readValue(result,ObjectNode.class);
        List<TransactionReportInformation> response = new ArrayList<TransactionReportInformation>();
        if(node.get("errors").toString()!=null){
        	List<Errors> errors =  mapper.readValue(node.get("errors").toString(),new TypeReference<List<Errors>>(){});
        	TransactionReportInformation t = new TransactionReportInformation();
        	t.setErrors(errors);
        	response.add(t);
        }else{
        	 response =  mapper.readValue(node.toString(),new TypeReference<List<TransactionReportInformation>>(){});	
        }
        
        return  response;
    }
    public void addMetaData(String metadata,TransactionType type,String operationId) throws IOException{
        String metadataUrl=null;
        if(TransactionType.Sale.equals(type)){
        	metadataUrl=this._url+"metadata/forSale/"+operationId;
        }if(TransactionType.AuthOnly.equals(type)){
        	metadataUrl=this._url+"metadata/forAuthOnly/"+operationId;
        }if(TransactionType.Capture.equals(type)){
        	metadataUrl=this._url+"metadata/forCapture/"+operationId;
        }if(TransactionType.Bill.equals(type)){
        	metadataUrl=this._url+"metadata/forBill/"+operationId;
        }if(TransactionType.CardData.equals(type)){
        	metadataUrl=this._url+"metadata/forCardData/"+operationId;
        }if(TransactionType.Customer.equals(type)){
        	metadataUrl=this._url+"metadata/forCustomer/"+operationId;
        }if(TransactionType.Merchant.equals(type)){
        	metadataUrl=this._url+"metadata/forMerchant/"+operationId;
        }if(TransactionType.RecurringBill.equals(type)){
        	metadataUrl=this._url+"metadata/forRecurringBill/"+operationId;
        }if(TransactionType.Schedule.equals(type)){
        	metadataUrl=this._url+"metadata/forSchedule/"+operationId;
        }if(TransactionType.Refund.equals(type)){
        	metadataUrl=this._url+"metadata/forRefund/"+operationId;
        }if(TransactionType.VoidTransaction.equals(type)){
        	metadataUrl=this._url+"metadata/forVoid/"+operationId;
        }
        HttpURLConnection request = setHeadersPut(metadataUrl, this.getToken());
        String result = doPut(request,metadata);
        if(!result.equals("")){
        	System.out.println(result);
        	
        }else{
        	System.out.println("Metadata added successfully");	
        }
        
    }    
	
}
