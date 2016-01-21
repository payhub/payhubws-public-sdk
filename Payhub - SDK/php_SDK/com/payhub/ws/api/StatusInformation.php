<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 09/09/15
 * Time: 11:19 AM
 */
class StatusInformation extends AbstractInfo
{
    private $status;
    /**
     * RefundInformation constructor.
     * @param $transactionManager
     */
    public function __construct($transactionManager)
{
    if(!is_null($transactionManager)) {
        $this->transactionManager = $transactionManager;
    }
    $this->transactionType=TransactionType::Status;
}
    /**
     * @return mixed
     */
    public function getStatus()
{
    return $this->status;
}

    /**
     * @param mixed $status
     */
    public function setStatus($status)
{
    $this->status = $status;
}

    public function convertData($json)
{
    $data = json_decode($json, true);
    $this->status = Status::fromArray($data);
}

    public function getUrlForTransactionType($type)
{
    $url=null;
    if(TransactionType::Sale==($type)){
        $url =  "sale/";
    }
    if(TransactionType::AuthOnly==($type)){
        $url =  "authonly/";
    }
    if(TransactionType::Capture==($type)){
        $url =  "capture/";
    }if(TransactionType::Bill==($type)){
    $url =  "bill";
    }if(TransactionType::CardData==($type)){
        $url =  "carddata/";
    }if(TransactionType::Customer==($type)){
        $url =  "customer/";
    }if(TransactionType::Merchant==($type)){
        $url =  "merchant/";
    }if(TransactionType::RecurringBill==($type)){
        $url =  "recurring-bill/";
    }if(TransactionType::Schedule==($type)){
        $url =  "schedule/";
    }if(TransactionType::Refund==($type)){
        $url =  "refund/";
    }if(TransactionType::VoidTransaction==($type)){
        $url =  "void/";
    }
    if(TransactionType::Verify==($type)){
        $url =  "verify/";
    }
    if(TransactionType::Status==($type)){
        $url =  "status/";
    }
    return $url;
}
}