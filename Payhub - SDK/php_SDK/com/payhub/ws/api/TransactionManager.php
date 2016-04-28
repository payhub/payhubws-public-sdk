<?php
/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 23/07/2015
 * Time: 12:37
 */
class TransactionManager extends WsConnections
{
    private $_merchant;
    private $_url;
    private $_oauthToken;

    /**
     * TransactionManager constructor.
     * @param $_merchant
     * @param $_url
     * @param $_oauthToken
     */
    public function __construct($_merchant, $_url, $_oauthToken)
    {
        $this->_merchant = $_merchant;
        $this->_url = $_url;
        $this->_oauthToken = $_oauthToken;
    }
    /**
     * @return mixed
     */
    public function getUrl()
    {
        return $this->_url;
    }
    /**
     * Perform a new Sale.
     *
     * @param sale object.
     * @return a SaleResponseInformation object.
     * @see {@link com.payhub.ws.api.SaleResponseInformation};
     */
    public function doSale($sale)
    {
        $sale->setMerchant($this->_merchant);
        $sale->setUrl($this->_url);
        $sale->setToken($this->_oauthToken);
        $request = $this->setHeadersPost($sale->getUrl(),$this->_oauthToken);
        $result = $sale->doSale($request);
        $result->setTransactionManager($this);
    return $result;
    }
    /**
     * Perform a new query that retrieves you the Sale Information for a particular Sale.
     *
     * @param String saleId: the ID of a particular Sale transaction.
     * @return a SaleResponseInformation object.
     * @see {@link com.payhub.ws.api.SaleResponseInformation};
     */
    public function getSaleInformation($saleId)
    {
        if(is_null($saleId) || $saleId==""){
            return null;
        }

        $url = $this->getUrl().Sale::$SALE_ID_LINK.$saleId;

        $request = $this->setHeadersGet($url,$this->_oauthToken);
        $result = $this->doGet($request);
        $response = SaleResponseInformation::fromArray($result);
        $response->setTransactionManager($this);
        return $response;
    }

    /**
     * Perform a new query that retrieves you the list of Sales Information.
     *
     * @return a SaleResponseInformation list object.
     * @see {@link com.payhub.ws.api.SaleResponseInformation};
     */
    public function getAllSalesInformation()
    {
        $url = $this->getUrl().Sale::$SALE_ID_LINK;
        $request = $this->setHeadersGet($url,$this->_oauthToken);
        $result = $this->doGet($request);
        if(array_key_exists('_embedded',$result)) {
            foreach($result['_embedded']['sales'] as $sales){
                $response_tmp = SaleResponseInformation::fromArray($sales);
                $response_tmp->setTransactionManager($this);
                $response[] = $response_tmp;
            }
            return $response;
        }else{
            $errors_tmp = new Errors();
            foreach ($result as $errorData) {
                $errors_tmp = Errors::fromArray($errorData);
            }
            $errors[]=$errors_tmp;
            return $errors;
        }
    }
    /**
     * Perform a new Authorization.
     *
     * @param authorization object.
     * @return an AuthorizationResponseInformation object.
     * @see {@link com.payhub.ws.api.AuthorizationResponseInformation};
     */
    public function doAuthonly($authorization)
    {
        $authorization->setMerchant($this->_merchant);
        $authorization->setUrl($this->_url);
        $authorization->setToken($this->_oauthToken);
        $request = $this->setHeadersPost($authorization->getUrl(),$this->_oauthToken);
        $result = $authorization->doAuthOnly($request);
        $result->setTransactionManager($this);
        return $result;
    }
    /**
     * Perform a new query that retrieves you the Authorization Information for a particular Authorization.
     *
     * @param String authorizationId: the ID of a particular AuthorizationOnly transaction.
     * @return an AuthorizationResponseInformation object.
     * @see {@link com.payhub.ws.api.AuthorizationResponseInformation};
     */
    public function getAuthorizationInformation($authorizationId)
    {
        if(is_null($authorizationId) || $authorizationId==""){
                    return null;
        }

        $url = $this->getUrl().AuthOnly::$AUTH_ID_LINK.$authorizationId;

        $request = $this->setHeadersGet($url,$this->_oauthToken);
        $result = $this->doGet($request);
        $response = AuthorizationResponseInformation::fromArray($result);
        $response->setTransactionManager($this);
        return $response;
    }
    /**
     * Perform a new query that retrieves you the list of Authorizations Information.
     *
     * @return an AuthorizationResponseInformation list object.
     * @see {@link com.payhub.ws.api.AuthorizationResponseInformation};
     */
    public function getAllAuthOnlyInformation()
    {
        //List<SaleResponseInformation> response = new ArrayList<SaleResponseInformation>();
        $url = $this->getUrl().AuthOnly::$AUTH_ID_LINK;
        $request = $this->setHeadersGet($url,$this->_oauthToken);
        $result = $this->doGet($request);
        if(array_key_exists('_embedded',$result)) {
            foreach($result['_embedded']['authonlys'] as $authonlies){
                $response_tmp = AuthorizationResponseInformation::fromArray($authonlies);
                $response_tmp->setTransactionManager($this);
                $response[] = $response_tmp;
            }
            return $response;
        }else{
            $errors_tmp = new Errors();
            foreach ($result as $errorData) {
                $errors_tmp = Errors::fromArray($errorData);
            }
            $errors[]=$errors_tmp;
            return $errors;
        }
    }

