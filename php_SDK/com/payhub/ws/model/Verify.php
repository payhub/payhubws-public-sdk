<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 28/07/2015
 * Time: 08:54
 */
class Verify extends WsConnections
{
    public static $VERIFY_ID_LINK = "verify/";
    private $url_basePath;
    private $url;
    public $merchant;
    public $customer;
    public $card_data;

    /**
     * Verify constructor.
     * @param $merchant
     * @param $customer
     * @param $card_data
     */
    public function __construct($merchant, $customer, $card_data)
    {
        $this->merchant = $merchant;
        $this->customer = $customer;
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
        return $this->url_basePath."verify/";
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
    public function performVerifyTransaction($request){
        $json = json_encode($this->object_unset_nulls(null));
        curl_setopt($request, CURLOPT_POSTFIELDS, $json);
        $result = $this->doPost($request,$this->getUrl());
        $response= VerifyResponseInformation::fromArray($result);
        return $response;
    }

}