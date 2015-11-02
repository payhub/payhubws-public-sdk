<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 23/07/2015
 * Time: 12:32
 */
class BillingReferences
{
    public $cardObscured;
    public $tokenizedCard;
    public $customerId;
    public $customerCardId;
    public $customerBillId;

    /**
     * @return mixed
     */
    public function getCardObscured()
    {
        return $this->cardObscured;
    }

    /**
     * @param mixed $cardObscured
     */
    public function setCardObscured($cardObscured)
    {
        $this->cardObscured = $cardObscured;
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
    public function getCustomerCardId()
    {
        return $this->customerCardId;
    }

    /**
     * @param mixed $customerCardId
     */
    public function setCustomerCardId($customerCardId)
    {
        $this->customerCardId = $customerCardId;
    }

    /**
     * @return mixed
     */
    public function getCustomerBillId()
    {
        return $this->customerBillId;
    }

    /**
     * @param mixed $customerBillId
     */
    public function setCustomerBillId($customerBillId)
    {
        $this->customerBillId = $customerBillId;
    }

    public static function fromArray($data){
        if(!is_null($data)) {
            $billReference = new BillingReferences();
            foreach ($data as $key => $value) {
                if (property_exists(get_class($billReference), $key)) {
                    $billReference->{$key} = $value;
                }
            }
            return $billReference;
        }
    }

}