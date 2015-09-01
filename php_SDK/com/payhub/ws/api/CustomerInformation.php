<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 10:37
 */
class CustomerInformation
{
    public $version;
    public $createdAt;
    public $lastModified;
    public $createdBy;
    public $lastModifiedBy;
    public $metaData;
    private $transactionManager;
    private $transactionType;
    private $url;
    private $customer;

    /**
     * CustomerInformation constructor.
     * @param $transactionType
     */
    public function __construct($transactionManager)
    {
        if(!is_null($transactionManager)) {
            $this->transactionManager = $transactionManager;
        }
        $this->transactionType=TransactionType::Customer;

    }

    /**
     * @return mixed
     */
    public function getTransactionManager()
    {
        return $this->transactionManager;
    }

    /**
     * @param mixed $transactionManager
     */
    public function setTransactionManager($transactionManager)
    {
        $this->transactionManager = $transactionManager;
    }

    /**
     * @return mixed
     */
    public function getTransactionType()
    {
        return $this->transactionType;
    }

    /**
     * @param mixed $transactionType
     */
    public function setTransactionType($transactionType)
    {
        $this->transactionType = $transactionType;
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
     * @param $json
     */
    private function convertDataToCustomer($json){
        $data = json_decode($json, true);
        $this->customer = Customer::fromArray($data);
    }

    /**
     * @param $json
     */
    private function convertData($json){
        $obj = json_decode($json);
        $this->version=$obj->{'version'};
        $this->createdAt=$obj->{'createdAt'};
        $this->lastModified=$obj->{'lastModified'};
        $this->createdBy=$obj->{'createdBy'};
        $this->lastModifiedBy=$obj->{'lastModifiedBy'};
        $this->metaData=$obj->{'metaData'};
    }
    
    public function getCustomerForSaleInformationByTransactionId($id){
        $url = $this->getUrl().$id."/customer";
        $request = $this->transactionManager->setHeadersGet($url, $this->transactionManager->getToken());
        $json=$this->transactionManager->doGet($request);
        $this->convertData(json_encode($json));
        $this->convertDataToCustomer(json_encode($json));
    }
    public function getCustomerForSaleInformationById($id){
        $url = $this->transactionManager->getUrl()."customer-for-sale/".$id;
        $request = $this->transactionManager->setHeadersGet($url, $this->transactionManager->getToken());
        $json=$this->transactionManager->doGet($request);
        $this->convertData(json_encode($json));
        $this->convertDataToCustomer(json_encode($json));
    }
    public function getCustomerForRecurringCustomerInformationByTransactionId($id){
        $url = $this->getUrl().$id."/customer";
        $request = $this->transactionManager->setHeadersGet($url, $this->transactionManager->getToken());
        $json=$this->transactionManager->doGet($request);
        $this->convertData(json_encode($json));
        $this->convertDataToCustomer(json_encode($json));
    }
    public function getCustomerForRecurringCustomerInformationById($id){
        $url = $this->transactionManager->getUrl()."customer/".$id;
        $request = $this->transactionManager->setHeadersGet($url, $this->transactionManager->getToken());
        $json=$this->transactionManager->doGet($request);
        $this->convertData(json_encode($json));
        $this->convertDataToCustomer(json_encode($json));
    }
    public static function fromJson($data){
        if(!is_null($data)) {
            $customerInformation= new CustomerInformation();
            $customerInformation->convertData($data);
            $customerInformation->convertDataToCustomer($data);
            return $customerInformation;
        }
    }

}