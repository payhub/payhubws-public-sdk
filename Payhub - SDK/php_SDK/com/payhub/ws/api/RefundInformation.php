<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 10:53
 */
class RefundInformation
{
    public $transaction_id;
    public $lastRefundResponse;
    public $_links;
    public $errors;
    public $rowData;
    public $metaData;
    private $transactionManager;
    private $merchantInformation;
    public $settlementStatus;
    public $merchantOrganizationId;

    /**
     * @return mixed
     */
    public function getSettlementStatus()
    {
        return $this->settlementStatus;
    }

    /**
     * @param mixed $settlementStatus
     */
    public function setSettlementStatus($settlementStatus)
    {
        $this->settlementStatus = $settlementStatus;
    }

    /**
     * RefundInformation constructor.
     * @param $transactionManager
     */
    public function __construct()
    {
        $this->transactionType=TransactionType::Refund;
    }

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
    public function getLastRefundResponse()
    {
        return $this->lastRefundResponse;
    }

    /**
     * @param mixed $lastRefundResponse
     */
    public function setLastRefundResponse($lastRefundResponse)
    {
        $this->lastRefundResponse = $lastRefundResponse;
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
     * @param $transactionManager
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
            $m->getDataByTransaction(TransactionType::Refund, $this->lastRefundResponse->getRefundTransactionId());
            $this->merchantInformation=$m;
        }
        return $this->merchantInformation;
    }
    public static function fromArray($data){
        $refund = new RefundInformation();
        foreach ($data as $key => $value){
            if( property_exists( get_class($refund), $key ) ) {
                if($key=="errors"){
                    $refund->{$key}=Errors::fromArray($value);
                }
                if($key=="lastRefundResponse"){
                    $refund->{$key}=RefundResponse::fromArray($value);
                }
                else{
                    $refund->{$key} = $value;
                }
            }
        }
        return $refund;
    }
}