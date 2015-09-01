<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 23/07/2015
 * Time: 12:26
 */
class AuthOnly extends WsConnections
{
    public static $AUTH_ID_LINK = "authonly/";
    private $url_basePath;
    private $url;
    public $merchant;
    public $customer;
    public $bill;
    public $card_data;

    /**
     * AuthOnly constructor.
     * @param $merchant
     * @param $customer
     * @param $bill
     * @param $card_data
     */
    public function __construct($merchant, $customer, $bill, $card_data)
    {
        $this->merchant = $merchant;
        $this->customer = $customer;
        $this->bill = $bill;
        $this->card_data = $card_data;
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
        return $this->url;
    }

    /**
     * @param mixed $url
     */
    public function setUrl($url)
    {
        $this->url = $url;
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
    public function doAuthOnly($request){

        $json = json_encode($this->object_unset_nulls(null));
        echo $json;
        curl_setopt($request, CURLOPT_POSTFIELDS, $json);
        $result = $this->doPost($request,$this->getUrl());
        $response = AuthorizationResponseInformation::fromArray($result);
        return $response;
    }
}