    /**
     * Perform a new CaptureResponse.
     *
     * @param capture object.
     * @return a LastCaptureResponseInformation object.
     * @see {@link com.payhub.ws.api.CaptureResponseInformation};
     */
    public function doCapture($capture)
    {
        $capture->setMerchant($this->_merchant);
        $capture->setUrl($this->_url);
        $capture->setToken($this->_oauthToken);
        $request = $this->setHeadersPost($capture->getUrl(),$this->_oauthToken);
        $result = $capture->doCapture($request);
        $result->setTransactionManager($this);
        return $result;
    }
    /**
     * Perform a new query that retrieves you the Capture Information for a particular Capture.
     *
     * @param String captureId: the ID of a particular Capture.
     * @return a LastCaptureResponseInformation object.
     * @see {@link com.payhub.ws.api.CaptureResponseInformation};
     */
    public function getCaptureInformation($captureId)
    {
        if(is_null($captureId) || $captureId==""){
            return null;
        }
        $url = $this->getUrl().Capture::$CAPTURE_ID_LINK.$captureId;

        $request = $this->setHeadersGet($url,$this->_oauthToken);
        $result = $this->doGet($request);
        $response = CaptureResponseInformation::fromArray($result);
        $response->setTransactionManager($this);
        return $response;

    }
    /**
    * Perform a new query that retrieves you the list of Captures Information.
    *
    * @return an LastCaptureResponseInformation list object.
    * @see {@link com.payhub.ws.api.CaptureResponseInformation};
    */
    public function getAllCaptureInformation()
    {
        $url = $this->getUrl() . Capture::$CAPTURE_ID_LINK;
        $request = $this->setHeadersGet($url, $this->_oauthToken);
        $result = $this->doGet($request);
        if(array_key_exists('_embedded',$result)) {
            foreach ($result['_embedded']['captures'] as $captures) {
                $response_tmp = CaptureResponseInformation::fromArray($captures);
                $response_tmp->setTransactionManager($this);
                $response[] = $response_tmp;
            }
            return $response;
        }else{
            $errors_tmp = new Errors();
            foreach ($result as $errorData) {
                $errors_tmp = Errors::fromArray($errorData);
            }
            $errors[]=$errors_tmp;
            return $errors;
        }
    }
    /**
     * Perform a new Void Transaction.
     *
     * @param VoidTransaction object.
     * @return a LastVoidResponseInformation object.
     * @see {@link com.payhub.ws.api.VoidResponseInformation};
     */
    public function doVoid($void)
    {
        $void->setMerchant($this->_merchant);
        $void->setUrl($this->_url);
        $void->setToken($this->_oauthToken);
        $request = $this->setHeadersPost($void->getUrl(),$this->_oauthToken);
        $result = $void->performVoidTransaction($request);
        $result->setTransactionManager($this);
        return $result;
    }


