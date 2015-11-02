<?php 
class AuthorizationResponseInformation {
    public $authOnlyResponse;
    public $_links;
    public $errors;
    public $rowData;
    public $metaData;
    public $transactionManager;
    public $billInformation;
    public $cardDataInformation;
    public $customerInformation;
    public $merchantInformation;

    /**
     * @return mixed
     */
    public function getAuthOnlyResponse()
    {
        return $this->authOnlyResponse;
    }

    /**
     * @param mixed $authOnlyResponse
     */
    public function setAuthOnlyResponse($authOnlyResponse)
    {
        $this->authOnlyResponse=$authOnlyResponse;
    }

    /**
     * @return mixed
     */
    public function getLinks()
    {
        return $this->_links;
    }

    /**
     * @param mixed $links
     */
    public function setLinks($links)
    {
        $this->_links = $links;
    }

    /**
     * @return mixed
     */
    public function getErrors()
    {
        return $this->errors;
    }

    /**
     * @param mixed $errors
     */
    public function setErrors($errors)
    {
        $this->errors = $errors;
    }

    /**
     * @return mixed
     */
    public function getRowData()
    {
        return $this->rowData;
    }

    /**
     * @param mixed $rowData
     */
    public function setRowData($rowData)
    {
        $this->rowData = $rowData;
    }

    /**
     * @return mixed
     */
    public function getMetaData()
    {
        return $this->metaData;
    }

    /**
     * @param mixed $metaData
     */
    public function setMetaData($metaData)
    {
        $this->metaData = $metaData;
    }

    /**
     * @param mixed $transactionManager
     */
    public function setTransactionManager($transactionManager)
    {
        $this->transactionManager = $transactionManager;
    }

    /**
     * @return mixed
     */
    public function getCardDataInformation()
    {
        if($this->cardDataInformation==null){
            $c = new CardDataInformation($this->transactionManager);
            $c.getDataByTransaction(TransactionType::AuthOnly, $this->authOnlyResponse->getTransactionId());
            $this->cardDataInformation=$c;
        }
        return $this->cardDataInformation;
    }

    /**
     * @return mixed
     */
    public function getCustomerInformation()
    {
        if($this->customerInformation==null){
            $c = new CustomerInformation($this->transactionManager);
            $c->setUrl($this->transactionManager->getUrl()."authonly/");
			$c.getDataByTransaction(TransactionType::AuthOnly, $this->authOnlyResponse->getTransactionId());
			$this->customerInformation=$c;
			}
        return $this->customerInformation;
    }

    public function getBillInformation()
    {
        if($this->billInformation==null){
            $b = new BillInformation($this->transactionManager);
            $b->setUrl($this->transactionManager->getUrl()."authonly/");
            $b->getBillForRecurringBillInformationById($this->authOnlyResponse->getTransactionId());
            $this->billInformation=$b;
        }
        return $this->billInformation;
    }

    /**
     * @return mixed
     */
    public function getMerchantInformation()
    {
        if($this->merchantInformation==null){
            $m = new MerchantInformation($this->transactionManager);
            $m.getDataByTransaction(TransactionType::AuthOnly, $this->authOnlyResponse->getTransactionId());
            $merchantInformation=$m;
        }
        return $this->merchantInformation;
    }

    public static function fromArray($data){
        $auth = new AuthorizationResponseInformation();

        foreach ($data as $key => $value){
            if( property_exists( get_class($auth), $key ) ) {
                if($key=="authOnlyResponse"){
                    $auth->{$key}=AuthOnlyResponse::fromArray($value);
                }elseif($key=="errors"){
                    $auth->{$key}=Errors::fromArray($value);
                }
                else{
                    $auth->{$key} = $value;
                }
            }
        }
        return $auth;
    }
} 

?> 