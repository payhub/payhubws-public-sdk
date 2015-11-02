<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 10:24
 */
class CardDataInformation extends AbstractInfo
{
    private $cardData;

    public function __construct($transactionManager)
    {
        if(!is_null($transactionManager)) {
            $this->transactionManager = $transactionManager;
        }
        $this->transactionType=TransactionType::CardData;

    }
    public function convertData($json)
    {
        $data = json_decode($json, true);
        $this->cardData =CardData::fromArray($data);
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
        return $url;
    }

    public static function fromJson($data){
        if(!is_null($data)) {
            $cardDataInformation= new CardDataInformation(null);
            $cardDataInformation->convertData($data);
            $cardDataInformation->convertAbstractData($data);
            return $cardDataInformation;
        }
    }
}