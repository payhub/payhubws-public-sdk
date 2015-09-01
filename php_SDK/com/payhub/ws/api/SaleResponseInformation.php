<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 23/07/2015
 * Time: 12:35
 */
class SaleResponseInformation
{
    public $saleResponse;
    public $_links;
    public $errors;
    public $rowData;
    public $metaData;
    private $transactionManager;
    private $billInformation;
    private $cardDataInformation;
    private $customerInformation;
    private $merchantInformation;

    /**
     * @return mixed
     */
    public function getSaleResponse()
    {
        return $this->saleResponse;
    }

    /**
     * @param mixed $saleResponse
     */
    public function setSaleResponse($saleResponse)
    {
        $this->saleResponse = $saleResponse;
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
			$b->setUrl($this->transactionManager->getUrl()."sale/");
			$b->getBillForSaleInformationByTransactionId($this->saleResponse->getSaleId());
            $this->billInformation=$b;
		}
        return $this->billInformation;
    }
    /**
     * @return mixed
     */
    public function getCardDataInformation()
    {
        if($this->cardDataInformation==null){
            $c = new CardDataInformation($this->transactionManager);
			$c->getDataByTransaction(TransactionType::Sale, $this->saleResponse->getSaleId());
            $this->cardDataInformation=$c;
			}
        return $this->cardDataInformation;
    }
    /**
     * @return mixed
     */
    public function getCustomerInformation()
    {
        if($this->customerInformation==null){
            $c = new CustomerInformation($this->transactionManager);
            $c->setUrl($this->transactionManager->getUrl()."sale/");
			$c->getCustomerForSaleInformationByTransactionId($this->saleResponse->getSaleId());
			$this->customerInformation=$c;
        }
        return $this->customerInformation;
    }
    /**
     * @return mixed
     */
    public function getMerchantInformation()
    {
        if($this->merchantInformation==null){
            $m = new MerchantInformation($this->transactionManager);
            $m->getDataByTransaction(TransactionType::Sale, $this->saleResponse->getSaleId());
            $this->merchantInformation=$m;
        }
        return $this->merchantInformation;
    }

    public static function fromArray($data){
        $sale = new SaleResponseInformation();
        foreach ($data as $key => $value){
            if( property_exists( get_class($sale), $key ) ) {
                if($key=="saleResponse"){
                    $sale->{$key}=SaleResponse::fromArray($value);
                }elseif($key=="errors"){
                    $sale->{$key}=Errors::fromArray($value);
                }else{
                    $sale->{$key} = $value;
                }
            }
        }
        return $sale;
    }
}