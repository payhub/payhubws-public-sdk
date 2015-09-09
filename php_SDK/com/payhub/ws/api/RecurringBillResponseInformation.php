<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 10:47
 */
class RecurringBillResponseInformation
{
    public $status;
    public $lastRecurringBillResponse;
    public $_links;
    public $errors;
    public $rowData;
    public $metaData;
    private $transactionManager;
    private $billInformation;
    private $cardDataInformation;
    private $customerInformation;
    private $merchantInformation;
    private $scheduleInformation;

    /**
     * @return mixed
     */
    public function getLastRecurringBillResponse()
    {
        return $this->lastRecurringBillResponse;
    }

    /**
     * @param mixed $lastRecurringBillResponse
     */
    public function setLastRecurringBillResponse($lastRecurringBillResponse)
    {
        $this->lastRecurringBillResponse = $lastRecurringBillResponse;
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
            $c->getDataByTransaction(TransactionType::RecurringBill, $this->lastRecurringBillResponse->getRecurringBillId());
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
            $c->setUrl($this->transactionManager->getUrl()."recurring-bill/");
            $c->getDataByTransaction(TransactionType::RecurringBill, $this->lastRecurringBillResponse->getRecurringBillId());
            $this->customerInformation=$c;
        }
        return $this->customerInformation;
    }

    public function getBillInformation()
    {
        if($this->billInformation==null){
            $b = new BillInformation($this->transactionManager);
            $b->setUrl($this->transactionManager->getUrl()."recurring-bill/");
            $b->getBillForRecurringBillInformationById($this->lastRecurringBillResponse->getRecurringBillId());
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
            $m->getDataByTransaction(TransactionType::RecurringBill, $this->lastRecurringBillResponse->getRecurringBillId());
            $this->merchantInformation=$m;
        }
        return $this->merchantInformation;
    }
    public function getScheduleInformation()
    {
        if($this->scheduleInformation==null){
            $s = new ScheduleInformation($this->transactionManager);
            $s->getDataByTransaction(TransactionType::RecurringBill, $this->lastRecurringBillResponse->getRecurringBillId());
            $this->scheduleInformation=$s;
        }
        return $this->scheduleInformation;
    }
    /**
     * @return mixed
     */
    public function getStatusInformation()
    {
        if($this->status==null){
            $s = new StatusInformation($this->transactionManager);
            $s->getDataByTransaction(TransactionType::RecurringBill, $this->lastRecurringBillResponse->getRecurringBillId());
            $this->status=$s;
        }
        return $this->status;
    }
    public static function fromArray($data){
        $recurringBill = new RecurringBillResponseInformation();

        foreach ($data as $key => $value){
            if( property_exists( get_class($recurringBill), $key ) ) {
                if($key=="lastRecurringBillResponse"){
                    $recurringBill->{$key}=RecurringBillResponse::fromArray($value);
                }elseif($key=="errors"){
                    $recurringBill->{$key}=Errors::fromArray($value);
                }elseif($key=="status"){
                    $recurringBill->{$key}=Status::fromArray($value);
                }else{
                    $recurringBill->{$key} = $value;
                }
            }
        }
        return $recurringBill;
    }
}