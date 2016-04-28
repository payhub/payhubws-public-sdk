<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 28/07/2015
 * Time: 09:49
 */
class RecurringBill extends WsConnections
{
    private $url_basePath;
    private $url;
    public $merchant;
    public $customer;
    public $bill;
    public $card_data;
    public $schedule;
    public static $RECURRENT_BILL_ID_LINK = "recurring-bill/";

    /**
     * RecurringBill constructor.
     * @param $merchant
     * @param $customer
     * @param $bill
     * @param $card_data
     * @param $schedule
     */
    public function __construct(){
        $parameters = func_get_args();
        foreach ($parameters as $parameter) {
            if($parameter instanceof  Merchant){
                $this->merchant = $parameter;
            }elseif($parameter instanceof Customer){
                $this->customer = $parameter;
            }elseif($parameter instanceof Bill){
                $this->bill = $parameter;
            }elseif($parameter instanceof CardData){
                $this->card_data = $parameter;
            }elseif($parameter instanceof Schedule){
                $this->schedule = $parameter;
            }
        }
    }
    /**
     * @return mixed
     */
    public function getUrlBasePath()
    {
        return $this->url_basePath;
    }

    /**
     * @param mixed $url_basePath
     */
    public function setUrlBasePath($url_basePath)
    {
        $this->url_basePath = $url_basePath;
    }

    /**
     * @return mixed
     */
    public function getUrl()
    {
        return $this->url_basePath."recurring-bill/";
    }

    /**
     * @param mixed $url
     */
    public function setUrl($url)
    {
        $this->url_basePath = $url;
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

    /**
     * @return mixed
     */
    public function getCustomer()
    {
        return $this->customer;
    }

    /**
     * @param mixed $customer
     */
    public function setCustomer($customer)
    {
        $this->customer = $customer;
    }

    /**
     * @return mixed
     */
    public function getBill()
    {
        return $this->bill;
    }

    /**
     * @param mixed $bill
     */
    public function setBill($bill)
    {
        $this->bill = $bill;
    }

    /**
     * @return mixed
     */
    public function getCardData()
    {
        return $this->card_data;
    }

    /**
     * @param mixed $card_data
     */
    public function setCardData($card_data)
    {
        $this->card_data = $card_data;
    }

    /**
     * @return mixed
     */
    public function getSchedule()
    {
        return $this->schedule;
    }

    /**
     * @param mixed $schedule
     */
    public function setSchedule($schedule)
    {
        $this->schedule = $schedule;
    }

    public function performRecurringBill($request){
        $json = json_encode($this->object_unset_nulls(null));
        curl_setopt($request, CURLOPT_POSTFIELDS, $json);
        $result = $this->doPost($request,$this->getUrl());
        $response = RecurringBillResponseInformation::fromArray($result);
        return $response;
    }

    private function object_unset_nulls($obj)
    {
        if(is_null($obj)){$obj=$this;}
        $arrObj = is_object($obj) ? get_object_vars($obj) : $obj;
        foreach($arrObj as $key => $val)
        {
            $val = (is_array($val) || is_object($val)) ? $this->object_unset_nulls($val) : $val;
            if (is_array($obj))
                $obj[$key] = $val;
            else
                $obj->$key = $val;
            if($val == null)
                unset($obj->$key);
        }
        return $obj;
    }
    public static function toJson($recurringBill){
        $json = json_encode($recurringBill->object_unset_nulls(null));
        return $json;
    }

}