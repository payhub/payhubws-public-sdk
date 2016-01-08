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
    public function __construct($merchant, $customer, $bill, $card_data, $schedule)
    {
        $this->merchant = $merchant;
        $this->customer = $customer;
        $this->bill = $bill;
        $this->card_data = $card_data;
        $this->schedule = $schedule;
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

}