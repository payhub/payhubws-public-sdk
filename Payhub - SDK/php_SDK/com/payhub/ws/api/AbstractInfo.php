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
        if(array_key_exists('version',$obj))
            $this->version = $obj->{'version'};
        if(array_key_exists('createdAt',$obj))
    	    $this->createdAt=$obj->{'createdAt'};
        if(array_key_exists('lastModified',$obj))
            $this->lastModified=$obj->{'lastModified'};
        if(array_key_exists('createdBy',$obj))
            $this->createdBy=$obj->{'createdBy'};
        if(array_key_exists('lastModifiedBy',$obj))
            $this->lastModifiedBy=$obj->{'lastModifiedBy'};
        if(array_key_exists('metaData',$obj))
            $this->metaData=$obj->{'metaData'};
	}
	public abstract function getUrlForTransactionType($type);
}