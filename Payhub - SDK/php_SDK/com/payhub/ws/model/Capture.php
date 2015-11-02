<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 27/07/2015
 * Time: 12:21
 */
class Capture extends WsConnections
{
    private $url_basePath;
    private $url;
    public $merchant;
    public $bill;
    public static $CAPTURE_ID_LINK = "capture/";
    public $transaction_id;

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
        return $this->url_basePath."capture/";
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
     * Capture constructor.
     * @param $merchant
     * @param $bill
     * @param $transaction_id
     */
    public function __construct($merchant, $bill, $transaction_id)
    {
        if(!is_null($bill)){
            $this->bill = $bill;
        }
        if(!is_null($merchant)){
            $this->merchant = $merchant;
        }
        if(!is_null($transaction_id)){
            $this->transaction_id = $transaction_id;
        }
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
    public function doCapture($request){
        $json = json_encode($this->object_unset_nulls(null));
        curl_setopt($request, CURLOPT_POSTFIELDS, $json);
        $result = $this->doPost($request,$this->getUrl());
        $response = CaptureResponseInformation::fromArray($result);
        return $response;
    }
}