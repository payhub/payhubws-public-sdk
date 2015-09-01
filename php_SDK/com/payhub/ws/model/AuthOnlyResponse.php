<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 23/07/2015
 * Time: 12:28
 */
class AuthOnlyResponse
{
    private $transactionId;

    private $approvalCode;

    private $processedDateTime;

    private $avsResultCode;

    private $verificationResultCode;

    private $batchId;

    private $responseCode;

    private $responseText;

    private $cisNote;

    private $riskStatusResponseText;

    private $riskStatusRespondeCode;

    private $dateTime;

    private $tokenizedCard;

    private  $billingReferences;

    private  $customerReference;

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
    public function getApprovalCode()
    {
        return $this->approvalCode;
    }

    /**
     * @param mixed $approvalCode
     */
    public function setApprovalCode($approvalCode)
    {
        $this->approvalCode = $approvalCode;
    }

    /**
     * @return mixed
     */
    public function getProcessedDateTime()
    {
        return $this->processedDateTime;
    }

    /**
     * @param mixed $processedDateTime
     */
    public function setProcessedDateTime($processedDateTime)
    {
        $this->processedDateTime = $processedDateTime;
    }

    /**
     * @return mixed
     */
    public function getAvsResultCode()
    {
        return $this->avsResultCode;
    }

    /**
     * @param mixed $avsResultCode
     */
    public function setAvsResultCode($avsResultCode)
    {
        $this->avsResultCode = $avsResultCode;
    }

    /**
     * @return mixed
     */
    public function getVerificationResultCode()
    {
        return $this->verificationResultCode;
    }

    /**
     * @param mixed $verificationResultCode
     */
    public function setVerificationResultCode($verificationResultCode)
    {
        $this->verificationResultCode = $verificationResultCode;
    }

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
    public function getResponseCode()
    {
        return $this->responseCode;
    }

    /**
     * @param mixed $responseCode
     */
    public function setResponseCode($responseCode)
    {
        $this->responseCode = $responseCode;
    }

    /**
     * @return mixed
     */
    public function getResponseText()
    {
        return $this->responseText;
    }

    /**
     * @param mixed $responseText
     */
    public function setResponseText($responseText)
    {
        $this->responseText = $responseText;
    }

    /**
     * @return mixed
     */
    public function getCisNote()
    {
        return $this->cisNote;
    }

    /**
     * @param mixed $cisNote
     */
    public function setCisNote($cisNote)
    {
        $this->cisNote = $cisNote;
    }

    /**
     * @return mixed
     */
    public function getRiskStatusResponseText()
    {
        return $this->riskStatusResponseText;
    }

    /**
     * @param mixed $riskStatusResponseText
     */
    public function setRiskStatusResponseText($riskStatusResponseText)
    {
        $this->riskStatusResponseText = $riskStatusResponseText;
    }

    /**
     * @return mixed
     */
    public function getRiskStatusRespondeCode()
    {
        return $this->riskStatusRespondeCode;
    }

    /**
     * @param mixed $riskStatusRespondeCode
     */
    public function setRiskStatusRespondeCode($riskStatusRespondeCode)
    {
        $this->riskStatusRespondeCode = $riskStatusRespondeCode;
    }

    /**
     * @return mixed
     */
    public function getDateTime()
    {
        return $this->dateTime;
    }

    /**
     * @param mixed $dateTime
     */
    public function setDateTime($dateTime)
    {
        $this->dateTime = $dateTime;
    }

    /**
     * @return mixed
     */
    public function getTokenizedCard()
    {
        return $this->tokenizedCard;
    }

    /**
     * @param mixed $tokenizedCard
     */
    public function setTokenizedCard($tokenizedCard)
    {
        $this->tokenizedCard = $tokenizedCard;
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

    /**
     * @return mixed
     */
    public function getCustomerReference()
    {
        return $this->customerReference;
    }

    /**
     * @param mixed $customerReference
     */
    public function setCustomerReference($customerReference)
    {
        $this->customerReference = $customerReference;
    }
    public static function fromArray($data){
        if(!is_null($data)) {
            $auth = new AuthOnlyResponse();
            foreach ($data as $key => $value) {
                if ($key == "billingReferences") {
                    $auth->{$key} = BillingReferences::fromArray($value);
                } elseif ($key == "customerReference") {
                    $auth->{$key} = CustomerReference::fromArray($value);
                } else {
                    $auth->{$key} = $value;
                }
            }
            return $auth;
        }
    }

}