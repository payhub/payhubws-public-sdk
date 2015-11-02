<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 10:08
 */
class CaptureResponseInformation
{
    public $lastCaptureResponse;
    public $_links;
    public $errors;
    public $rowData;
    public $metaData;
    private $transactionManager;
    private $billInformation;
    private $merchantInformation;

    /**
     * @return mixed
     */
    public function getLastCaptureResponse()
    {
        return $this->lastCaptureResponse;
    }

    /**
     * @param mixed $lastCaptureResponse
     */
    public function setLastCaptureResponse($lastCaptureResponse)
    {
        $this->lastCaptureResponse = $lastCaptureResponse;
    }

    /**
     * @return mixed
     */
    public function getLinks()
    {
        return $this->_links;
    }

    /**
     * @param mixed $links
     */
    public function setLinks($links)
    {
        $this->_links = $links;
    }

    /**
     * @return mixed
     */
    public function getErrors()
    {
        return $this->errors;
    }

    /**
     * @param mixed $errors
     */
    public function setErrors($errors)
    {
        $this->errors = $errors;
    }

    /**
     * @return mixed
     */
    public function getRowData()
    {
        return $this->rowData;
    }

    /**
     * @param mixed $rowData
     */
    public function setRowData($rowData)
    {
        $this->rowData = $rowData;
    }

    /**
     * @return mixed
     */
    public function getMetaData()
    {
        return $this->metaData;
    }

    /**
     * @param mixed $metaData
     */
    public function setMetaData($metaData)
    {
        $this->metaData = $metaData;
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
    public function getBillInformation()
    {
        if($this->billInformation==null){
            $b = new BillInformation($this->transactionManager);
			$b->setUrl($this->transactionManager->getUrl()."capture/");
			$b->getBillForSaleInformationByTransactionId($this->lastCaptureResponse->getTransactionId());
			$this->billInformation=$b;
		}
        return $this->billInformation;
    }

    /**
     * @return mixed
     */
    public function getMerchantInformation()
    {
        if($this->merchantInformation==null){
            $m = new MerchantInformation($this->transactionManager);
				$m->getDataByTransaction(TransactionType::Capture, $this->lastCaptureResponse->getTransactionId());
				$this->merchantInformation=$m;
			}
        return $this->merchantInformation;
    }

    public static function fromArray($data){
        $capture = new CaptureResponseInformation();

        foreach ($data as $key => $value){
            if( property_exists( get_class($capture), $key ) ) {
                if($key=="lastCaptureResponse"){
                    $capture->{$key}=CaptureResponse::fromArray($value);
                }elseif($key=="errors"){
                    $capture->{$key}=Errors::fromArray($value);
                }
                else{
                    $capture->{$key} = $value;
                }
            }
        }
        return $capture;
    }
}