    /**
     * Perform a new query that retrieves you the Void Information for a particular Void Transaction.
     *
     * @param String voidId: the ID of a particular Void Transaction.
     * @return a LastVoidResponseInformation object.
     * @see {@link com.payhub.ws.api.VoidResponseInformation};
     */
    public function getVoidInformation($voidId)
    {
        if(is_null($voidId) || $voidId==""){
            return null;
        }
        $url = $this->getUrl().VoidTransaction::$VOID_ID_LINK.$voidId;
        $request = $this->setHeadersGet($url,$this->_oauthToken);
        $result = $this->doGet($request);
        $response = VoidResponseInformation::fromArray($result);
        $response->setTransactionManager($this);
        return $response;

    }
    /**
     * Perform a new query that retrieves you the list of Voids Information.
     *
     * @return an LastVoidResponseInformation list object.
     * @see {@link com.payhub.ws.api.VoidResponseInformation};
     */
    public function getAllVoidInformation()
    {
        $url = $this->getUrl() . VoidTransaction::$VOID_ID_LINK;
        $request = $this->setHeadersGet($url, $this->_oauthToken);
        $result = $this->doGet($request);
        if(array_key_exists('_embedded',$result)) {
            foreach ($result['_embedded']['voids'] as $voids) {
                $response_tmp = VoidResponseInformation::fromArray($voids);
                $response_tmp->setTransactionManager($this);
                $response[] = $response_tmp;
            }
            return $response;
        }else{
            $errors_tmp = new Errors();
            foreach ($result as $errorData) {
                $errors_tmp = Errors::fromArray($errorData);
            }
            $errors[]=$errors_tmp;
            return $errors;
        }
    }
    /**
     * Perform a new Verify.
     *
     * @param Verify object.
     * @return a VerfyResponseInformation object.
     * @see {@link com.payhub.ws.api.VerfyResponseInformation};
     */
    public function doVerify($verify)
    {
        $verify->setMerchant($this->_merchant);
        $verify->setUrl($this->_url);
        $verify->setToken($this->_oauthToken);
        $request = $this->setHeadersPost($verify->getUrl(),$this->_oauthToken);
        $result = $verify->performVerifyTransaction($request);
        $result->setTransactionManager($this);
        return $result;
    }
    /**
     * Perform a new query that retrieves you the Verify Information for a particular Verify Transaction.
     *
     * @param String verifyId: the ID of a particular Verify Transaction.
     * @return a VerfyResponseInformation object.
     * @see {@link com.payhub.ws.api.VerfyResponseInformation};
     */
    public function getVerifyInformation($verifyId)
    {
        if(is_null($verifyId) || $verifyId==""){
            return null;
        }
        $url = $this->getUrl().Verify::$VERIFY_ID_LINK.$verifyId;
        $request = $this->setHeadersGet($url,$this->_oauthToken);
        $result = $this->doGet($request);
        $response = VerifyResponseInformation::fromArray($result);
        $response->setTransactionManager($this);
        return $response;

    }
    /**
     * Perform a new query that retrieves you the list of Verify Information.
     *
     * @return an VerfyResponseInformation list object.
     * @see {@link com.payhub.ws.api.VerfyResponseInformation};
     */
    public function getAllVerifyInformation()
    {
        $url = $this->getUrl() . Verify::$VERIFY_ID_LINK;
        $request = $this->setHeadersGet($url, $this->_oauthToken);
        $result = $this->doGet($request);
        if(array_key_exists('_embedded',$result)) {
            foreach ($result['_embedded']['verifications'] as $verifications) {
                $response_tmp = VerifyResponseInformation::fromArray($verifications);
                $response_tmp->setTransactionManager($this);
                $response[] = $response_tmp;
            }
            return $response;
        }else{
            $errors_tmp = new Errors();
            foreach ($result as $errorData) {
                $errors_tmp = Errors::fromArray($errorData);
            }
            $errors[]=$errors_tmp;
            return $errors;
        }
    }
    /**
     * Perform a new Refund.
     *
     * @param Refund object.
     * @return a RefundInformation object.
     * @see {@link com.payhub.ws.api.RefundInformation};
     */
    public function doRefund($refund)
    {
        $refund->setMerchant($this->_merchant);
        $refund->setUrl($this->_url);
        $refund->setToken($this->_oauthToken);
        $request = $this->setHeadersPost($refund->getUrl(),$this->_oauthToken);
        $result = $refund->performRefund($request);
        $result->setTransactionManager($this);
        return $result;
    }
    /**
     * Perform a new query that retrieves you the Refund Information for a particular Refund Operation.
     *
     * @param String refundId: the ID of a particular Refund Transaction.
     * @return a RefundInformation object.
     * @see {@link com.payhub.ws.api.RefundInformation};
     */
    public function getRefundInformation($refundId)
    {
        if(is_null($refundId) || $refundId==""){
            return null;
        }
        $url = $this->getUrl().Refund::$REFUND_ID_LINK.$refundId;
        $request = $this->setHeadersGet($url,$this->_oauthToken);
        $result = $this->doGet($request);
        $response = RefundInformation::fromArray($result);
        $response->setTransactionManager($this);
        return $response;
    }
    /**
     * Perform a new query that retrieves you the list of Refund Information.
     *
     * @return an RefundInformation list object.
     * @see {@link com.payhub.ws.api.VerfyResponseInformation};
     */
    public function getAllRefundInformation()
    {
        $url = $this->getUrl() . Refund::$REFUND_ID_LINK;
        $request = $this->setHeadersGet($url, $this->_oauthToken);
        $result = $this->doGet($request);
        if(array_key_exists('_embedded',$result)) {
            foreach ($result['_embedded']['refunds'] as $refunds) {
                $response_tmp = RefundInformation::fromArray($refunds);
                $response_tmp->setTransactionManager($this);
                $response[] = $response_tmp;
            }
            return $response;
        }else{
            $errors_tmp = new Errors();
            foreach ($result as $errorData) {
                $errors_tmp = Errors::fromArray($errorData);
            }
            $errors[]=$errors_tmp;
            return $errors;
        }
    }
    /**
     * Perform a new RecurringBilling.
     *
     * @param RecurringBill object.
     * @return a RecurringBillingInformation object.
     * @see {@link com.payhub.ws.api.RecurringBillResponseInformation};
     */
    public function doRecurringBill($recurringBill)
    {
        $recurringBill->setMerchant($this->_merchant);
        $recurringBill->setUrl($this->_url);
        $recurringBill->setToken($this->_oauthToken);
        $request = $this->setHeadersPost($recurringBill->getUrl(),$this->_oauthToken);
        $result = $recurringBill->performRecurringBill($request);
        $result->setTransactionManager($this);
        return $result;
    }
    /**
     * Perform a new query that retrieves you the Recurring Bill Information for a particular Recurring Bill transaction.
     *
     * @param String recurringBillId: the ID of a particular Recurring Bill Transaction.
     * @return a RecurringBillingInformation object.
     * @see {@link com.payhub.ws.api.RecurringBillResponseInformation};
     */
    public function getRecurringBillInformation($recurringBillId)
    {
        if(is_null($recurringBillId) || $recurringBillId==""){
            return null;
        }
        $url = $this->getUrl().RecurringBill::$RECURRENT_BILL_ID_LINK.$recurringBillId;
        $request = $this->setHeadersGet($url,$this->_oauthToken);
        $result = $this->doGet($request);
        $response = RecurringBillResponseInformation::fromArray($result);
        $response->setTransactionManager($this);
        return $response;
    }

