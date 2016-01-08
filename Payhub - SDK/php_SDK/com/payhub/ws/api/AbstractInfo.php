<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 09:26
 */
abstract class AbstractInfo
{
    protected $version;
    protected $createdAt;
    protected $lastModified;
    protected $createdBy;
    protected $lastModifiedBy;
    protected $metaData;
    protected $transactionManager;
    protected $transactionTsype;

    /**
     * AbstractInfo constructor.
     * @param $transactionManager
     */
    public function __construct($transactionManager)
    {
        if(!is_null($transactionManager)) {
            $this->transactionManager = $transactionManager;
        }
        $this->transactionType=TransactionType::Merchant;
    }
    public function getDataByID($id){
        $url = $this->transactionManager->getUrl().$this->getUrlForTransactionType($this.transactionType).$id;
        $request = $this->transactionManager->setHeadersGet($url, $this->transactionManager->getToken());
        $json=$this->transactionManager->doGet($request);
        $this->convertData(json_encode($json));
        $this->convertAbstractData(json_encode($json));
    }
    public function getDataByTransaction($type,$transactionId){
        $url=null;
		if(TransactionType::CardData==$this->transactionType){
            $url = $this->transactionManager->getUrl().$this->getUrlForTransactionType($type).$transactionId."/card_data";
        }else{
            $url = $this->transactionManager->getUrl().$this->getUrlForTransactionType($type).$transactionId."/".$this->getUrlForTransactionType($this->transactionType);
        }
		$request = $this->transactionManager->setHeadersGet($url, $this->transactionManager->getToken());
        $json=$this->transactionManager->doGet($request);
        $this->convertData(json_encode($json));
        $this->convertAbstractData(json_encode($json));
	}
	public abstract function convertData($json);

	public  function convertAbstractData($json){
        $obj = json_decode($json);
        $this->version=$obj->{'version'};
    	$this->createdAt=$obj->{'createdAt'};
        $this->lastModified=$obj->{'lastModified'};
        $this->createdBy=$obj->{'createdBy'};
        $this->lastModifiedBy=$obj->{'lastModifiedBy'};
        $this->metaData=$obj->{'metaData'};
	}
	public abstract function getUrlForTransactionType($type);
}