<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 28/07/2015
 * Time: 09:19
 */
class RefundResponse
{
    public $saleTransactionId;

    public $refundTransactionId;

    public $token;

    public $approvalCode;

    public $processedDateTime;

    public $avsResultCode;

    public $verificationResultCode;

    public $batchId;

    public $responseCode;

    public $responseText;

    public $cisNote;

    public $riskStatusResponseText;

    public $riskStatusRespondeCode;

    public $refundDateTime;

    public $billingReferences;

    public $customerReference;

    /**
     * @return mixed
     */
    public function getSaleTransactionId()
    {
        return $this->saleTransactionId;
    }

    /**
     * @param mixed $saleTransactionId
     */
    public function setSaleTransactionId($saleTransactionId)
    {
        $this->saleTransactionId = $saleTransactionId;
    }

    /**
     * @return mixed
     */
    public function getRefundTransactionId()
    {
        return $this->refundTransactionId;
    }

    /**
     * @param mixed $refundTransactionId
     */
    public function setRefundTransactionId($refundTransactionId)
    {
        $this->refundTransactionId = $refundTransactionId;
    }

    /**
     * @return mixed
     */
    public function getToken()
    {
        return $this->token;
    }

    /**
     * @param mixed $token
     */
    public function setToken($token)
    {
        $this->token = $token;
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
    public function getRefundDateTime()
    {
        return $this->refundDateTime;
    }

    /**
     * @param mixed $refundDateTime
     */
    public function setRefundDateTime($refundDateTime)
    {
        $this->refundDateTime = $refundDateTime;
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
            $refund = new RefundResponse();

            foreach ($data as $key => $value) {
                if (property_exists(get_class($refund), $key)) {
                    if ($key == "billingReferences") {
                        $refund->{$key} = BillingReferences::fromArray($value);
                    } elseif ($key == "customerReference") {
                        $refund->{$key} = CustomerReference::fromArray($value);
                    } else {
                        $refund->{$key} = $value;
                    }

                }
            }
            return $refund;
        }
    }

}