    public function getAllRecurringBillInformation(){
        $url = $this->getUrl().RecurringBill::$RECURRENT_BILL_ID_LINK;
        $request = $this->setHeadersGet($url, $this->_oauthToken);
        $result = $this->doGet($request);
        if(array_key_exists('_embedded',$result)) {
            foreach ($result['_embedded']['recurringbills'] as $recurringBill) {
                $response_tmp = RecurringBillResponseInformation::fromArray($recurringBill);
                $response_tmp->setTransactionManager($this);
                $response[] = $response_tmp;
            }
            return $response;
        }else{
            $errors_tmp = new Errors();
            foreach ($result as $errorData) {
                $errors_tmp = Errors::fromArray($errorData);
            }
            $errors[]=$errors_tmp;
            return $errors;
        }
    }
    /**
     * Perform a new query that retrieves you the Recurring Bill Information from a Customer Id.
     *
     * @param String customerId: the ID of a particular Customer.
     * @return a RecurringBillingInformation object.
     * @see {@link com.payhub.ws.api.RecurringBillResponseInformation};
     */
    public function findRecurringBillInformationByCustomer($customerId){
        if(is_null($customerId) || $customerId==""){
            return null;
        }
        $url = $this->getUrl().RecurringBill::$RECURRENT_BILL_ID_LINK."search/findByCustomerRef?customerId=".$customerId;
        $request = $this->setHeadersGet($url, $this->_oauthToken);
        $result = $this->doGet($request);
        if(array_key_exists('_embedded',$result)) {
            foreach ($result['_embedded']['recurringbills'] as $recurringBill) {
                $response_tmp = RecurringBillResponseInformation::fromArray($recurringBill);
                $response_tmp->setTransactionManager($this);
                $response[] = $response_tmp;
            }
        }else{
            $errors_tmp = new Errors();
            foreach ($result as $errorData) {
                $errors_tmp = Errors::fromArray($errorData);
            }
            $errors[]=$errors_tmp;
            return $errors;
        }
    }
    /**
     * Perform a new query that retrieves you the list of bills for sales Information.
     *
     * @return an BillInformation list object.
     * @see {@link com.payhub.ws.api.BillInformation};
     */
    public function getAllBillForSalesInformation(){
        $url = $this->getUrl()."bill-for-sale/";
        $request = $this->setHeadersGet($url, $this->_oauthToken);
        $result = $this->doGet($request);
        if(array_key_exists('_embedded',$result)) {
            foreach ($result['_embedded']['billforsale'] as $billForSale) {
                $response_tmp = BillInformation::fromJson(json_encode($billForSale));
                $response_tmp->setTransactionManager($this);
                $response[] = $response_tmp;
            }
            return $response;
        }else{
            $errors_tmp = new Errors();
            foreach ($result as $errorData) {
                $errors_tmp = Errors::fromArray($errorData);
            }
            $errors[]=$errors_tmp;
            return $errors;
        }
    }
    /**
     * Perform a new query that retrieves you the list of bills for recurring bills Information.
     *
     * @return an BillInformation list object.
     * @see {@link com.payhub.ws.api.BillInformation};
     */
    public function getAllBillForRecurringBillInformation()
    {
        $url = $this->getUrl()."bill-for-recurring-bill/";
        $request = $this->setHeadersGet($url, $this->_oauthToken);
        $result = $this->doGet($request);
        if(array_key_exists('_embedded',$result)) {
            foreach ($result['_embedded']['billsforrecurringbill'] as $billForSale) {
                $response_tmp = BillInformation::fromJson(json_encode($billForSale));
                $response_tmp->setTransactionManager($this);
                $response[] = $response_tmp;
            }
            return $response;
        }else{
            $errors_tmp = new Errors();
            foreach ($result as $errorData) {
                $errors_tmp = Errors::fromArray($errorData);
            }
            $errors[]=$errors_tmp;
            return $errors;
        }
    }
    /**
     * Perform a new query that retrieves you the list of Merchants.
     *
     * @return an MerchantInformation list object.
     * @see {@link com.payhub.ws.api.MerchantInformation};
     */
    public function getAllMerchantInformation()
    {
        $url = $this->getUrl()."merchant/";
        $request = $this->setHeadersGet($url, $this->_oauthToken);
        $result = $this->doGet($request);
        if(array_key_exists('_embedded',$result)) {
            foreach ($result['_embedded']['merchants'] as $billForSale) {
                $response_tmp = MerchantInformation::fromJson(json_encode($billForSale));
                $response[] = $response_tmp;
            }
            return $response;
        }else{
            $errors_tmp = new Errors();
            foreach ($result as $errorData) {
                $errors_tmp = Errors::fromArray($errorData);
            }
            $errors[]=$errors_tmp;
            return $errors;
        }
    }
    /**
     * Perform a new query that retrieves you the list of Card Data.
     *
     * @return an CardDataInformation list object.
     * @see {@link com.payhub.ws.api.CardDataInformation};
     */
    public function getAllCardDataInformation()
    {
        $url = $this->getUrl()."carddata/";
        $request = $this->setHeadersGet($url, $this->_oauthToken);
        $result = $this->doGet($request);
        if(array_key_exists('_embedded',$result)) {
            foreach ($result['_embedded']['carddata'] as $billForSale) {
                $response_tmp = CardDataInformation::fromJson(json_encode($billForSale));
                $response[] = $response_tmp;
            }
            return $response;
        }else{
            $errors_tmp = new Errors();
            foreach ($result as $errorData) {
                $errors_tmp = Errors::fromArray($errorData);
            }
            $errors[]=$errors_tmp;
            return $errors;
        }

    }
    /**
     * Perform a new query that retrieves you the list of Customers for sales.
     *
     * @return an CustomerInformation list object.
     * @see {@link com.payhub.ws.api.CustomerInformation};
     */
    public function getAllCustomerForSalesInformation()
    {
        $url = $this->getUrl()."customer-for-sale/";
        $request = $this->setHeadersGet($url, $this->_oauthToken);
        $result = $this->doGet($request);
        if(array_key_exists('_embedded',$result)) {
            foreach ($result['_embedded']['customerforsale'] as $billForSale) {
                $response_tmp = CustomerInformation::fromJson(json_encode($billForSale));
                $response_tmp->setTransactionManager($this);
                $response[] = $response_tmp;
            }
            return $response;
        }else{
            $errors_tmp = new Errors();
            foreach ($result as $errorData) {
            $errors_tmp = Errors::fromArray($errorData);
            }
            $errors[]=$errors_tmp;
            return $errors;
        }
    }

