<?php
include_once 'TransactionAmount.php';
/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 23/07/2015
 * Time: 12:18
 */
class Bill
{

    public $note;

    public $po_number;

    public $invoice_number;

    public $customerId;

    public $customerCardId;

    public $tax_amount;

    public $base_amount;

    public $billingReferences;

    public $totalAmount;

    public $shipping_amount;

    /**
     * Bill constructor.
     */
    public function __construct()
    {
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
    public function getPoNumber()
    {
        return $this->po_number;
    }

    /**
     * @param mixed $po_number
     */
    public function setPoNumber($po_number)
    {
        $this->po_number = $po_number;
    }

    /**
     * @return mixed
     */
    public function getInvoiceNumber()
    {
        return $this->invoice_number;
    }

    /**
     * @param mixed $invoice_number
     */
    public function setInvoiceNumber($invoice_number)
    {
        $this->invoice_number = $invoice_number;
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
    public function getTaxAmount()
    {
        return $this->tax_amount;
    }

    /**
     * @param mixed $tax_amount
     */
    public function setTaxAmount($tax_amount)
    {
        $this->tax_amount = new TransactionAmount($tax_amount);
    }

    /**
     * @return mixed
     */
    public function getBaseAmount()
    {
        return $this->base_amount;
    }

    /**
     * @param mixed $base_amount
     */
    public function setBaseAmount($base_amount)
    {
        $this->base_amount = new TransactionAmount($base_amount);
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
    public function getTotalAmount()
    {
        return $this->totalAmount;
    }

    /**
     * @param mixed $totalAmount
     */
    public function setTotalAmount($totalAmount)
    {
        $this->totalAmount = new TransactionAmount($totalAmount);
    }

    /**
     * @return mixed
     */
    public function getShippingAmount()
    {
        return $this->shipping_amount;
    }

    /**
     * @param mixed $shipping_amount
     */
    public function setShippingAmount($shipping_amount)
    {
        $this->shipping_amount = new TransactionAmount($shipping_amount);
    }

    public function object_unset_nulls()
    {
        $arrObj = is_object($this) ? get_object_vars($this) : $this;
        foreach($arrObj as $key => $val)
        {
            $val = (is_array($val) || is_object($val)) ? object_unset_nulls($val) : $val;
            if (is_array($this))
                $this[$key] = $val;
            else
                $this->$key = $val;
            if($val == null)
                unset($this->$key);
        }
        return $this;
    }
    public static function fromArray($data){
        if(!is_null($data)) {
            $capture = new Bill();
            foreach ($data as $key => $value) {
                if (property_exists(get_class($capture), $key)) {
                    if ($key == "billingReferences") {
                        $capture->{$key} = BillingReferences::fromArray($value);
                    } elseif ($key == "tax_amount" || $key == "base_amount" || $key == "totalAmount" || $key == "shipping_amount") {
                        $capture->{$key} = TransactionAmount::fromArray($value);
                    } else {
                        $capture->{$key} = $value;
                    }
                }
            }
            return $capture;
        }
    }
}