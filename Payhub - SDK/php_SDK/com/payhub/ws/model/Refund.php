<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 28/07/2015
 * Time: 09:11
 */
class Refund extends WsConnections
{
    public static $REFUND_ID_LINK = "refund/";
    private $url_basePath;
    private $url;
    public $transaction_id;
    public $merchant;
    public $record_format;

    /**
     * Refund constructor.
     * @param $transaction_id
     * @param $merchant
     * @param $record_format
     */
    public function __construct($transaction_id, $merchant, $record_format)
    {
        $this->transaction_id = $transaction_id;
        $this->merchant = $merchant;
        $this->record_format = $record_format;
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
        return $this->url_basePath."refund/";
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
    public function getRecordFormat()
    {
        return $this->record_format;
    }

    /**
     * @param mixed $record_format
     */
    public function setRecordFormat($record_format)
    {
        $this->record_format = $record_format;
    }

    public function performRefund($request){
        $json = json_encode($this->object_unset_nulls(null));
        curl_setopt($request, CURLOPT_POSTFIELDS, $json);
        $result = $this->doPost($request,$this->getUrl());
        $response = RefundInformation::fromArray($result);
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

}