    public function updateRecurringBillStatus($id){
        if(is_null($id) || $id==""){
            return false;
        }
        $url=$this->getUrl()."recurring-bill-status/".$id;
        $request = $this->setHeadersPatch($url,$this->_oauthToken);

        $data = array("recurring_bill_status" => "CANCELED");
        $json = json_encode($data);
        $result=$this->doPatch($request,$json);
        return $result;
    }

    public function updateRecurringBill($id, $recurringBill)
    {
        if(is_null($id) || $id==""){
            return false;
        }
        $url=$this->getUrl()."recurring-bill/".$id;
        $request = $this->setHeadersPatch($url,$this->_oauthToken);
        $json = RecurringBill::toJson($recurringBill);
        $result=$this->doPatch($request,$json);
        if(is_array($result)){
            $errors_tmp = new Errors();
            foreach ($result as $errorData) {
                $errors_tmp = Errors::fromArray($errorData);
            }
            $errors[]=$errors_tmp;
            return $errors;
        }else{
            return true;
        }
        return $result;
    }
    /**
     * Perform a new query that retrieves you the list of Customers for Recurring billings.
     *
     * @return an CustomerInformation list object.
     * @see {@link com.payhub.ws.api.CustomerInformation};
     */
    public function getAllCustomerForRecurringBillInformation()
    {
        $url = $this->getUrl()."customer/";
        $request = $this->setHeadersGet($url, $this->_oauthToken);
        $result = $this->doGet($request);
        if(array_key_exists('_embedded',$result)) {
            foreach ($result['_embedded']['customers'] as $customer) {
                $response_tmp = CustomerInformation::fromJson(json_encode($customer));
                $response_tmp->setTransactionManager($this);
                $response[] = $response_tmp;
            }
            return $response;
        }else{
                $errors_tmp = new Errors();
                foreach ($result as $errorData) {
                    $errors_tmp = Errors::fromArray($errorData);
                }
                $errors[]=$errors_tmp;
                return $errors;
        }
    }
    public function findTransactions($parameters){
        $url = $this->getUrl()."report/transactionReport/";
        $request = $this->setHeadersPost($url, $this->_oauthToken);
        $transactionReports = $this->findTransactionReports($request,json_encode($parameters));

        foreach ($transactionReports as $transactionReport) {
            $response_tmp = TransactionReportInformation::fromArray($transactionReport);
            $respose[] = $response_tmp;
        }
        return $respose;
    }

