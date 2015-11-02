<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 11:13
 */
class VerifyResponse
{
    public $verifyId;
    public $approvalCode;
    public $processedDateTime;
    public $avsResultCode;
    public $verificationResultCode;
    public $responseCode;
    public $responseText;
    public $cisNote;
    public $riskStatusResponseText;
    public $riskStatusRespondeCode;
    public $saleDateTime;
    public $tokenizedCard;
    public $customerReference;

    /**
     * @return mixed
     */
    public function getVerifyId()
    {
        return $this->verifyId;
    }

    /**
     * @return mixed
     */
    public function getApprovalCode()
    {
        return $this->approvalCode;
    }

    /**
     * @return mixed
     */
    public function getProcessedDateTime()
    {
        return $this->processedDateTime;
    }

    /**
     * @return mixed
     */
    public function getAvsResultCode()
    {
        return $this->avsResultCode;
    }

    /**
     * @return mixed
     */
    public function getVerificationResultCode()
    {
        return $this->verificationResultCode;
    }

    /**
     * @return mixed
     */
    public function getResponseCode()
    {
        return $this->responseCode;
    }

    /**
     * @return mixed
     */
    public function getResponseText()
    {
        return $this->responseText;
    }

    /**
     * @return mixed
     */
    public function getCisNote()
    {
        return $this->cisNote;
    }

    /**
     * @return mixed
     */
    public function getRiskStatusResponseText()
    {
        return $this->riskStatusResponseText;
    }

    /**
     * @return mixed
     */
    public function getRiskStatusRespondeCode()
    {
        return $this->riskStatusRespondeCode;
    }

    /**
     * @return mixed
     */
    public function getSaleDateTime()
    {
        return $this->saleDateTime;
    }

    /**
     * @return mixed
     */
    public function getTokenizedCard()
    {
        return $this->tokenizedCard;
    }

    /**
     * @return mixed
     */
    public function getCustomerReference()
    {
        return $this->customerReference;
    }

    public static function fromArray($data){
        if(!is_null($data)) {
            $verif = new VerifyResponse();
            foreach ($data as $key => $value) {
                if (property_exists(get_class($verif), $key)) {
                    if ($key == "customerReference") {
                        $verif->{$key} = $value;
                    }else{
                        $verif->{$key} = $value;
                    }
                }
            }
            return $verif;
        }
    }
}