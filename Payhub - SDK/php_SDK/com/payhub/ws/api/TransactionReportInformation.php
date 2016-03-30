<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 11:08
 */
class TransactionReportInformation
{
    public $transactionID;
    public $batchID;
    public $transactionDate;
    public $customerName;
    public $cardType;
    public $cardLast4Digits;
    public $cardToken;
    public $responseCode;
    public $responseText;
    public $transactionType;
    public $amount;
    public $authAmount;
    public $swiped;
    public $source;
    public $phoneNumber;
    public $email;
    public $note;
    public $transactionStatus;
    public $errors;
	public $voidedBy;
	public $refundedBy;
	public $isCaptured;
    public $customerId;
    public $recurringBillId;

    /**
     * @return mixed
     */
    public function getTransactionID()
    {
        return $this->transactionID;
    }

    /**
     * @param mixed $transactionID
     */
    public function setTransactionID($transactionID)
    {
        $this->transactionID = $transactionID;
    }

    /**
     * @return mixed
     */
    public function getBatchID()
    {
        return $this->batchID;
    }

    /**
     * @param mixed $batchID
     */
    public function setBatchID($batchID)
    {
        $this->batchID = $batchID;
    }

    /**
     * @return mixed
     */
    public function getTransactionDate()
    {
        return $this->transactionDate;
    }

    /**
     * @param mixed $transactionDate
     */
    public function setTransactionDate($transactionDate)
    {
        $this->transactionDate = $transactionDate;
    }

    /**
     * @return mixed
     */
    public function getCustomerName()
    {
        return $this->customerName;
    }

    /**
     * @param mixed $customerName
     */
    public function setCustomerName($customerName)
    {
        $this->customerName = $customerName;
    }

    /**
     * @return mixed
     */
    public function getCardType()
    {
        return $this->cardType;
    }

    /**
     * @param mixed $cardType
     */
    public function setCardType($cardType)
    {
        $this->cardType = $cardType;
    }

    /**
     * @return mixed
     */
    public function getCardLast4Digits()
    {
        return $this->cardLast4Digits;
    }

    /**
     * @param mixed $cardLast4Digits
     */
    public function setCardLast4Digits($cardLast4Digits)
    {
        $this->cardLast4Digits = $cardLast4Digits;
    }

    /**
     * @return mixed
     */
    public function getCardToken()
    {
        return $this->cardToken;
    }

    /**
     * @param mixed $cardToken
     */
    public function setCardToken($cardToken)
    {
        $this->cardToken = $cardToken;
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
    public function getAmount()
    {
        return $this->amount;
    }

    /**
     * @param mixed $amount
     */
    public function setAmount($amount)
    {
        $this->amount = $amount;
    }

    /**
     * @return mixed
     */
    public function getAuthAmount()
    {
        return $this->authAmount;
    }

    /**
     * @param mixed $authAmount
     */
    public function setAuthAmount($authAmount)
    {
        $this->authAmount = $authAmount;
    }

    /**
     * @return mixed
     */
    public function getSwiped()
    {
        return $this->swiped;
    }

    /**
     * @param mixed $swiped
     */
    public function setSwiped($swiped)
    {
        $this->swiped = $swiped;
    }

    /**
     * @return mixed
     */
    public function getSource()
    {
        return $this->source;
    }

    /**
     * @param mixed $source
     */
    public function setSource($source)
    {
        $this->source = $source;
    }

    /**
     * @return mixed
     */
    public function getPhoneNumber()
    {
        return $this->phoneNumber;
    }

    /**
     * @param mixed $phoneNumber
     */
    public function setPhoneNumber($phoneNumber)
    {
        $this->phoneNumber = $phoneNumber;
    }

    /**
     * @return mixed
     */
    public function getEmail()
    {
        return $this->email;
    }

    /**
     * @param mixed $email
     */
    public function setEmail($email)
    {
        $this->email = $email;
    }

    /**
     * @return mixed
     */
    public function getNote()
    {
        return $this->note;
    }

    /**
     * @param mixed $note
     */
    public function setNote($note)
    {
        $this->note = $note;
    }

    /**
     * @return mixed
     */
    public function getTransactionStatus()
    {
        return $this->transactionStatus;
    }

    /**
     * @param mixed $transactionStatus
     */
    public function setTransactionStatus($transactionStatus)
    {
        $this->transactionStatus = $transactionStatus;
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
    public function getVoidedBy()
    {
        return $this->voidedBy;
    }

    /**
     * @param mixed $voidedBy
     */
    public function setVoidedBy($voidedBy)
    {
        $this->voidedBy = $voidedBy;
    }

    /**
     * @return mixed
     */
    public function getRefundedBy()
    {
        return $this->refundedBy;
    }

    /**
     * @param mixed $refundedBy
     */
    public function setRefundedBy($refundedBy)
    {
        $this->refundedBy = $refundedBy;
    }

    /**
     * @return mixed
     */
    public function getIsCaptured()
    {
        return $this->isCaptured;
    }

    /**
     * @param mixed $isCaptured
     */
    public function setIsCaptured($isCaptured)
    {
        $this->isCaptured = $isCaptured;
    }

    /**
     * @return mixed
     */
    public function getCustomerId()
    {
        return $this->customerId;
    }

    /**
     * @param mixed $customerId
     */
    public function setCustomerId($customerId)
    {
        $this->customerId = $customerId;
    }

    /**
     * @return mixed
     */
    public function getRecurringBillId()
    {
        return $this->recurringBillId;
    }

    /**
     * @param mixed $recurringBillId
     */
    public function setRecurringBillId($recurringBillId)
    {
        $this->recurringBillId = $recurringBillId;
    }

    

    public static function fromArray($data){
        if(!is_null($data)) {
            $err=null;
            $tri = new TransactionReportInformation();
            foreach ($data as $key => $value) {
                if (property_exists(get_class($tri), $key)) {
                   $tri->{$key} = $value;
                }else{
                    $err[]=$value;
                }
            }
            if(!is_null($err)){
                $tri->errors=Errors::fromArray($err);
            }
            return $tri;
        }
    }
}