    /**
     * @param $datos
     * @param $type
     * @param $operationId
     */
    public function addMetadata($metadata,$type,$operationId){
        $metadataUrl=null;
        if(TransactionType::Sale==$type){
            $metadataUrl=$this->_url."metadata/forSale/".$operationId;
        }if(TransactionType::AuthOnly==$type){
            $metadataUrl=$this->_url."metadata/forAuthOnly/".$operationId;
        }if(TransactionType::Capture==$type){
            $metadataUrl=$this->_url."metadata/forCapture/".$operationId;
        }if(TransactionType::Bill==$type){
            $metadataUrl=$this->_url."metadata/forBill/".$operationId;
        }if(TransactionType::CardData==$type){
            $metadataUrl=$this->_url."metadata/forCardData/".$operationId;
        }if(TransactionType::Customer==$type){
            $metadataUrl=$this->_url."metadata/forCustomer/".$operationId;
        }if(TransactionType::Merchant==$type){
            $metadataUrl=$this->_url."metadata/forMerchant/".$operationId;
        }if(TransactionType::RecurringBill==$type){
            $metadataUrl=$this->_url."metadata/forRecurringBill/".$operationId;
        }if(TransactionType::Schedule==$type){
            $metadataUrl=$this->_url."metadata/forSchedule/".$operationId;
        }if(TransactionType::Refund==$type){
            $metadataUrl=$this->_url."metadata/forRefund/".$operationId;
        }if(TransactionType::VoidTransaction==$type){
            $metadataUrl=$this->_url."metadata/forVoid/".$operationId;
        }
        $request = $this->setHeadersPut($metadataUrl, $this->_oauthToken);
        $result = $this->doPut($request,$metadata);
        if(is_array($result)){
            foreach ($result as $errorData) {
                $errors_tmp = Errors::fromArray($errorData);
            }
            $errors[]=$errors_tmp;
            return $errors;
        }else{
            return true;
        }
    }

