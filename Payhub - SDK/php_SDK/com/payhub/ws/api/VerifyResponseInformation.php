<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 09:09
 */
class VerifyResponseInformation
{
    public $verifyResponse;
    public $_links;
    public $errors;
    public $rowData;
    private $transactionManager;
    private $cardDataInformation;
    private $customerInformation;
    private $merchantInformation;

    /**
     * @return mixed
     */
    public function getVerifyResponse()
    {
        return $this->verifyResponse;
    }

    /**
     * @param mixed verifyResponse
     */
    public function setVerifyResponse($verifyResponse)
    {
        $this->verifyResponse = $verifyResponse;
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
     * @param mixed $transactionManager
     */
    public function setTransactionManager($transactionManager)
    {
        $this->transactionManager = $transactionManager;
    }

    /**
     * @return mixed
     */
    public function getMerchantInformation()
    {
        if($this->merchantInformation==null){
            $m = new MerchantInformation($this->transactionManager);
            $m->getDataByTransaction(TransactionType::Verify, $this->verifyResponse->getVerifyId());
            $this->merchantInformation=$m;
        }
        return $this->merchantInformation;
    }
    /**
     * @return mixed
     */
    public function getCardDataInformation()
    {
        if($this->cardDataInformation==null){
            $c = new CardDataInformation($this->transactionManager);
            $c->getDataByTransaction(TransactionType::Verify, $this->verifyResponse->getVerifyId());
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
            $c->setUrl($this->transactionManager->getUrl()."verify/");
            $c->getDataByTransaction(TransactionType::Verify, $this->verifyResponse->getVerifyId());
            $this->customerInformation=$c;
        }
        return $this->customerInformation;
    }

    public static function fromArray($data){
        $verif = new VerifyResponseInformation();

        foreach ($data as $key => $value){
            if( property_exists( get_class($verif), $key ) ) {
                if($key=="verifyResponse"){
                    $verif->{$key}=VerifyResponse::fromArray($value);
                }elseif($key=="errors"){
                    $verif->{$key}=Errors::fromArray($value);
                }
                else{
                    $verif->{$key} = $value;
                }
            }
        }
        return $verif;
    }
}