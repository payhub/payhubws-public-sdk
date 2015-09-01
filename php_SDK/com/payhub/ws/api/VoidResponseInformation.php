<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 08:58
 */
class VoidResponseInformation
{
    public $transaction_id;
    public $lastVoidResponse;
    public $merchantOrganizationId;
    public $_links;
    public $errors;
    public $rowData;
    public $metaData;
    private $transactionManager;
    private $merchantInformation;

    /**
     * @return mixed
     */
    public function getTransactionId()
    {
        return $this->transaction_id;
    }

    /**
     * @param mixed $transaction_id
     */
    public function setTransactionId($transaction_id)
    {
        $this->transaction_id = $transaction_id;
    }

    /**
     * @return mixed
     */
    public function getLastVoidResponse()
    {
        return $this->lastVoidResponse;
    }

    /**
     * @param mixed $lastVoidResponse
     */
    public function setLastVoidResponse($lastVoidResponse)
    {
        $this->lastVoidResponse = $lastVoidResponse;
    }

    /**
     * @return mixed
     */
    public function getMerchantOrganizationId()
    {
        return $this->merchantOrganizationId;
    }

    /**
     * @param mixed $merchantOrganizationId
     */
    public function setMerchantOrganizationId($merchantOrganizationId)
    {
        $this->merchantOrganizationId = $merchantOrganizationId;
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
    public function getMerchantInformation()
    {
        if($this->merchantInformation==null){
            $m = new MerchantInformation($this->transactionManager);
            $m->getDataByTransaction(TransactionType::VoidTransaction, $this->lastVoidResponse->getVoidTransactionId());
            $this->merchantInformation=$m;
        }
        return $this->merchantInformation;
    }

    public static function fromArray($data){
        $void = new VoidResponseInformation();

        foreach ($data as $key => $value){
            if( property_exists( get_class($void), $key ) ) {
                if($key=="lastVoidResponse"){
                    $void->{$key}=VoidResponse::fromArray($value);
                }elseif($key=="errors"){
                    $void->{$key}=Errors::fromArray($value);
                }
                else{
                    $void->{$key} = $value;
                }
            }
        }
        return $void;
    }
}