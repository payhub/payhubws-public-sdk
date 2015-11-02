<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 11:31
 */
class RecurringBillResponse
{
    public $recurringBillId;
    public $customerReference;
    public $billingReferences;

    /**
     * @return mixed
     */
    public function getRecurringBillId()
    {
        return $this->recurringBillId;
    }

    /**
     * @return mixed
     */
    public function getCustomerReference()
    {
        return $this->customerReference;
    }

    /**
     * @return mixed
     */
    public function getBillingReferences()
    {
        return $this->billingReferences;
    }


    public static function fromArray($data){
        if(!is_null($data)) {
            $recurringBill = new RecurringBillResponse();

            foreach ($data as $key => $value) {
                if (property_exists(get_class($recurringBill), $key)) {
                    if ($key == "billingReferences") {
                        $recurringBill->{$key} = BillingReferences::fromArray($value);
                    } elseif ($key == "customerReference") {
                        $recurringBill->{$key} = CustomerReference::fromArray($value);
                    } else {
                        $recurringBill->{$key} = $value;
                    }
                }
            }
            return $recurringBill;
        }
    }
}