<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 28/07/2015
 * Time: 09:03
 */
class VoidTransaction extends WsConnections
{
    private $url_basePath;
    private $url;
    public $merchant;
    public $transaction_id;
    public static $VOID_ID_LINK = "void/";

    /**
     * VoidTransaction constructor.
     * @param $merchant
     * @param $transaction_id
     */
    public function __construct($merchant, $transaction_id)
    {
        $this->merchant = $merchant;
        $this->transaction_id = $transaction_id;
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
        return $this->url_basePath.'void/';
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
    public function performVoidTransaction($request){
        $json = json_encode($this->object_unset_nulls(null));
        echo $json;
        curl_setopt($request, CURLOPT_POSTFIELDS, $json);
        $result = $this->doPost($request,$this->getUrl());
        $response = VoidResponseInformation::fromArray($result);
        return $response;
    }
}