    public function getGeneralSettings()
    {
        $url = $this->getUrl().GeneralSettings::$GENERAL_SETTINGS_LINK;
        $request = $this->setHeadersGet($url, $this->_oauthToken);
        $result = $this->doGet($request);
        $response_tmp = GeneralSettings::fromArray($result);
        return $response_tmp;
    }
    public function getWebhookConfiguration()
    {
        $url = $this->getUrl().WebhookConfiguration::$WEBHOOK_LINK;
        $request = $this->setHeadersGet($url, $this->_oauthToken);
        $result = $this->doGet($request);
        $response_tmp = WebhookConfiguration::fromArray($result['webhookConfiguration']);
        return $response_tmp;
    }
    public function getValidatedDevices()
    {
        $url = $this->getUrl().ValidatedDevices::$VALIDATED_DEVICES_LINK;
        $request = $this->setHeadersGet($url, $this->_oauthToken);
        $result = $this->doGet($request);
        $response_tmp = ValidatedDevices::fromArray($result);
        return $response_tmp;
    }

    public function getRiskFraudSettings()
    {
        $url = $this->getUrl().RiskFraudSettings::$RISK_FRAUD_SETTINGS_LINK;
        $request = $this->setHeadersGet($url, $this->_oauthToken);
        $result = $this->doGet($request);
        $response_tmp = RiskFraudSettings::fromArray($result);
        return $response_tmp;
    }

