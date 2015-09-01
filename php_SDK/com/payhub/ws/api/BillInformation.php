<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 09:47
 */
class BillInformation
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
    private $bill;

    /**
     * BillInformation constructor.
     * @param $transactionManager
     */
    public function __construct($transactionManager)
    {
        if(!is_null($transactionManager)) {
            $this->transactionManager = $transactionManager;
        }
        $this->transactionType=TransactionType::Bill;
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
    private function convertData($json){
        $obj = json_decode($json);
        $this->version=$obj->{'version'};
        $this->createdAt=$obj->{'createdAt'};
        $this->lastModified=$obj->{'lastModified'};
        $this->createdBy=$obj->{'createdBy'};
        $this->lastModifiedBy=$obj->{'lastModifiedBy'};
        $this->metaData=$obj->{'metaData'};
    }

    private function convertDataToBill($json){
            $data = json_decode($json, true);
            $this->bill = Bill::fromArray($data);
    }

    public function getBillForSaleInformationByTransactionId($id){
        $url = $this->getUrl().$id."/bill";
        $request = $this->transactionManager->setHeadersGet($url, $this->transactionManager->getToken());
        $json=$this->transactionManager->doGet($request);
        $this->convertData(json_encode($json));
        $this->convertDataToBill(json_encode($json));
    }
    public function getBillForSaleInformationById($id){
        $url = $this->transactionManager->getUrl()."bill-for-sale/".$id;
        $request = $this->transactionManager->setHeadersGet($url, $this->transactionManager->getToken());
        $json=$this->transactionManager->doGet($request);
        $this->convertData(json_encode($json));
        $this->convertDataToBill(json_encode($json));
	}
	public function getBillForRecurringBillInformationByTransactionId($id){
        $url = $this->getUrl().$id."/bill";
        $request = $this->transactionManager->setHeadersGet($url, $this->transactionManager->getToken());
        $json=$this->transactionManager->doGet($request);
        $this->convertData(json_encode($json));
        $this->convertDataToBill(json_encode($json));
	}
	public function getBillForRecurringBillInformationById($id){
        $url = $this->transactionManager->getUrl()."bill-for-recurring-bill/".$id;
        $request = $this->transactionManager->setHeadersGet($url, $this->transactionManager->getToken());
        $json=$this->transactionManager->doGet($request);
        $this->convertData(json_encode($json));
        $this->convertDataToBill(json_encode($json));
	}
    public static function fromJson($data){
        if(!is_null($data)) {
            $billInformation= new BillInformation();
            $billInformation->convertData($data);
            $billInformation->convertDataToBill($data);
            return $billInformation;
        }
    }
}