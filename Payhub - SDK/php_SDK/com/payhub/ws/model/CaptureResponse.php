<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 11:36
 */
class CaptureResponse
{
    public $batchId;
    public $transactionId;
    public $billingReferences;

    /**
     * @return mixed
     */
    public function getBatchId()
    {
        return $this->batchId;
    }

    /**
     * @param mixed $batchId
     */
    public function setBatchId($batchId)
    {
        $this->batchId = $batchId;
    }

    /**
     * @return mixed
     */
    public function getTransactionId()
    {
        return $this->transactionId;
    }

    /**
     * @param mixed $transactionId
     */
    public function setTransactionId($transactionId)
    {
        $this->transactionId = $transactionId;
    }

    /**
     * @return mixed
     */
    public function getBillingReferences()
    {
        return $this->billingReferences;
    }

    /**
     * @param mixed $billingReferences
     */
    public function setBillingReferences($billingReferences)
    {
        $this->billingReferences = $billingReferences;
    }

    public static function fromArray($data){
        if(!is_null($data)) {
            $capture = new CaptureResponse();
            foreach ($data as $key => $value) {
                if ($key == "billingReferences") {
                    $capture->{$key} = BillingReferences::fromArray($value);
                } elseif ($key == "customerReference") {
                    $capture->{$key} = CustomerReference::fromArray($value);
                } else {
                    $capture->{$key} = $value;
                }
            }
            return $capture;
        }
    }

}