    public function patchWebhookConfiguration($wh)
    {
        $url = $this->getUrl().WebhookConfiguration::$WEBHOOK_LINK;
        $request = $this->setHeadersPatch($url, $this->_oauthToken);
        $json = json_encode($wh->object_unset_nulls_for_send());

        $result = $this->doPatch($request,$json);

        if(is_array($result)){
            $errors_tmp = new Errors();
            foreach ($result as $errorData) {
                $errors_tmp = Errors::fromArray($errorData);
            }
            $errors[]=$errors_tmp;
            return $errors;
        }else{
            return true;
        }
    }
    public function patchValidatedDevices($vd)
    {
        $url = $this->getUrl().ValidatedDevices::$VALIDATED_DEVICES_LINK;
        $request = $this->setHeadersPatch($url, $this->_oauthToken);
        $json = json_encode($vd->object_unset_nulls_for_send());

        $result = $this->doPatch($request,$json);

        if(is_array($result)){
            $errors_tmp = new Errors();
            foreach ($result as $errorData) {
                $errors_tmp = Errors::fromArray($errorData);
            }
            $errors[]=$errors_tmp;
            return $errors;
        }else{
            return true;
        }
    }

    public function patchRiskFraudSettings($risk)
    {
        $url = $this->getUrl().RiskFraudSettings::$RISK_FRAUD_PATCH_SETTINGS_LINK;
        $request = $this->setHeadersPatch($url, $this->_oauthToken);
        $json = json_encode($risk->object_unset_nulls_for_send());
        $result = $this->doPatch($request,$json);

        if(is_array($result)){
            $errors_tmp = new Errors();
            foreach ($result as $errorData) {
                $errors_tmp = Errors::fromArray($errorData);
            }
            $errors[]=$errors_tmp;
            return $errors;
        }else{
            return true;
        }
    }

    public function getAllUserRoles()
    {
    	$url = $this->getUrl().UserRoles::$ALL_USER_ROLE_LINK;
        $request = $this->setHeadersGet($url, $this->_oauthToken);
        $result = $this->doGet($request);
        $response_tmp = UserRoles::fromArray($result);
        return $response_tmp;
    }

    public function getUserRolesById($roleId)
    {
        if(is_null($roleId) || $roleId==""){
            return null;
        }
        $url = $this->getUrl().RoleSettings::$USER_ROLE_LINK.$roleId;
        $request = $this->setHeadersGet($url, $this->_oauthToken);
        $result = $this->doGet($request);
        $response_tmp = RoleSettings::fromArray($result);
        return $response_tmp;
    }

    public function patchUserRoles($roleSettings, $roleId)
    {
        if(is_null($roleId) || $roleId==""){
            return null;
        }
        if(is_null($roleSettings) || $roleSettings==""){
            return null;
        }

        $url = $this->getUrl().RoleSettings::$PATCH_USER_ROLE_LINK.$roleId;
        $request = $this->setHeadersPatch($url, $this->_oauthToken);
        $json = json_encode($roleSettings->object_unset_nulls_for_send());
        $result = $this->doPatch($request,$json);

        if(is_array($result)){
            $errors_tmp = new Errors();
            foreach ($result as $errorData) {
                $errors_tmp = Errors::fromArray($errorData);
            }
            $errors[]=$errors_tmp;
            return $errors;
        }else{
            return true;
        }
    }
    public function postUserRoles($roleSettings)
    {
        if(is_null($roleSettings) || $roleSettings==""){
            return null;
        }

        $url = $this->getUrl().RoleSettings::$CREATE_USER_ROLE_LINK;
        $request = $this->setHeadersPost($url, $this->_oauthToken);
        $json = json_encode($roleSettings->object_unset_nulls_for_send());
        $result = $this->doPostForRoles($request,$json);

        if(is_array($result)){
            $errors_tmp = new Errors();
            foreach ($result as $errorData) {
                $errors_tmp = Errors::fromArray($errorData);
            }
            $errors[]=$errors_tmp;
            return $errors;
        }else{
            return true;
        }
    }
}