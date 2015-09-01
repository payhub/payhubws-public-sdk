<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 23/07/2015
 * Time: 15:29
 */
class Customer
{
    public static $CUSTOMER_ID_FIELD = "customerId";

    /**
     * @return string
     */
    public static function getCUSTOMERIDFIELD()
    {
        return self::$CUSTOMER_ID_FIELD;
    }
    public $first_name;
    public $last_name;
    public $email_address;
    public $phone_number;
    public $phone_ext=""; // vt requires this set to an empty $if not present
    public $phone_type;
    public $company_name;
    public $job_title;
    public $web_address;
    public $customerReference;
    public $customerId;

    /**
     * @return mixed
     */
    public function getFirstName()
    {
        return $this->first_name;
    }

    /**
     * @param mixed $first_name
     */
    public function setFirstName($first_name)
    {
        $this->first_name = $first_name;
    }

    /**
     * @return mixed
     */
    public function getLastName()
    {
        return $this->last_name;
    }

    /**
     * @param mixed $last_name
     */
    public function setLastName($last_name)
    {
        $this->last_name = $last_name;
    }

    /**
     * @return mixed
     */
    public function getEmailAddress()
    {
        return $this->email_address;
    }

    /**
     * @param mixed $email_address
     */
    public function setEmailAddress($email_address)
    {
        $this->email_address = $email_address;
    }

    /**
     * @return mixed
     */
    public function getPhoneNumber()
    {
        return $this->phone_number;
    }

    /**
     * @param mixed $phone_number
     */
    public function setPhoneNumber($phone_number)
    {
        $this->phone_number = $phone_number;
    }

    /**
     * @return string
     */
    public function getPhoneExt()
    {
        return $this->phone_ext;
    }

    /**
     * @param string $phone_ext
     */
    public function setPhoneExt($phone_ext)
    {
        $this->phone_ext = $phone_ext;
    }

    /**
     * @return mixed
     */
    public function getPhoneType()
    {
        return $this->phone_type;
    }

    /**
     * @param mixed $phone_type
     */
    public function setPhoneType($phone_type)
    {
        $this->phone_type = $phone_type;
    }

    /**
     * @return mixed
     */
    public function getCompanyName()
    {
        return $this->company_name;
    }

    /**
     * @param mixed $company_name
     */
    public function setCompanyName($company_name)
    {
        $this->company_name = $company_name;
    }

    /**
     * @return mixed
     */
    public function getJobTitle()
    {
        return $this->job_title;
    }

    /**
     * @param mixed $job_title
     */
    public function setJobTitle($job_title)
    {
        $this->job_title = $job_title;
    }

    /**
     * @return mixed
     */
    public function getWebAddress()
    {
        return $this->web_address;
    }

    /**
     * @param mixed $web_address
     */
    public function setWebAddress($web_address)
    {
        $this->web_address = $web_address;
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
            $customer = new Customer();
            foreach ($data as $key => $value) {
                if (property_exists(get_class($customer), $key)) {
                    if ($key == "customerReference") {
                        $customer->{$key} = CustomerReference::fromArray($value);
                    }else{
                        $customer->{$key} = $value;
                    }
                }
            }
            return $customer;
        }
    }
}