<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 10:45
 */
class MerchantInformation extends AbstractInfo
{
    private $merchant;

    /**
     * MerchantInformation constructor.
     * @param $transactionManager
     */
    public function __construct($transactionManager)
    {
        if(!is_null($transactionManager)) {
            $this->transactionManager = $transactionManager;
        }
        $this->transactionType=TransactionType::Merchant;
    }

    /**
     * @return mixed
     */
    public function getMerchant()
    {
        return $this->merchant;
    }

    /**
     * @param mixed $merchant
     */
    public function setMerchant($merchant)
    {
        $this->merchant = $merchant;
    }

    public function convertData($json)
    {
        $data = json_decode($json, true);
        $this->merchant = Merchant::fromArray($data);
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
            $merchantInfromation= new MerchantInformation(null);
            $merchantInfromation->convertData($data);
            $merchantInfromation->convertAbstractData($data);
            return $merchantInfromation;
        }
    }
}